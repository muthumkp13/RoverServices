package com.rover.domain;

import com.rover.model.Direction;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RoverMoveDomain {

  Direction direction;
}
