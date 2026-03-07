package com.bytelabs.order_service.service;

import com.bytelabs.order_service.config.ClientConfig;
import com.bytelabs.order_service.dto.OrderDto;
import com.bytelabs.order_service.entity.ItemEntity;
import com.bytelabs.order_service.entity.OrderEntity;
import com.bytelabs.order_service.repository.ItemRepository;
import com.bytelabs.order_service.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final ClientConfig clientConfig;

    @Transactional
    public OrderEntity createOrder(OrderDto order) {
        float orderValue = 0;

        // handle items from item stock and calculate the total
        order.getOrderMap().forEach((key, value) -> {
            Optional<ItemEntity> record = itemRepository.findById(key);
            if (record.isEmpty()) {
                throw new RuntimeException("Requested item not found");
            }

            ItemEntity item = record.get();
//            orderValue += item.getPrice() * value;
        });

        // save order in db - todo: check the order
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserId(order.getUserId());

        // call payment service
//        clientConfig.serviceClient().get().uri("/payment").retrieve().body();


        return orderRepository.save(orderEntity);
    }
}
