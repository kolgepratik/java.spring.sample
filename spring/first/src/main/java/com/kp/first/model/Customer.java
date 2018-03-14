package com.kp.first.model;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class Customer implements UserDetails {

    @Id private String id;

    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    private String firstName;
    private String lastName;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String[] authorities) {
        this.username = firstName;
        this.password = lastName;

        this.firstName = firstName;
        this.lastName = lastName;

        this.authorities = AuthorityUtils.createAuthorityList(authorities);
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
