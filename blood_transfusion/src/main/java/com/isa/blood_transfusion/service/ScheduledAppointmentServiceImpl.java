package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.*;
import com.isa.blood_transfusion.repository.CenterRepository;
import com.isa.blood_transfusion.store.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Service
public class ScheduledAppointmentServiceImpl implements  ScheduledAppointmentService {

    private final ScheduledAppointmentStore store;
    private final CenterStore centerStore;
    private final FreeAppointmentStore freeAppointmentStore;
    private final RegisteredUserStore registeredUserStore;
    private final BloodDonorInfoStore bloodDonorInfoStore;
    private final FreeAppointmentService freeAppointmentService;
    private final CenterRepository centerRepository;
    private final QrCodeGeneratorService qrCodeGeneratorService;

    @Override
    public ScheduledAppointment save(ScheduledAppointment scheduledAppointment) {
        return store.save(scheduledAppointment);
    }

    @Override
    public ScheduledAppointment create(Long freeAppointmentId, Long registeredUserId) {
        FreeAppointment freeAppointment = freeAppointmentStore.getById(freeAppointmentId);
        RegisteredUser registeredUser = registeredUserStore.getById(registeredUserId);
        BloodDonorInfo bloodDonorInfo = bloodDonorInfoStore.getByRegisteredUserId(registeredUserId);
        ScheduledAppointment scheduledAppointment = new ScheduledAppointment(0L, freeAppointment.getDate(), freeAppointment.getDuration(), freeAppointment.getCenter(), freeAppointment.getMedicalStaff(), bloodDonorInfo, registeredUser);
        String qrCodeContent = "Your appointment is scheduled for " + scheduledAppointment.getDate().toString() + ". Duration of appointment is " + scheduledAppointment.getDuration() + ". Appointment will be performed in " + scheduledAppointment.getCenter().getName() + "center.";
        if (qrCodeGeneratorService.generateQrCode(qrCodeContent, "C:\\Users\\KORISNIK\\Desktop\\ISA-backend\\ISA-project-backend\\blood_transfusion\\qrcodes\\" + scheduledAppointment.getRegisteredUser().getId() + ".png", 400, 400)) {
            System.out.println("QR code generated!");
        }
        freeAppointmentStore.delete(freeAppointment);
        return store.save(scheduledAppointment);

    }

    @Override
    public ScheduledAppointment specificSchedule(String dateString,Long registeredUserId,Long centerId) {

        LocalDateTime date = LocalDateTime.parse(dateString);
        Center center = centerStore.getById(centerId);
        MedicalStaff medicalStaff = freeAppointmentStore.getEmployedMedicalStaff(centerId);

        if(freeAppointmentService.hasCenterFreeAppointment(centerId) == true) {

            FreeAppointment freeAppointment = freeAppointmentStore.getByDateAndCenter(date,centerId);
            RegisteredUser registeredUser = registeredUserStore.getById(registeredUserId);
            BloodDonorInfo bloodDonorInfo = bloodDonorInfoStore.getByRegisteredUserId(registeredUserId);
            ScheduledAppointment scheduledAppointment = new ScheduledAppointment(0L, freeAppointment.getDate(), freeAppointment.getDuration(), freeAppointment.getCenter(), freeAppointment.getMedicalStaff(), bloodDonorInfo, registeredUser);
            freeAppointmentStore.delete(freeAppointment);
            return store.save(scheduledAppointment);
        }

        else {

            RegisteredUser registeredUser = registeredUserStore.getById(registeredUserId);
            BloodDonorInfo bloodDonorInfo = bloodDonorInfoStore.getByRegisteredUserId(registeredUserId);
            ScheduledAppointment scheduledAppointment = new ScheduledAppointment(0L, date, 15, center, medicalStaff, bloodDonorInfo, registeredUser);
            return store.save(scheduledAppointment);
        }
    }




}
