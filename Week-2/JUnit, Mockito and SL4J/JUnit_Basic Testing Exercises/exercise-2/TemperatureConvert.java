package com.example;

public class TemperatureConvert {
	
	//convert celsius to fahrenheit
	public double celsiusToFahren(double celsius) {
		return (celsius*9/5)+32;
	}
	
	// convert fahrenheit to celsius
	
	public double fahrenToCelsius(double fahren) {
		return(fahren-32)*5/9;
	}
}
