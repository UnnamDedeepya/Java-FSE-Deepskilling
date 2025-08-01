package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestHello {
	@Test
	public void HelloMessage() {
		String msg="Hello, Developer!!";
		//testing
		assertEquals("Hello, Developer!!",msg);
	}
}
