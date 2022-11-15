package com.isa.blood_transfusion.store;

import com.isa.blood_transfusion.converter.AppUserConverter;
import com.isa.blood_transfusion.model.AppUser;
import com.isa.blood_transfusion.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class AppUserStoreImpl implements AppUserStore, UserDetailsService {
    private final AppUserRepository repository;
    private final AppUserConverter converter;

    @Override
    public AppUser save(AppUser appUser) {
        repository.save(converter.toEntity(appUser));
        return appUser;
    }

    @Override
    public AppUser find(String email) {
        return converter.toModel(repository.findByEmail(email));
    }

    @Override
    public List<AppUser> findAll() {
        return converter.toModel(repository.findAll().stream().collect(Collectors.toSet())).stream().toList();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = converter.toModel(repository.findByEmail(username));
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}
