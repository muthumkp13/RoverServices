
package com.rover.model;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.experimental.Accessors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "type",
  "quantity",
  "priority"
})
@Data
@Accessors(chain = true)
public class Inventory {

  @JsonIgnore
  private static String[] sampleType = new String[] {"water-sample", "rock-sample"
  };
  @JsonIgnore
  private static String[] inventoryItemType = new String[] {"storm-shield"};

  @JsonProperty("type")
  private String type;
  @JsonProperty("quantity")
  private Integer quantity;
  @JsonProperty("priority")
  private Integer priority;

  private boolean validateType(String typeValue) {
    boolean toRet = false;
    if (Arrays.stream(sampleType).anyMatch(typeValue::equals)
      || Arrays.stream(inventoryItemType).anyMatch(typeValue::equals)) {
      toRet = true;
    }
    return toRet;
  }
}
