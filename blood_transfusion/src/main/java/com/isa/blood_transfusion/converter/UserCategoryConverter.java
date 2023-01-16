package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.UserCategoryEntity;
import com.isa.blood_transfusion.model.UserCategory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserCategoryConverter {

    public UserCategory toModel(UserCategoryEntity userCategoryEntity) {
        if (userCategoryEntity == null) {
            return null;
        } else {
            return new UserCategory(userCategoryEntity.getId(), userCategoryEntity.getName(), userCategoryEntity.getBenefit());
        }
    }

    public Set<UserCategory> toModel(Set<UserCategoryEntity> userCategoryEntities) {
        Set<UserCategory> userCategories = new HashSet<>();
        for (var u : userCategoryEntities) {
            userCategories.add(new UserCategory(u.getId(), u.getName(), u.getBenefit()));
        }

        return userCategories;
    }

    public UserCategoryEntity toEntity(UserCategory userCategory) {
        return new UserCategoryEntity(userCategory.getId(), userCategory.getName(), userCategory.getBenefit());
    }

    public Set<UserCategoryEntity> toEntity(Set<UserCategory> userCategories) {
        Set<UserCategoryEntity> userCategoryEntities = new HashSet<>();
        for (var u : userCategories) {
            userCategoryEntities.add(new UserCategoryEntity(u.getId(), u.getName(), u.getBenefit()));
        }

        return userCategoryEntities;
    }
}
