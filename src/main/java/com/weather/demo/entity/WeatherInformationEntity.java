package com.weather.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
@Slf4j
@Table(name="Weather_Information")
public class WeatherInformationEntity implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "Location_ID")
    private Integer locationID;

    @Column(name = "Lat")
    private double lat;

    @Column(name = "Lng")
    private double lng;
}
