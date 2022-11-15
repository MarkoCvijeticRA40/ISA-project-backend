package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.model.Role;
import com.isa.blood_transfusion.model.UserCategory;

public interface UserCategoryStore {
    UserCategory save(UserCategory userCategory);
    UserCategory find(String name);
}
