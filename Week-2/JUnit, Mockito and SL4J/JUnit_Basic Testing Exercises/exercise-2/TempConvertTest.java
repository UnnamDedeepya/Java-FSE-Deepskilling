package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class TempConvertTest {
	@Test
	public void testCelsiusToFahren() {
		TemperatureConvert conv = new TemperatureConvert();
		double res=conv.celsiusToFahren(12);
		assertEquals(53.6,res,0.001);
	}
	
	public void testFahrenToCelsius() {
		TemperatureConvert conv = new TemperatureConvert();
		double res = conv.fahrenToCelsius(122);
		assertEquals(50,res,0.001);
	}
}
