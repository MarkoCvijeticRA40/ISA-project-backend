package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.BloodDonorInfo;

public interface BloodDonorInfoService {
    BloodDonorInfo save(BloodDonorInfo bloodDonorInfo);
    Boolean isDonorInfoFilled(Long registeredUserId);
}
