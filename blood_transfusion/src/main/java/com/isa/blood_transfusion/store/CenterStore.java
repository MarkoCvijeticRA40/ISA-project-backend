package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.model.Center;
import com.isa.blood_transfusion.model.RegisteredUser;

import java.util.List;

public interface CenterStore {

    Center save(Center center);
    List<Center> findAll();
    Center getById(Long id);
}
