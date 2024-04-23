package com.testing.Test.testing;

import com.testing.Test.testing.Order.Order;
import com.testing.Test.testing.Order.OrderRepository;
import com.testing.Test.testing.Order.OrderRequest;
import com.testing.Test.testing.Order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertTrue;

@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
@DataJpaTest
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class OrderServiceImplIntegrationTest {

  @Autowired
  private OrderRepository orderRepository;

  @Test
  public void testSaveAndFindOrderIntegrationWithH2() {
    OrderRequest orderRequest = new OrderRequest("test Order", 20);

    OrderServiceImpl orderServiceImpl = new OrderServiceImpl(orderRepository);
    /**
     * Attempting to save order to h2 database
     **/
    Order savedOrder = orderServiceImpl.saveOrder(orderRequest);
    Optional<Order> getOrder = orderRepository.findById(savedOrder.getId());

    assertTrue(getOrder.isPresent());
  }

}
