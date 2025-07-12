package com.example.demo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {
	@Test
	public void testAdd() {
		CalculatorService cal = new CalculatorService();
		int result = cal.add(29,10);
		assertEquals(39,result);
	}
}
