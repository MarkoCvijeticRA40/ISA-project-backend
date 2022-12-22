package com.isa.blood_transfusion.converter;


import com.isa.blood_transfusion.entity.AddressEntity;
import com.isa.blood_transfusion.model.Address;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class AddressConverter {

    public Address toModel(AddressEntity addressEntity) {
        if (addressEntity == null) {
            return null;
        } else {
            return new Address(addressEntity.getId(),
                    addressEntity.getStreet(),
                    addressEntity.getNumber(),
                    addressEntity.getCity(),
                    addressEntity.getState(),
                    addressEntity.getLongitude(),
                    addressEntity.getLatitude());
        }
    }

    public Set<Address> toModel(Set<AddressEntity> addressEntities) {
        Set<Address> addresses = new HashSet<>();
        for (var a : addressEntities) {
            addresses.add(new Address(a.getId(), a.getStreet(), a.getNumber(), a.getCity(), a.getState(), a.getLongitude(), a.getLatitude()));
        }

        return addresses;
    }

    public AddressEntity toEntity(Address address) {
        return new AddressEntity(address.getId(),
                address.getStreet(),
                address.getNumber(),
                address.getCity(),
                address.getState(),
                address.getLongitude(),
                address.getLatitude());
    }

    public Set<AddressEntity> toEntity(Set<Address> addresses) {
        Set<AddressEntity> addressEntities = new HashSet<>();
        for (var a : addresses) {
            addressEntities.add(new AddressEntity(a.getId(), a.getStreet(), a.getNumber(), a.getCity(), a.getState(), a.getLongitude(), a.getLatitude()));
        }

        return addressEntities;
    }
}
