package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.model.Center;

import java.util.List;

public interface CenterStore {
    List<Center> findAll();
    Center getById(Long id);
}
