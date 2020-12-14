
package  com.rover.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/*@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "scenarios",
    "states",
    "deploy-point",
    "initial-battery",
    "inventory"
})*/
@Data
public class RoverConfig {

    @JsonProperty("scenarios")
    private List<Scenario> scenarios = new ArrayList<>();
    @JsonProperty("states")
    private List<State> states = new ArrayList<>();
    @JsonProperty("deploy-point")
    private DeployPoint deployPoint;
    @JsonProperty("initial-battery")
    private Integer initialBattery;
    @JsonProperty("inventory")
    private List<Inventory> inventory = new ArrayList<>();
   


}
