package io.codebyexample.springbootrabbitmq.entrypoint;

import io.codebyexample.springbootrabbitmq.core.entities.Greeting;
import io.codebyexample.springbootrabbitmq.dataprovider.GreetingRabbitProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huypva
 */
@RestController
public class Controller {

  @Autowired
  private GreetingRabbitProvider greetingRabbitProvider;

  @GetMapping("/greet")
  public Greeting send(@RequestParam(name = "name") String name) {
    String message = String.format("Hello %s!", name);
    Greeting greeting = new Greeting(0, message);
    greetingRabbitProvider.sendGreeting(greeting);

    return greeting;
  }

}
