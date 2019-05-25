package com.weather.demo.service;

import com.weather.demo.model.Weather;

public interface WeatherService {
    public void saveWeatherInformation(Weather weather);
    public String getWeather();
}
