package com.kp.first.junit;

import com.kp.first.bean.SingletonBeanFactory;
import com.kp.first.config.AppConfig;
import com.kp.first.model.Customer;
import com.kp.first.model.CustomerSession;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {AppConfig.class})
public class SpringTest {

    @Mock
    SampleFunctionality sm;

    @Autowired
    SingletonBeanFactory singletonBeanFactory;

    @BeforeAll
    public static void initAll() {
        System.out.println("Before any test");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before each test");

        //sm = mock (SampleFunctionality.class);
        Mockito.when(sm.addIntegers(1, 2)).thenReturn(3);
    }

    @AfterEach
    public void afterEach() {
        System.out.println("After each test");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("After all tests");
    }

    @Test
    @Disabled
    public void testFactory() {
        assertNotNull(singletonBeanFactory,"Check if autowiring works");

        Integer r = sm.addIntegers(1, 2);

        assertEquals((Integer)3, r,"Result should be 3");
    }

    @Test
    public void testRedis () {
        assertNotNull(singletonBeanFactory,"Check if autowiring works");

        assertNotNull(singletonBeanFactory.customerSessionRepository, "check if redis works");

        Customer customer = singletonBeanFactory.customerRepository.findByUsername("kolgepratik");

        CustomerSession customerSession = new CustomerSession();
        customerSession.setId(customer.getId());

        singletonBeanFactory.customerSessionRepository.save(customerSession);
        Optional<CustomerSession> retrievedSession = singletonBeanFactory.customerSessionRepository.findById(customer.getId());

        assertAll("check redis response",
                () -> assertNotNull(retrievedSession.get()),
                () -> assertEquals(customer.getId(), retrievedSession.get().getId(), "retrieved session must match")
        );
    }
}
