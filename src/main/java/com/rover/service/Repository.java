package com.rover.service;

import com.rover.model.Environment;
import com.rover.model.RoverConfig;

public interface Repository {

  public void envSave(Environment environment);

  public Environment getEnvironment();

  public void roverConfigSave(RoverConfig roverConfigInput);

  public RoverConfig getRoverConfig();

}
