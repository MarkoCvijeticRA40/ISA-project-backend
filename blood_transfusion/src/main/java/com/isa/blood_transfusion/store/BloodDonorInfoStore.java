package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.model.BloodDonorInfo;

public interface BloodDonorInfoStore {
    BloodDonorInfo save(BloodDonorInfo bloodDonorInfo);
}
