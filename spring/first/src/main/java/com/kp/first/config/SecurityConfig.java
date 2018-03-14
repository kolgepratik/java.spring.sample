package com.kp.first.config;

import com.kp.first.service.CustomerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private CustomerUserDetailsService customerUserDetailsService;

    @Override protected void configure(HttpSecurity http) throws Exception {

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

        /*
        http.authorizeRequests().antMatchers("/app/**").anonymous();
        http.csrf().disable();
        */
    }

    @Override protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserDetailsService userDetailsService = this.customerUserDetailsService;
        auth.userDetailsService(userDetailsService);
    }

    @Override public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/*.css");
        web.ignoring().antMatchers("/*.js");
    }
}
