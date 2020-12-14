package com.rover.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rover.model.Environment;
import com.rover.model.Location;
import com.rover.model.RoverConfig;
import com.rover.model.Roverr;
import com.rover.output.response.RoverStatus;
import com.rover.service.Repository;
import com.rover.service.RoverStatusService;

@Service
public class RoverStatusServiceImpl implements RoverStatusService {

  @Autowired
  private Repository repo;

  @Override
  public RoverStatus getStatus() {

    RoverConfig config = repo.getRoverConfig();
    Environment environment = repo.getEnvironment();

    return generateRoverStatus(config, environment);
  }

  private RoverStatus generateRoverStatus(RoverConfig config, Environment environment) {

    RoverStatus roverStatus = new RoverStatus();

    Environment environmentRes = new Environment();
    environmentRes.setHumidity(environment.getHumidity());
    environmentRes.setSolarFlare(environment.isSolarFlare());
    environmentRes.setStorm(environment.isStorm());
    environmentRes.setTemperature(environment.getTemperature());
    environmentRes
      .setTerrain(environment.getTerrain(config.getDeployPoint().getRow(), config.getDeployPoint().getColumn()));

    Roverr rover = new Roverr();

    rover
      .setLocation(new Location()
        .setColumn(config.getDeployPoint().getColumn())
        .setRow(config.getDeployPoint().getRow()));
    rover.setBattery(config.getInitialBattery());
    rover.setInventory(config.getInventory());

    roverStatus.setRover(rover);
    roverStatus.setEnvironment(environmentRes);

    return roverStatus;
  }
}
