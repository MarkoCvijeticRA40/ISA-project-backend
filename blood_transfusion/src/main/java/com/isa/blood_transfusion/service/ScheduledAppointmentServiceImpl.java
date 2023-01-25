package com.isa.blood_transfusion.service;


import com.isa.blood_transfusion.model.BloodDonorInfo;
import com.isa.blood_transfusion.model.FreeAppointment;
import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.model.ScheduledAppointment;
import com.isa.blood_transfusion.store.BloodDonorInfoStore;
import com.isa.blood_transfusion.store.FreeAppointmentStore;
import com.isa.blood_transfusion.store.RegisteredUserStore;
import com.isa.blood_transfusion.store.ScheduledAppointmentStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@Service
public class ScheduledAppointmentServiceImpl implements  ScheduledAppointmentService {

    private final ScheduledAppointmentStore store;
    private final FreeAppointmentStore freeAppointmentStore;
    private final RegisteredUserStore registeredUserStore;
    private final BloodDonorInfoStore bloodDonorInfoStore;
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

}
