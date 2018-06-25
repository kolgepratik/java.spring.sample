package com.kp.first.junit;

import com.kp.first.bean.SingletonBeanFactory;
import com.kp.first.model.Customer;
import junit.framework.Assert;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

public class FirstTest {

    @Autowired SingletonBeanFactory singletonBeanFactory ;

    @BeforeAll
    static void initAll() {
        System.out.println("Before any Test");
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
    }

    @Test
    void succeedingTest() {
        assertEquals(2, 2);
        assertEquals(4, 4, "optional message");
        assertTrue('a' < 'b', () -> "Assertion messages can be lazily evaluated -- "
                + "to avoid constructing complex messages unnecessarily.");
    }

    @Test
    void groupedAssertions() {
        Customer customer = new Customer();
        customer.setFirstName("Pratik");
        customer.setLastName("Kolge");

        // In a grouped assertion all assertions are executed, and any
        // failures will be reported together.
        assertAll("customer",
                () -> assertEquals("Pratik", customer.getFirstName()),
                () -> assertEquals("Kolge", customer.getLastName())
        );
    }

    @Test
    void dependentAssertions() {
        Customer customer = new Customer();
        customer.setFirstName("Pratik");
        customer.setLastName("Kolge");

        // Within a code block, if an assertion fails the
        // subsequent code in the same block will be skipped.
        assertAll("dependentAssertions",
                () -> {
                    Assert.assertNotNull(customer);

                    // Executed only if the previous assertion is valid.
                    assertAll("first name",
                            () -> assertTrue(customer.getFirstName().startsWith("P")),
                            () -> assertTrue(customer.getFirstName().endsWith("k"))
                    );
                },
                () -> {
                    // Grouped assertion, so processed independently
                    // of results of first name assertions.
                    String lastName = customer.getLastName();
                    assertNotNull(lastName);

                    // Executed only if the previous assertion is valid.
                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("K")),
                            () -> assertTrue(lastName.endsWith("e"))
                    );
                }
        );
    }

    @Test
    void exceptionTesting() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("a message");
        });
        assertEquals("a message", exception.getMessage());
    }

    @Test
    void timeoutNotExceeded() {
        // The following assertion succeeds.
        assertTimeout(ofSeconds(2), () -> {
            // Perform task that takes less than 3 seconds
            Thread.sleep(1000);
        });
    }

    @Test
    void timeoutExceededWithPreemptiveTermination() {
        // The following assertion fails with an error message similar to:
        // execution timed out after 10 ms
        assertTimeoutPreemptively(ofMillis(10), () -> {
            // Simulate task that takes more than 10 ms.
            Thread.sleep(100);
        });
    }

    /* Other tests. */
    @Test
    @DisplayName("Custom test name containing spaces")
    @Disabled
    void failingTest() {
        fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }
}
