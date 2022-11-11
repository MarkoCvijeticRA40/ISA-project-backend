package com.isa.blood_transfusion.converter;


import com.isa.blood_transfusion.entity.AddressEntity;
import com.isa.blood_transfusion.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter {

    public Address toModel(AddressEntity addressEntity) {
        return new Address(addressEntity.getId(),
                addressEntity.getStreet(),
                addressEntity.getNumber(),
                addressEntity.getCity(),
                addressEntity.getState(),
                addressEntity.getLongitude(),
                addressEntity.getLatitude());
    }
}
