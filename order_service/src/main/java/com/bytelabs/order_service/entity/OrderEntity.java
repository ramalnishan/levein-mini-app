package com.bytelabs.order_service.entity;

import jakarta.persistence.*;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "orders")
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_id", unique = true, nullable = false)
    private String orderId;

    @Column(name = "user_id")
    private String userId;

    @CreatedDate
    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "item_reference")
    private String itemReference;
}
