package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.model.RegisteredUser;

public interface RegisteredUserStore {
    RegisteredUser findByEmail(String email);
}
