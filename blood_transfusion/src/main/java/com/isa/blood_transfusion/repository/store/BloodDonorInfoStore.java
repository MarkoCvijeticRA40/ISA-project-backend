package com.isa.blood_transfusion.repository.store;

import com.isa.blood_transfusion.model.BloodDonorInfo;

public interface BloodDonorInfoStore {
    BloodDonorInfo save(BloodDonorInfo bloodDonorInfo);
}
