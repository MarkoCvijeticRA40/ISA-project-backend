package com.isa.blood_transfusion.repository.store;

import com.isa.blood_transfusion.model.Blood;
import com.isa.blood_transfusion.model.BloodDonorInfo;

public interface BloodDonorInfoStore {
    BloodDonorInfo save(BloodDonorInfo bloodDonorInfo);
    BloodDonorInfo getByRegisteredUserId(Long registeredUserId);
    Boolean isDonorInfoFilled(Long registeredUserId);

}
