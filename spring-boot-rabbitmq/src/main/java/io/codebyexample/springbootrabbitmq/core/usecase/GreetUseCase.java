package io.codebyexample.springbootrabbitmq.core.usecase;

import io.codebyexample.springbootrabbitmq.core.entity.Greeting;

/**
 * @author huypva
 */
public interface GreetUseCase {

  Greeting greet(String name);
}
