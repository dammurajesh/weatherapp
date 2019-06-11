package com.weather.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties
@EqualsAndHashCode
public class Weather  {
    @ApiModelProperty(notes = "Type of the account to be created", position = 1, example = "100.10")
    @NotNull
    private Double lat;
    @ApiModelProperty(notes = "Type of the account to be created", position = 2, example = "100.10")
    @NotNull
    private Double lng;
    @ApiModelProperty(notes = "Type of the account to be created", position = 3, example = "90.5")
    @NotNull
    private Double temperature;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
