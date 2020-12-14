
package com.rover.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "qty"
})
@Data
public class ItemUsage {

    @JsonProperty("type")
    private String type;
    @JsonProperty("qty")
    private Integer qty;

}
