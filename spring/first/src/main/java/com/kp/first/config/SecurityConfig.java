package com.kp.first.config;

import com.kp.first.bean.GlobalBeanRepository;
import com.kp.first.service.CustomerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private GlobalBeanRepository globalBeanRepository;
    @Autowired private CustomerUserDetailsService customerUserDetailsService;

    @Override protected void configure(HttpSecurity http) throws Exception {

        //securityOff(http);
        securityOn(http);
    }

    private void securityOn(HttpSecurity http) throws Exception {
        //@formatter:off
        http
            .authorizeRequests()
                .antMatchers("/resources/**", "/signup", "/about").permitAll()
                .antMatchers("/app/**").authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .failureUrl("/login")
                .successForwardUrl("/")
                .permitAll();
        //@formatter:on
    }

    private void securityOff(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/app/**").anonymous();
        http.csrf().disable();
    }

    @Override protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    private AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customerUserDetailsService);
        authProvider.setPasswordEncoder(globalBeanRepository.passwordEncoder);
        return authProvider;
    }
}
