package com.rover.service;

public interface CommonService<Input, Output> extends Validatore<Input, Output> {

  public Output process(Input input);

}
