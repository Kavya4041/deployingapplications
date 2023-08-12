package com.deployexample.test.deployexample;

import com.deployexample.test.deployexample.controller.ControllerApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles
class DeployexampleApplicationTests {

	@Autowired
	ControllerApi controllerApi;
	@Test
	void contextLoads() {

	}


	@Test
	public void testname()
	{
		assertEquals("dev",controllerApi.getName());
	}

}
