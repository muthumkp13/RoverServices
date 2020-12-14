package com.rover.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rover.domain.EnvironmentDomain;
import com.rover.input.request.CreateEnvironmentRequest;
import com.rover.model.Environment;
import com.rover.output.response.CreateEnvironmentResponse;
import com.rover.service.CreateEnvironmentService;
import com.rover.service.Repository;

@Service
public class CreateEnvironmentServiceImpl implements CreateEnvironmentService {


  @Autowired
  private Repository repository;
  
  @Override
  public String process(CreateEnvironmentRequest input) {

    EnvironmentDomain environmentDomain = input.toDomain();
    Environment model = environmentDomain.toModel();
    repository.envSave(model);
    return "success";
  }

}
