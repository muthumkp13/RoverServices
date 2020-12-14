
package  com.rover.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "conditions",
    "rover"
})
@Data
public class Scenario {

    @JsonProperty("name")
    private String name;
    @JsonProperty("conditions")
    private List<Condition> conditions = new ArrayList<Condition>();
    @JsonProperty("rover")
    private List<Rover> rover = new ArrayList<Rover>();

}
