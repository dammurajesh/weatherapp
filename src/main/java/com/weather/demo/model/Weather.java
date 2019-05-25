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
    @ApiModelProperty(notes = "Type of the account to be created", position = 1, example = "1")
    @NotNull
    private String locationID;
    @ApiModelProperty(notes = "Type of the account to be created", position = 2, example = "100")
    @NotNull
    private String lat;
    @ApiModelProperty(notes = "Type of the account to be created", position = 3, example = "100")
    @NotNull
    private String lng;
}
