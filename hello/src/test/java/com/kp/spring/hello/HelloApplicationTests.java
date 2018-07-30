package com.kp.spring.hello;

import com.kp.spring.hello.runner.HelloApplicationRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = HelloApplicationRunner.class)
public class HelloApplicationTests {

	@Test
	public void contextLoads() {
	}

}
