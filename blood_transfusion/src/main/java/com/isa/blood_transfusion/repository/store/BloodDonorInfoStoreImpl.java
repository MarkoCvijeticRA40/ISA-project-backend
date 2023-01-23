package com.isa.blood_transfusion.repository.store;

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
}
