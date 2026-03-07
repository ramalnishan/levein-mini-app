package com.bytelabs.order_service.dto;

import lombok.Getter;

import java.util.Map;
import java.util.UUID;

@Getter
public class OrderDto {
    private String userId;
    private Map<UUID, Integer> orderMap;
}
