
package com.rover.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "row",
    "column"
})
@Data
public class DeployPoint {

    @JsonProperty("row")
    private Integer row;
    @JsonProperty("column")
    private Integer column;

}
