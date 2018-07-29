package com.kp.first.model;

import com.kp.first.bean.SingletonBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) public class Customer
    implements UserDetails {

    @Autowired private SingletonBeanFactory globalBeanRepository;

    @Id private String id;

    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String lastName;

    public Customer() {
        super();
    }

    public void setDetails(String firstName, String lastName, String[] authorities) {
        this.username = firstName;
        this.password = globalBeanRepository.passwordEncoder.encode(lastName);
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
