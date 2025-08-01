package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilsTest {
	private StringUtils ut;
	
	//runs before each @Test
	@Before
	public void setUp() {
		ut=new StringUtils();
		System.out.println("Before Test");
	}
	
	//runs after each @Test
	@After
	public void tearDown() {
		System.out.println("After Test");
	}
	
	@Test
	public void testIsEmpty_EmptyString() {
		//act
		boolean result=ut.isEmpty("");
		//assert
		assertTrue(result);
	}
	
	public void testIsEmpty_NonEmptyString() {
		boolean result=ut.isEmpty("Testing");
		assertFalse(result);
	}
	
	public void testToUpperCase() {
		String result = ut.toUpperCase("Testing");
		assertEquals("Testing",result);
	}
}
