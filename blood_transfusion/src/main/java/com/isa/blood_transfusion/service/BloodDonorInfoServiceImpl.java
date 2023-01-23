package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.BloodDonorInfo;
import com.isa.blood_transfusion.repository.store.BloodDonorInfoStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@Service
public class BloodDonorInfoServiceImpl implements BloodDonorInfoService {
    private final BloodDonorInfoStore store;

    @Override
    public BloodDonorInfo save(BloodDonorInfo bloodDonorInfo) {
        return store.save(bloodDonorInfo);
    }

    @Override
    public Boolean isDonorInfoFilled(Long registeredUserId) {
        return store.isDonorInfoFilled(registeredUserId);
    }
}
