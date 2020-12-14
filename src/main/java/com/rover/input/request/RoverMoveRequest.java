package com.rover.input.request;

import com.rover.domain.RoverMoveDomain;
import com.rover.model.Direction;
import com.sun.istack.NotNull;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)

public class RoverMoveRequest {
  @NotNull
  Direction direction;

  public RoverMoveDomain toDomain() {
    return new RoverMoveDomain().setDirection(direction);
  }
}
