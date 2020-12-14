
package com.rover.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "rover",
  "environment",
})
@Data
public class RoverStatus {

  @JsonProperty("rover")
  private Roverr rover;

  @JsonProperty("environment")
  private Environment environment;
}
