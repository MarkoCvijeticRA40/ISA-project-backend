package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.*;
import com.isa.blood_transfusion.repository.CenterRepository;
import com.isa.blood_transfusion.store.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


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
    private final EmailService emailService;
    private final FolderService folderService;

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
        String qrCodeContent = "Your appointment is scheduled for " + scheduledAppointment.getDate().toString() + ". Duration of appointment is " + scheduledAppointment.getDuration() + " minutes. Appointment will be performed in " + scheduledAppointment.getCenter().getName()  + " " + "center(" + scheduledAppointment.getCenter().getAddress().getStreet() + " " + scheduledAppointment.getCenter().getAddress().getNumber() + ").";
        folderService.createFolder("C:\\Users\\KORISNIK\\Desktop\\ISA-backend\\ISA-project-backend\\blood_transfusion\\qrcodes\\" + scheduledAppointment.getRegisteredUser().getId());
        if (qrCodeGeneratorService.generateQrCode(qrCodeContent, "C:\\Users\\KORISNIK\\Desktop\\ISA-backend\\ISA-project-backend\\blood_transfusion\\qrcodes\\" + scheduledAppointment.getRegisteredUser().getId() + "\\" + LocalDateTime.now().toString().replace(":", "-")  +".png", 400, 400)) {
            System.out.println("QR code generated!");
        }
        try {
            emailService.sendEmail(scheduledAppointment.getRegisteredUser().getEmail(), "Notification about your appointment", "Scan this QR code in order to get information about your appointment.", "C:\\Users\\KORISNIK\\Desktop\\ISA-backend\\ISA-project-backend\\blood_transfusion\\qrcodes\\" + scheduledAppointment.getRegisteredUser().getId() + "\\" + LocalDateTime.now()  +".png");
        }
        catch ( MessagingException m) {
            System.out.println(m.getMessage());
        }
        freeAppointmentStore.delete(freeAppointment);
        return store.save(scheduledAppointment);

    }

    @Override
    public ScheduledAppointment specificSchedule(String dateString,Long registeredUserId,Long centerId) {
        LocalDateTime date = LocalDateTime.parse(dateString);
        Center center = centerStore.getById(centerId);
        MedicalStaff medicalStaff = freeAppointmentStore.getEmployedMedicalStaff(centerId);
        if(freeAppointmentService.hasCenterFreeAppointmentInThisTerm(centerId,date) == true) {
            FreeAppointment freeAppointment = freeAppointmentStore.getByDateAndCenter(date,centerId);
            RegisteredUser registeredUser = registeredUserStore.getById(registeredUserId);
            BloodDonorInfo bloodDonorInfo = bloodDonorInfoStore.getByRegisteredUserId(registeredUserId);
            ScheduledAppointment scheduledAppointment = new ScheduledAppointment(0L, date, freeAppointment.getDuration(), freeAppointment.getCenter(), freeAppointment.getMedicalStaff(), bloodDonorInfo, registeredUser);
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


    @Override
    public List<ScheduledAppointment> get(Long registeredUserId) {
        return store.get(registeredUserId);
    }

}
