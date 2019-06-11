package com.weather.demo.controller;

import com.weather.demo.model.Weather;
import com.weather.demo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value="/weather")
public class WeatherController {

    @Qualifier("weatherServiceKafkaImpl")
    @Autowired
    WeatherService weatherService;

    @Qualifier("weatherServiceImpl")
    @Autowired
    WeatherService weatherServiceMySQL;

    @GetMapping(value="{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public  String getWeatherInformation(){

        return "hello";
    }


    @PostMapping(value="/",produces = "application/json")
    public  void SaveWeatherInformation(@RequestBody(required = true) final Weather weather){

        weatherServiceMySQL.saveWeatherInformation(weather);
        weatherService.saveWeatherInformation(weather);
    }

    //Logging
    //Exception Handling
    //Validation of input object
    //Services
    //Database Integration
    //Docker



}
