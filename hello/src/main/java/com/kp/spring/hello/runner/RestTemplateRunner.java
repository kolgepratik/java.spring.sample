package com.kp.spring.hello.runner;

import com.kp.spring.hello.model.reqres.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class RestTemplateRunner {
    public static void mainCode(String[] args) {
        User user = null;

                // Create a RestTemplate.
        RestTemplate restTemplate = new RestTemplate();

        try {
            // This does not work because WebService requires us to pass User-Agent header which we are not passing here.
            user = restTemplate.getForObject("https://reqres.in/api/users/2", User.class);
        } catch (HttpClientErrorException ex) {
            System.err.println("Error in getForObject(): " + ex);
        }

        // Headers are necessary to specify User agent.
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("User-Agent","curl/7.55.1");

        // Create an Entity using headers.
        HttpEntity<User> httpEntity = new HttpEntity<User>(httpHeaders);

        restTemplate = new RestTemplate();

        // Get the ResponseEntity.
        ResponseEntity<User> userResponseEntity = restTemplate.exchange("https://reqres.in/api/users/2", HttpMethod.GET, httpEntity, User.class);
        user = userResponseEntity.getBody();

        System.out.println("Got User: " + user);
    }
}
