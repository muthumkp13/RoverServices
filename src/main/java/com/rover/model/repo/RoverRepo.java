package com.rover.model.repo;

import org.springframework.stereotype.Component;

import com.rover.model.Environment;
import com.rover.model.RoverConfig;
import com.rover.service.Repository;

@Component
public class RoverRepo implements Repository {

  private Environment environment = null;

  private RoverConfig roverConfig = null;

  public void envSave(Environment environment1) {
    environment = environment1;
  }

  public void roverConfigSave(RoverConfig roverConfigInput) {
    roverConfig = roverConfigInput;
  }

  public RoverConfig getRoverConfig() {
    return roverConfig;
  }

  public Environment getEnvironment() {
    return environment;
  }
}
