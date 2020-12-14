package com.rover.domain;

import java.util.List;

import com.rover.model.Environment;
import com.rover.model.TerrainType;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EnvironmentDomain {

  long temperature;

  long humidity;

  boolean solarFlare;

  boolean storm;

  List<List<TerrainType>> areaMap;

  public Environment toModel() {
    return new Environment().setAreaMap(areaMap).setHumidity(humidity)
      .setSolarFlare(solarFlare).setStorm(storm).setTemperature(temperature);
  }
}
