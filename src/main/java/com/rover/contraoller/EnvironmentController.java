package com.rover.contraoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rover.input.request.CreateEnvironmentRequest;
import com.rover.input.request.PatchEnvironmentRequest;
import com.rover.service.CreateEnvironmentService;
import com.rover.service.PatchEnvironmentService;

@RestController
@RequestMapping(value = "/api/environment")
public class EnvironmentController {

  @Autowired
  private CreateEnvironmentService createEnvironmrntService;

  @Autowired
  private PatchEnvironmentService patchEnvironmrntService;

  @PostMapping("/configure")
  public ResponseEntity<String> configure(
    @RequestBody @Validated CreateEnvironmentRequest request) {
    String response = createEnvironmrntService.process(request);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @PatchMapping()
  public ResponseEntity<String> environment(
    @RequestBody @Validated PatchEnvironmentRequest request) {
    String response = patchEnvironmrntService.process(request);
    return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
  }

}
