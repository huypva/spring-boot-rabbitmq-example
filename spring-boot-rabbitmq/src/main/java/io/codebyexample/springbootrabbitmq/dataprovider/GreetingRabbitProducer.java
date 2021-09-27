package io.codebyexample.springbootrabbitmq.dataprovider;

import io.codebyexample.springbootrabbitmq.core.entities.Greeting;

/**
 * @author huypva
 */
public interface GreetingRabbitProducer {

  void sendGreeting(Greeting greeting);

}
