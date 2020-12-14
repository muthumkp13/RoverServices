package com.rover.service.impl;

import org.springframework.stereotype.Service;

import com.rover.domain.RoverMoveDomain;
import com.rover.input.request.RoverMoveRequest;
import com.rover.output.response.RoverMoveResponse;
import com.rover.service.RoverMoveService;

@Service
public class RoverMoveServiceImpl implements RoverMoveService {

  @Override
  public RoverMoveResponse process(RoverMoveRequest input) {

    RoverMoveDomain domain = input.toDomain();
    
    RoverMoveResponse response = new RoverMoveResponse("move successfully");
    
    return response;
  }
}
