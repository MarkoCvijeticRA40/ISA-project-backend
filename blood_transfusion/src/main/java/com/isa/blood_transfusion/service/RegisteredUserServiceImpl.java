package com.isa.blood_transfusion.service;

import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.store.RegisteredUserStore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Service
public class RegisteredUserServiceImpl implements RegisteredUserService {
    private final RegisteredUserStore store;

    @Override
    public RegisteredUser save(RegisteredUser user) {
        return store.save(user);
    }

    @Override
    public List<RegisteredUser> findAll() {
        return store.findAll();
    }

    @Override
    public List<RegisteredUser> findAll(Pageable pageable) {
        return store.findAll(pageable);
    }
}
