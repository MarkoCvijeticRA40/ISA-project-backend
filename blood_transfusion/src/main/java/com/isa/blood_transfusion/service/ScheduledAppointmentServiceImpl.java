package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.*;
import com.isa.blood_transfusion.repository.CenterRepository;
import com.isa.blood_transfusion.store.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
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
    private final CanceledAppointmentStore canceledAppointmentStore;

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
        String currentTime = LocalDateTime.now().toString().replace(":", "-");
        if (qrCodeGeneratorService.generateQrCode(qrCodeContent, "C:\\Users\\KORISNIK\\Desktop\\ISA-backend\\ISA-project-backend\\blood_transfusion\\qrcodes\\" + scheduledAppointment.getRegisteredUser().getId() + "\\" + currentTime  +".png", 400, 400)) {
            System.out.println("QR code generated!");
        }
        try {
            emailService.sendEmail(scheduledAppointment.getRegisteredUser().getEmail(), "Notification about your appointment", "Scan this QR code in order to get information about your appointment.", "C:\\Users\\KORISNIK\\Desktop\\ISA-backend\\ISA-project-backend\\blood_transfusion\\qrcodes\\" + scheduledAppointment.getRegisteredUser().getId() + "\\" + currentTime  +".png");
        }
        catch ( MessagingException m) {
            System.out.println(m.getMessage());
        }
        freeAppointmentStore.delete(freeAppointment);
        return store.save(scheduledAppointment);

    }

    @Override
    public List<ScheduledAppointment> findAll() {
        return store.findAll();
    }

    @Override
    public List<ScheduledAppointment> findByCenterId(Long id) {
        return store.findByCenterId(id);
    }

    public ScheduledAppointment specificSchedule(String dateString,Long registeredUserId,Long centerId) {
        LocalDateTime date = LocalDateTime.parse(dateString);
        Center center = centerStore.getById(centerId);
        MedicalStaff medicalStaff = freeAppointmentStore.getEmployedMedicalStaff(centerId);
        if(freeAppointmentService.hasCenterFreeAppointmentInThisTerm(centerId,date) == true) {
            FreeAppointment freeAppointment = freeAppointmentStore.getByDateAndCenter(date,centerId);
            RegisteredUser registeredUser = registeredUserStore.getById(registeredUserId);
            BloodDonorInfo bloodDonorInfo = bloodDonorInfoStore.getByRegisteredUserId(registeredUserId);
            ScheduledAppointment scheduledAppointment = new ScheduledAppointment(0L, date, freeAppointment.getDuration(), freeAppointment.getCenter(), freeAppointment.getMedicalStaff(), bloodDonorInfo, registeredUser);
            String qrCodeContent = "Your appointment is scheduled for " + scheduledAppointment.getDate().toString() + ". Duration of appointment is " + scheduledAppointment.getDuration() + " minutes. Appointment will be performed in " + scheduledAppointment.getCenter().getName()  + " " + "center(" + scheduledAppointment.getCenter().getAddress().getStreet() + " " + scheduledAppointment.getCenter().getAddress().getNumber() + ").";
            folderService.createFolder("C:\\Users\\marko\\Desktop\\ISA\\ISA-project-backend\\blood_transfusion\\qrcodes\\" + scheduledAppointment.getRegisteredUser().getId());
            String currentTime = LocalDateTime.now().toString().replace(":", "-");
            if (qrCodeGeneratorService.generateQrCode(qrCodeContent, "C:\\Users\\marko\\Desktop\\ISA\\ISA-project-backend\\blood_transfusion\\qrcodes\\" + scheduledAppointment.getRegisteredUser().getId() + "\\" + currentTime  +".png", 400, 400)) {
                System.out.println("QR code generated!");
            }
            try {
                emailService.sendEmail(scheduledAppointment.getRegisteredUser().getEmail(), "Notification about your appointment", "Scan this QR code in order to get information about your appointment.", "C:\\Users\\marko\\Desktop\\ISA\\ISA-project-backend\\blood_transfusion\\qrcodes\\" + scheduledAppointment.getRegisteredUser().getId() + "\\" + currentTime  +".png");
            }
            catch ( MessagingException m) {
                System.out.println(m.getMessage());
            }
            freeAppointmentStore.delete(freeAppointment);
            return store.save(scheduledAppointment);
        }
        else {
            RegisteredUser registeredUser = registeredUserStore.getById(registeredUserId);
            BloodDonorInfo bloodDonorInfo = bloodDonorInfoStore.getByRegisteredUserId(registeredUserId);
            ScheduledAppointment scheduledAppointment = new ScheduledAppointment(0L, date, 15, center, medicalStaff, bloodDonorInfo, registeredUser);
            String qrCodeContent = "Your appointment is scheduled for " + scheduledAppointment.getDate().toString() + ". Duration of appointment is " + scheduledAppointment.getDuration() + " minutes. Appointment will be performed in " + scheduledAppointment.getCenter().getName()  + " " + "center(" + scheduledAppointment.getCenter().getAddress().getStreet() + " " + scheduledAppointment.getCenter().getAddress().getNumber() + ").";
            folderService.createFolder("C:\\Users\\marko\\Desktop\\ISA\\ISA-project-backend\\blood_transfusion\\qrcodes\\" + scheduledAppointment.getRegisteredUser().getId());
            String currentTime = LocalDateTime.now().toString().replace(":", "-");
            if (qrCodeGeneratorService.generateQrCode(qrCodeContent, "C:\\Users\\marko\\Desktop\\ISA\\ISA-project-backend\\blood_transfusion\\qrcodes\\" + scheduledAppointment.getRegisteredUser().getId() + "\\" + currentTime  +".png", 400, 400)) {
                System.out.println("QR code generated!");
            }
            try {
                emailService.sendEmail(scheduledAppointment.getRegisteredUser().getEmail(), "Notification about your appointment", "Scan this QR code in order to get information about your appointment.", "C:\\Users\\marko\\Desktop\\ISA\\ISA-project-backend\\blood_transfusion\\qrcodes\\" + scheduledAppointment.getRegisteredUser().getId() + "\\" + currentTime  +".png");
            }
            catch ( MessagingException m) {
                System.out.println(m.getMessage());
            }
            return store.save(scheduledAppointment);
        }
    }

    @Override
    public List<ScheduledAppointment> get(Long registeredUserId) {
        return store.get(registeredUserId);
    }

    public boolean isDateValid(ScheduledAppointment scheduledAppointment) {

        List<ScheduledAppointment> scheduledAppointments = store.findByCenterId(scheduledAppointment.getCenter().getId());
        scheduledAppointment.setDate(scheduledAppointment.getDate().plusHours(1));

        LocalDateTime scheduledAppointmentEnd;
        scheduledAppointmentEnd = scheduledAppointment.getDate().plusMinutes(scheduledAppointment.getDuration());

        List<FreeAppointment> freeAppointments = freeAppointmentStore.findByCenterId(scheduledAppointment.getCenter().getId());

        for (ScheduledAppointment scheApp : scheduledAppointments) {

            LocalDateTime scheAppEnd;
            scheAppEnd = scheApp.getDate().plusMinutes(scheApp.getDuration());

            if (isDateOverlapping(scheduledAppointment.getDate(), scheduledAppointmentEnd, scheApp.getDate(), scheAppEnd) == true) {

                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isDateOverlapping(LocalDateTime start1, LocalDateTime end1, LocalDateTime start2, LocalDateTime end2) {
        return start2.isBefore(end1) && end2.isAfter(start1);
    }

    @Override
    public ScheduledAppointment cancelAppointment(Long scheduledAppointmentId,Long registeredUserId) {
        ScheduledAppointment scheduledAppointment = store.getById(scheduledAppointmentId);
        RegisteredUser registeredUser = registeredUserStore.getById(registeredUserId);
        CanceledAppointment canceledAppointment = new CanceledAppointment(0L, scheduledAppointment.getCenter(), scheduledAppointment.getDate(), registeredUser);
        FreeAppointment freeAppointment = new FreeAppointment(0L, scheduledAppointment.getDate(), scheduledAppointment.getDuration(), scheduledAppointment.getCenter(), scheduledAppointment.getMedicalStaff());
        freeAppointmentStore.save(freeAppointment);
        canceledAppointmentStore.save(canceledAppointment);
        return store.delete(scheduledAppointment);
    }

    @Override
    public Boolean isAppointmentInNext24Hours(Long scheduledAppointmentId) {
        ScheduledAppointment scheduledAppointment = store.getById(scheduledAppointmentId);
        return scheduledAppointment.getDate().minusDays(1).isBefore(LocalDateTime.now());
    }

}
