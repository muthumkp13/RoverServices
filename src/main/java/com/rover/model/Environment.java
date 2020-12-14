package com.rover.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.rover.domain.EnvironmentDomain;

import lombok.Data;
import lombok.experimental.Accessors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Accessors(chain = true)
public class Environment {

  private long temperature;

  private long humidity;

  private boolean solarFlare;

  private boolean storm;

  List<List<TerrainType>> areaMap;

  private TerrainType terrain;

  public EnvironmentDomain toDomain() {
    return new EnvironmentDomain()
      .setAreaMap(areaMap)
      .setHumidity(humidity)
      .setSolarFlare(solarFlare)
      .setStorm(storm)
      .setTemperature(temperature);
  }

  public TerrainType getTerrain(int row, int column) {
    TerrainType typeRet = null;

    for (int i = 0; i < row; i++) {
      List<TerrainType> list = areaMap.get(i);
      for (int j = 0; j < column; j++) {
        typeRet = list.get(j);
      }
    }
    return typeRet;
  }

}
