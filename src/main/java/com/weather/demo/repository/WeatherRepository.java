package com.weather.demo.repository;

import com.weather.demo.entity.WeatherInformationEntity;
import org.springframework.data.repository.CrudRepository;

public interface WeatherRepository extends CrudRepository<WeatherInformationEntity,Integer> {

}
