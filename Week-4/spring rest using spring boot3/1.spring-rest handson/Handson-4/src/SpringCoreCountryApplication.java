package com.cognizant.spring_core_country;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringCoreCountryApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringCoreCountryApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringCoreCountryApplication.class, args);
        displayCountry();
        LOGGER.info("END");
    }

    public static void displayCountry() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        com.cognizant.spring_core_country.Country country = context.getBean("country", com.cognizant.spring_core_country.Country.class);
        System.out.println("Inside displayCountry()");
        LOGGER.debug("Country : {}", country.toString());
    }
}
