package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.Center;

import java.util.List;

public interface CenterService {
    List<Center> findAll();
    Center getById(Long id);
}
