package com.kp.first.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SampleFunctionalityTest {

    static SampleFunctionality instance;

    @BeforeAll
    static void initAll() {
        System.out.println("Before any Test");
        instance = new SampleFunctionality();
    }

    @BeforeEach
    void init() {
        System.out.println("Before Test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After Test");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("After all Tests");
        instance = null;
    }

    @Test
    @DisplayName("Test addIntegers()")
    public void testAddIntegers () {
        Integer number1 = null;
        Integer number2 = null;

        Integer result = instance.addIntegers(number1, number2);
        assertEquals (result, null, "Return null when any of the inputs is null");
    }

    @Test
    @DisplayName("Test add()")
    public void testAdd () {
        // Test 1
        Object a1 = null;
        Object a2 = null;

        Object result = instance.add(a1, a2);
        assertEquals (result, null, "Return null when any of the inputs is null");


        // Test 2
        a1 = 12;
        a2 = 13;

        result = instance.add(a1, a2);
        assertNotEquals (result, null, "If both values are non-null, result should not be null");


        // Test 3
        a1 = 12.24;
        a2 = 12.24;

        result = instance.add(a1, a2);
        assertEquals (result, 24.48, "Check decimal numbers");


        // Test 4
        a1 = "abc";
        a2 = "xyz";

        result = instance.add(a1, a2);
        assertEquals (result, "abcxyz", "Check strings");

    }


}
