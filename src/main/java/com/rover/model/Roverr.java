package com.rover.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "location",
  "battery",
  "environment",
})
@Data
public class Roverr {

  @JsonProperty("location")
  private Location location;

  @JsonProperty("battery")
  private long battery;

  @JsonProperty("inventory")
  private List<Inventory> inventory = new ArrayList<>();

}
