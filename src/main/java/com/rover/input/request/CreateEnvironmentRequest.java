package com.rover.input.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rover.domain.EnvironmentDomain;
import com.rover.model.TerrainType;
import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class CreateEnvironmentRequest {

  @NotNull
  long temperature;

  @NotNull
  long humidity;

  @NotNull
  @JsonProperty("solar-flare")
  boolean solarFlare;

  @NotNull
  boolean storm;

  @NotNull
  @JsonProperty("area-map")
  List<List<TerrainType>> areaMap;

  public EnvironmentDomain toDomain() {

    return new EnvironmentDomain()
      .setAreaMap(areaMap)
      .setHumidity(humidity)
      .setSolarFlare(solarFlare)
      .setStorm(storm)
      .setTemperature(temperature);
  }

}
