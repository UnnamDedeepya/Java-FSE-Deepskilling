package com.cognizant.springrest.spring_rest_country_code.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cognizant.springrest.spring_rest_country_code.model.Country;
import com.cognizant.springrest.spring_rest_country_code.service.CountryService;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        LOGGER.info("START getCountry()");
        Country country = countryService.getCountry(code);
        LOGGER.info("END getCountry()");
        return country;
    }
}
