package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.converter.BloodDonorInfoConverter;
import com.isa.blood_transfusion.model.BloodDonorInfo;
import com.isa.blood_transfusion.repository.BloodDonorInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BloodDonorInfoStoreImpl implements BloodDonorInfoStore {
    private final BloodDonorInfoRepository repository;
    private final BloodDonorInfoConverter converter;

    @Override
    public BloodDonorInfo save(BloodDonorInfo bloodDonorInfo) {
        repository.save(converter.toEntity(bloodDonorInfo));
        return bloodDonorInfo;
    }

    @Override
    public BloodDonorInfo getByRegisteredUserId(Long registeredUserId) {
        return converter.toModel(repository.findBloodDonorInfoEntityByRegisteredUserId(registeredUserId));
    }

    @Override
    public Boolean isDonorInfoFilled(Long registeredUserId) {
        if (getByRegisteredUserId(registeredUserId) == null)
            return false;
        return true;
    }
}
