package com.rover.contraoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rover.input.request.RoverMoveRequest;
import com.rover.model.RoverConfig;
import com.rover.output.response.RoverMoveResponse;
import com.rover.output.response.RoverStatus;
import com.rover.service.RoverConfigService;
import com.rover.service.RoverMoveService;
import com.rover.service.RoverStatusService;

@RestController
@RequestMapping(value = "/api/rover")
public class RoverController {

  @Autowired
  public RoverMoveService roverMoveService;

  @Autowired
  public RoverConfigService roverConfigService;

  @Autowired
  public RoverStatusService roverStatusService;

  @PostMapping("/move")
  public ResponseEntity<RoverMoveResponse> move(
    @RequestBody @Validated RoverMoveRequest request) {
    RoverMoveResponse response = roverMoveService.process(request);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @PostMapping("/configure")
  public ResponseEntity<String> configure(
    @RequestBody RoverConfig request) {
    String response = roverConfigService.process(request);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @GetMapping("/status")
  public ResponseEntity<RoverStatus> status() {
    RoverStatus response = roverStatusService.getStatus();
    return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
  }
}
