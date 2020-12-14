package com.rover.input.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rover.domain.EnvironmentDomain;
import com.rover.model.TerrainType;

import lombok.Data;

@Data
public class PatchEnvironmentRequest {

  long temperature;

  long humidity;

  @JsonProperty("solar-flare")
  boolean solarFlare;

  boolean storm;

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
