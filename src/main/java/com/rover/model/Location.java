package com.rover.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.experimental.Accessors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "row",
  "column",
})
@Data
@Accessors(chain = true)
public class Location {

  @JsonProperty("row")
  private long row;
  @JsonProperty("column")
  private long column;

}
