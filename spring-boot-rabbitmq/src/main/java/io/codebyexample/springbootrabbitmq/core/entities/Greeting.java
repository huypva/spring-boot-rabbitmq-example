package io.codebyexample.springbootrabbitmq.core.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author huypva
 */
@Getter
@Setter
@AllArgsConstructor
public class Greeting {

  private int id;
  private String message;

}
