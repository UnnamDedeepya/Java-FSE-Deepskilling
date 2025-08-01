package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {
	@Test
	public void testAssertions() {
		
		//assert equal
		assertEquals(7,4+3);
		
		//assert True
		assertTrue(8>4);
		
		//assert False
		assertFalse(5>29);
		
		//Assert Null
		String s=null;
		assertNull(s);
		
		//assert not null
		String greet="Hello";
		assertNotNull(greet);
		
	}
}
