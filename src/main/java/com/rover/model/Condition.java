
package com.rover.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "type",
  "property",
  "operator",
  "value"
})
@Data
public class Condition {

  @JsonIgnore
  private static String[] roverProperty = new String[] {"battery"};
  @JsonIgnore
  private static String[] environmentProperty = new String[] {"terrain", "temperature", "humidity", "solar-flare",
    "storm"};

  @JsonProperty("type")
  private Type type;
  @JsonProperty("property")
  private String property;
  @JsonProperty("operator")
  private Operator operator;
  @JsonProperty("value")
  private String value2;

  private boolean validateProperty(String propertyValue) {
    boolean toRet = false;
    if (Arrays.stream(roverProperty).anyMatch(propertyValue::equals)
      || Arrays.stream(environmentProperty).anyMatch(propertyValue::equals)) {
      toRet = true;
    }
    return toRet;
  }
}
