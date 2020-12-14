package com.rover.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rover.model.RoverConfig;
import com.rover.service.Repository;
import com.rover.service.RoverConfigService;

@Service
public class RoverConfigServiceImpl implements RoverConfigService {

  @Autowired
  public Repository repo;

  @Override
  public String process(RoverConfig input) {
    repo.roverConfigSave(input);
    return "success";
  }

}
