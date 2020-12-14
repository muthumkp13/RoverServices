
package  com.rover.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "is",
    "performs"
})
@Data
public class Rover {

    @JsonProperty("is")
    private String is;
    @JsonProperty("performs")
    private Performs performs;
   

}
