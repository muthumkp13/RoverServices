package com.rover.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rover.domain.EnvironmentDomain;
import com.rover.input.request.PatchEnvironmentRequest;
import com.rover.model.Environment;
import com.rover.service.PatchEnvironmentService;
import com.rover.service.Repository;

@Service
public class PatchEnvironmentServiceImpl implements PatchEnvironmentService {

  @Autowired
  private Repository repository;

  @Override
  public String process(PatchEnvironmentRequest input) {

    EnvironmentDomain domainRequest = input.toDomain();

    Environment dbObj = repository.getEnvironment();

    mergeEnvironment(domainRequest, dbObj);

    repository.envSave(dbObj);

    return "success";

  }

  private void mergeEnvironment(EnvironmentDomain domainRequest, Environment dbObj) {

    if (dbObj == null) {
      dbObj = new Environment();
    }
    
    if (domainRequest.getAreaMap() != null) {
      dbObj.setAreaMap(domainRequest.getAreaMap());
    }

    dbObj.setHumidity(domainRequest.getHumidity());
    dbObj.setTemperature(domainRequest.getTemperature());

  }
}
