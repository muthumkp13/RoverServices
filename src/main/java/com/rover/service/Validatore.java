package com.rover.service;

public interface Validatore<Input, Output> {

  default void preProcess(Input input) {
  }

  default void postProcess(Output output) {
  }
}
