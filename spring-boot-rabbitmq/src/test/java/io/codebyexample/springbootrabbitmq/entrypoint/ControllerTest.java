package io.codebyexample.springbootrabbitmq.entrypoint;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.codebyexample.springbootrabbitmq.core.entities.Greeting;
import io.codebyexample.springbootrabbitmq.dataprovider.GreetingRabbitProducer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

/**
 * @author huypva
 */
@WebMvcTest(Controller.class)
class ControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private GreetingRabbitProducer greetingRabbitProvider;

  @Test
  void greet() throws Exception {
    String api = "/greet?name=World";
    String message = String.format("Hello %s!", "World");
    Greeting greeting = new Greeting(0, message);

    Mockito.doNothing().when(greetingRabbitProvider).sendGreeting(any());

    ResultActions resultActions = mockMvc.perform(get(api))
        .andDo(print());

    resultActions.andExpect(status().isOk())
        .andExpect(jsonPath("$.id", is(greeting.getId())))
        .andExpect(jsonPath("$.message", is(greeting.getMessage())));
  }
}