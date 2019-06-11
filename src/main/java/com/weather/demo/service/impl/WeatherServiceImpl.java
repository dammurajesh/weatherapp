package com.weather.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.demo.entity.WeatherInformationEntity;
import com.weather.demo.model.Weather;
import com.weather.demo.repository.WeatherRepository;
import com.weather.demo.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class WeatherServiceImpl implements WeatherService {
    @Autowired
    WeatherRepository weatherRepository;
    @Autowired
    ObjectMapper objectMapper;

   // private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(WeatherServiceImpl.class);

    @Override
    public void saveWeatherInformation(Weather weather) {

        WeatherInformationEntity entity = objectMapper.convertValue(weather, WeatherInformationEntity.class);
       // log.info("saving information for lat {} long {}", entity.getLat(), entity.getLng());

        weatherRepository.save(entity);
    }

    @Override
    public String getWeather() {
        return null;
    }



}
