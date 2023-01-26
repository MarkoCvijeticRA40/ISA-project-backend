package com.isa.blood_transfusion.security.config;

import com.isa.blood_transfusion.security.auth.RestAuthenticationEntryPoint;
import com.isa.blood_transfusion.security.auth.TokenAuthenticationFilter;
import com.isa.blood_transfusion.security.util.TokenUtils;
import com.isa.blood_transfusion.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity

@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Autowired
    private TokenUtils tokenUtils;

    // Definisemo prava pristupa za zahteve ka odredjenim URL-ovima/rutama
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint);

        // ovde se navode putanje i prava pristupa(npr. .antMatchers("/freeapp/getByDateAsc/{centerId}/{registeredUserId}").hasAuthority("REGISTERED_USER")
        // ovim se odredjuje da samo User sa ulogo, REGISTERED_USER ima pravo pristupa zadatoj putanji. Trenutno je postavljeno tako da svaki tip korisnika
        // ima pravo pristupa svim putanjama)
        http.authorizeRequests().antMatchers("/auth/**").permitAll()        // /auth/**
                .antMatchers("/users/activate/**").permitAll()
                //.antMatchers("/users/whoami").hasAuthority("REGISTERED_USER")
//                .antMatchers("/medicalstaff/**").permitAll()
//                .antMatchers("/registeredusers/**").permitAll()
//                .antMatchers("/centers/**").permitAll()
//                .antMatchers("/info/**").permitAll()
//                .antMatchers("/freeapp/**").permitAll()
//                .antMatchers("/freeapp/getByDateAsc/{centerId}/{registeredUserId}").hasAuthority("REGISTERED_USER")
//                .antMatchers("/users/**").permitAll()
                .antMatchers("/**").permitAll()
                //.antMatchers("/administrators/**").permitAll()
                .anyRequest().authenticated().and()
                // za development svrhe ukljuci konfiguraciju za CORS iz WebConfig klase
                .cors().and()
                .addFilterBefore(new TokenAuthenticationFilter(tokenUtils, userDetailsService()), BasicAuthenticationFilter.class);
        http.csrf().disable();
        http.authenticationProvider(authenticationProvider());

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers(HttpMethod.POST, "/auth/login")


                // Ovim smo dozvolili pristup statickim resursima aplikacije
                .antMatchers(HttpMethod.GET, "/", "/webjars/**", "/*.html", "favicon.ico",
                        "/**/*.html", "/**/*.css", "/**/*.js");

    }
}
