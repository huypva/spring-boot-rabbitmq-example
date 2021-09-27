package io.codebyexample.springbootrabbitmq.entrypoint.rabbitmq;

import io.codebyexample.springbootrabbitmq.core.entities.Greeting;
import io.codebyexample.springbootrabbitmq.util.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author huypva
 */
@Slf4j
@Component
public class GreetingRabbitListener {

  @RabbitListener(queues = "#{rabbitConfiguration.queueName}")
  public void greet(String greetingMessage) {
    log.info("Listen message from Rabbit: {}", greetingMessage);

    Greeting greeting = GsonUtils.fromJson(greetingMessage, Greeting.class);
    log.info("Message id={}, message={}", greeting.getId(), greeting.getMessage());
  }

}
