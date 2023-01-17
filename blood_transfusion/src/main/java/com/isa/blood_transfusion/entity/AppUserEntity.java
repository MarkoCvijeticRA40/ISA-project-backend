package com.isa.blood_transfusion.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type")
@Entity(name = "users")
public class AppUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "phone_num")
    private String phoneNum;
    @Column(name = "identity_number", unique = true, nullable = false)
    private String identityNumber;
    @Column(name = "profession", nullable = false)
    private String profession;
    @Column(name = "facility_info")
    private String facilityInfo;
    //@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private RoleEntity role;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity address;
    @Column(name = "gender", nullable = false)
    private Gender gender;
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "last_password_reset_date")
    private Timestamp lastPasswordResetDate;


//    @JsonIgnore
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<RoleEntity> roles = new ArrayList<>();
//        roles.add(this.role);
//        return (Collection<? extends GrantedAuthority>) roles;
//    }
//
//    @JsonIgnore
//    @Override
//    public String getUsername() {
//        return this.email;
//    }
//
//    @JsonIgnore
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @JsonIgnore
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @JsonIgnore
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return enabled;
//    }
}
