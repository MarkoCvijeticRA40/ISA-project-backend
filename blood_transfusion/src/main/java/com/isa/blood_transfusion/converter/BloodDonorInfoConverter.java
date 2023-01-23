package com.isa.blood_transfusion.converter;

import com.isa.blood_transfusion.entity.BloodDonorInfoEntity;
import com.isa.blood_transfusion.entity.RegisteredUserEntity;
import com.isa.blood_transfusion.model.BloodDonorInfo;
import com.isa.blood_transfusion.repository.RegisteredUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Component
public class BloodDonorInfoConverter {
    private AddressConverter addressConverter;
    private final RegisteredUserRepository registeredUserRepository;

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
                bloodDonorInfoEntity.getGender(),
                bloodDonorInfoEntity.getHasAlreadyDonatedBlood(),
                bloodDonorInfoEntity.getIsProfessionDangerous(),
                bloodDonorInfoEntity.getWasRejectedToDonateBlood(),
                bloodDonorInfoEntity.getIsTakingAnyMedicines(),
                bloodDonorInfoEntity.getHasSomeAllergies(),
                bloodDonorInfoEntity.getHasChronicDisease(),
                bloodDonorInfoEntity.getIsFeelingHealthy(),
                bloodDonorInfoEntity.getRegisteredUser().getId()
                );
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
                    b.getGender(),
                    b.getHasAlreadyDonatedBlood(),
                    b.getIsProfessionDangerous(),
                    b.getWasRejectedToDonateBlood(),
                    b.getIsTakingAnyMedicines(),
                    b.getHasSomeAllergies(),
                    b.getHasChronicDisease(),
                    b.getIsFeelingHealthy(),
                    b.getRegisteredUser().getId()
                    ));
        }

        return bloodDonorInfo;
    }

    public BloodDonorInfoEntity toEntity(BloodDonorInfo bloodDonorInfo) {
        return new BloodDonorInfoEntity(bloodDonorInfo.getId(),
                bloodDonorInfo.getName(),
                bloodDonorInfo.getSurname(),
                bloodDonorInfo.getNameOfFather(),
                bloodDonorInfo.getIdentityNumber(),
                bloodDonorInfo.getDateOfBirth(),
                bloodDonorInfo.getPhoneNum(),
                bloodDonorInfo.getFacility(),
                bloodDonorInfo.getProfession(),
                bloodDonorInfo.getNumberOfBloodDonations(),
                addressConverter.toEntity(bloodDonorInfo.getAddress()),
                bloodDonorInfo.getGender(),
                bloodDonorInfo.getHasAlreadyDonatedBlood(),
                bloodDonorInfo.getIsProfessionDangerous(),
                bloodDonorInfo.getWasRejectedToDonateBlood(),
                bloodDonorInfo.getIsTakingAnyMedicines(),
                bloodDonorInfo.getHasSomeAllergies(),
                bloodDonorInfo.getHasChronicDisease(),
                bloodDonorInfo.getIsFeelingHealthy(),
                registeredUserRepository.getById(bloodDonorInfo.getRegisteredUserId()));
    }

    public Set<BloodDonorInfoEntity> toEntity(Set<BloodDonorInfo> bloodDonorInfos) {
        Set<BloodDonorInfoEntity> bloodDonorInfoEntities = new HashSet<>();
        for (var b : bloodDonorInfos) {
            bloodDonorInfoEntities.add(new BloodDonorInfoEntity(b.getId(),
                    b.getName(),
                    b.getSurname(),
                    b.getNameOfFather(),
                    b.getIdentityNumber(),
                    b.getDateOfBirth(),
                    b.getPhoneNum(),
                    b.getFacility(),
                    b.getProfession(),
                    b.getNumberOfBloodDonations(),
                    addressConverter.toEntity(b.getAddress()),
                    b.getGender(),
                    b.getHasAlreadyDonatedBlood(),
                    b.getIsProfessionDangerous(),
                    b.getWasRejectedToDonateBlood(),
                    b.getIsTakingAnyMedicines(),
                    b.getHasSomeAllergies(),
                    b.getHasChronicDisease(),
                    b.getIsFeelingHealthy(),
                    registeredUserRepository.getById(b.getId())));
        }

        return bloodDonorInfoEntities;
    }
}
