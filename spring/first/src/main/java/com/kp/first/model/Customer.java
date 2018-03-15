package com.kp.first.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Scope(value = "prototype") @Component public class Customer implements UserDetails {

    @Autowired private PasswordEncoder passwordEncoder;

    @Id private String id;

    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    private String firstName;
    private String lastName;

    public Customer() {
        super();
    }

    public void setDetails(String firstName, String lastName, String[] authorities) {
        this.username = firstName;
        this.password = passwordEncoder.encode(lastName);
        this.authorities = AuthorityUtils.createAuthorityList(authorities);

        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override public String getUsername() {
        return this.username;
    }

    @Override public String getPassword() {
        return this.password;
    }

    @Override public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override public boolean isAccountNonExpired() {
        return true;
    }

    @Override public boolean isAccountNonLocked() {
        return true;
    }

    @Override public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override public boolean isEnabled() {
        return true;
    }

    @Override public String toString() {
        return String
            .format("Customer[id=%s, firstName='%s', lastName='%s']", id, firstName, lastName);
    }

}
