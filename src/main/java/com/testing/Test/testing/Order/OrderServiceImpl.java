package com.testing.Test.testing.Order;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrder(OrderRequest orderRequest) {
        Order newOrder = new Order(orderRequest.name(), orderRequest.quantity());
       return orderRepository.save(newOrder);
    }
}
