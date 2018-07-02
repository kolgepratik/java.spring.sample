package com.kp.first.junit;

import com.kp.first.bean.SingletonBeanFactory;
import com.kp.first.config.AppConfig;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = {AppConfig.class})
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
}
