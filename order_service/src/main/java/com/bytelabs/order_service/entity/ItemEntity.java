package com.bytelabs.order_service.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "item")
@Getter
@Setter
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "item_id", unique = true, nullable = false)
    private String itemId;

    @JsonProperty("itemName")
    @Column(name = "item_name", nullable = false, length = 100)
    private String itemName;

    @JsonProperty("quantity")
    @Column(name = "quantity", nullable = false)
    private int quantity;

    @JsonProperty("price")
    @Column(name = "price", nullable = false)
    private float price;


}
