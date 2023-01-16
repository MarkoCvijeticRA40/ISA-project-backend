package com.isa.blood_transfusion.controller;

import com.isa.blood_transfusion.model.AppUser;
import com.isa.blood_transfusion.model.JwtAuthenticationRequest;
import com.isa.blood_transfusion.model.RegisteredUser;
import com.isa.blood_transfusion.model.UserTokenState;
import com.isa.blood_transfusion.security.util.TokenUtils;
import com.isa.blood_transfusion.service.AppUserService;
import com.isa.blood_transfusion.service.EmailService;
import com.isa.blood_transfusion.service.RegisteredUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private TokenUtils tokenUtils;
    private AuthenticationManager authenticationManager;
    private final RegisteredUserService registeredUserService;
    private final AppUserService appUserService;
    private final EmailService emailService;

    @PostMapping("/login")
    public ResponseEntity<UserTokenState> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {
        // Ukoliko kredencijali nisu ispravni, logovanje nece biti uspesno, desice se
        // AuthenticationException
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getEmail(), authenticationRequest.getPassword()));

        // Ukoliko je autentifikacija uspesna, ubaci korisnika u trenutni security
        // kontekst
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Kreiraj token za tog korisnika
        AppUser user = (AppUser) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user.getEmail());
        int expiresIn = tokenUtils.getExpiredIn();

        // Vrati token kao odgovor na uspesnu autentifikaciju
        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
    }

    @PostMapping("/signupuser")
    public ResponseEntity<RegisteredUser> addUser(@RequestBody RegisteredUser user) throws Exception {
        AppUser existUser = appUserService.find(user.getEmail());

        if (existUser != null) {
            throw new Exception("Username already exists");
        }
        emailService.sendNotificaition(user);
        return new ResponseEntity<>(registeredUserService.save(user), HttpStatus.CREATED);
    }
}
