package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.UserCategoryEntity;
import com.isa.blood_transfusion.model.UserCategory;
import org.springframework.stereotype.Component;

@Component
public class UserCategoryConverter {

    public UserCategory toModel(UserCategoryEntity userCategoryEntity) {
        return new UserCategory(userCategoryEntity.getId(), userCategoryEntity.getName(), userCategoryEntity.getBenefit());
    }
}
