
package com.rover.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "name",
  "allowedActions"
})
@Data
public class State {

  @JsonIgnore
  private static String[] actions = new String[] {"move", "collect-sample"};

  @JsonProperty("name")
  private String name;
  @JsonProperty("allowedActions")

  @Size(max = 1)
  private String[] allowedActions = new String[1];

  private boolean validateAction(String allowedAction) {
    boolean toRet = false;
    if (Arrays.stream(actions).anyMatch(allowedAction::equals)) {
      toRet = true;
    }
    return toRet;
  }

}
