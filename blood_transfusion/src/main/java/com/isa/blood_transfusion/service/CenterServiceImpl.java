package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.Center;
import com.isa.blood_transfusion.store.CenterStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Service
public class CenterServiceImpl implements CenterService {
    private final CenterStore store;

    @Override
    public Center save(Center center) {
        return store.save(center);
    }

    @Override
    public List<Center> findAll() {
        return store.findAll();
    }

    @Override
    public Center getById(Long id) {
        return store.getById(id);
    }

    @Override
    public List<Center> getSortedByNameAsc() {
        return store.getSortedByNameAsc();
    }

    @Override
    public List<Center> getSortedByNameDesc() {
        return store.getSortedByNameDesc();
    }

    @Override
    public List<Center> getSortedByAvgGradeAsc() {
        return store.getSortedByAvgGradeAsc();
    }

    @Override
    public List<Center> getSortedByAvgGradeDesc() {
        return store.getSortedByAvgGradeDesc();
    }
}
