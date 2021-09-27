package io.codebyexample.springbootrabbitmq.dataprovider;

import io.codebyexample.springbootrabbitmq.core.entities.Greeting;

/**
 * @author huypva
 */
public interface GreetingRabbitProvider {

  void sendGreeting(Greeting greeting);

}
