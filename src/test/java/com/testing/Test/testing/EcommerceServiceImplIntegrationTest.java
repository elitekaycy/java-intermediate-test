package com.testing.Test.testing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EcommerceServiceImplIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testProductBrowsing() throws Exception {

    mockMvc.perform(get("/ecommerce?q={q}", "tail")).andExpect(status().isOk());
  }
}
