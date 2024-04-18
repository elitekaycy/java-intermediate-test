package com.testing.Test.testing;

import com.testing.Test.testing.Order.Order;
import com.testing.Test.testing.Order.OrderRepository;
import com.testing.Test.testing.Order.OrderRequest;
import com.testing.Test.testing.Order.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Writing my unit test for save product
 * **/
@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {

    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderServiceImpl orderService;

    @Test
    public void testSaveOrder() {
        int orderId = 1;
        OrderRequest orderRequest = new OrderRequest("basketball", 35);

        when(orderRepository.save(any(Order.class))).thenAnswer(invocationOnMock -> {
            Order order = invocationOnMock.getArgument(0);

            order.setId(1);
            return order;
        });

        Order saveOrder = orderService.saveOrder(orderRequest);

        assertNotNull(saveOrder);
        assertEquals(orderId, saveOrder.getId());

        verify(orderRepository, times(1)).save(any(Order.class));

    }
}
