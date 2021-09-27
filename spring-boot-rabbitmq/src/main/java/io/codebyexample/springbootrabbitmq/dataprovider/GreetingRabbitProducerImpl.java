package io.codebyexample.springbootrabbitmq.dataprovider;

import io.codebyexample.springbootrabbitmq.configuration.RabbitConfiguration;
import io.codebyexample.springbootrabbitmq.core.entities.Greeting;
import io.codebyexample.springbootrabbitmq.util.GsonUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huypva
 */
@Component
public class GreetingRabbitProducerImpl implements GreetingRabbitProducer {

  @Autowired
  RabbitConfiguration rabbitConfiguration;

  @Autowired
  RabbitTemplate rabbitTemplate;

  @Override
  public void sendGreeting(Greeting greeting) {
    rabbitTemplate.convertAndSend(
        rabbitConfiguration.exchangeName,
        rabbitConfiguration.routingKey,
        GsonUtils.toJson(greeting));
  }
}
