package com.isa.blood_transfusion.service;
import com.isa.blood_transfusion.store.FreeAppointmentStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@Service
public class FreeAppointmentServiceImpl implements  FreeAppointmentService{

    private final FreeAppointmentStore store;



}
