package com.kp.first.config;

import com.kp.first.bean.SingletonBeanFactory;
import com.kp.first.service.CustomerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private SingletonBeanFactory singletonBeanFactory;
    @Autowired private CustomerUserDetailsService customerUserDetailsService;

    @Override protected void configure(HttpSecurity http) throws Exception {
        //securityOff(http);
        securityOn(http);

        http
            .headers()
            .frameOptions().sameOrigin()
            .httpStrictTransportSecurity().disable();
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
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.sendRedirect("/first/app/home");
                    }
                })
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
        authProvider.setPasswordEncoder(singletonBeanFactory.passwordEncoder);
        return authProvider;
    }
}
