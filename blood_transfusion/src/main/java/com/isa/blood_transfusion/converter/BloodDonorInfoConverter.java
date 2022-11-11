package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.BloodDonorInfoEntity;
import com.isa.blood_transfusion.model.BloodDonorInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Component
public class BloodDonorInfoConverter {
    private AddressConverter addressConverter;

    public BloodDonorInfo toModel(BloodDonorInfoEntity bloodDonorInfoEntity) {
        return new BloodDonorInfo(bloodDonorInfoEntity.getId(),
                bloodDonorInfoEntity.getName(),
                bloodDonorInfoEntity.getSurname(),
                bloodDonorInfoEntity.getNameOfFather(),
                bloodDonorInfoEntity.getIdentityNumber(),
                bloodDonorInfoEntity.getDateOfBirth(),
                bloodDonorInfoEntity.getPhoneNum(),
                bloodDonorInfoEntity.getFacility(),
                bloodDonorInfoEntity.getProfession(),
                bloodDonorInfoEntity.getNumberOfBloodDonations(),
                addressConverter.toModel(bloodDonorInfoEntity.getAddress()),
                bloodDonorInfoEntity.getGender());
    }

    public Set<BloodDonorInfo> toModel(Set<BloodDonorInfoEntity> bloodDonorInfoEntities) {
        Set<BloodDonorInfo> bloodDonorInfo = new HashSet<>();
        for (var b : bloodDonorInfoEntities) {
            bloodDonorInfo.add(new BloodDonorInfo(b.getId(),
                    b.getName(),
                    b.getSurname(),
                    b.getNameOfFather(),
                    b.getIdentityNumber(),
                    b.getDateOfBirth(),
                    b.getPhoneNum(),
                    b.getFacility(),
                    b.getProfession(),
                    b.getNumberOfBloodDonations(),
                    addressConverter.toModel(b.getAddress()),
                    b.getGender()));
        }

        return bloodDonorInfo;
    }
}
