package com.animerch.marketplace.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

// IDEA not able to resolve MySQL table attributes
@SuppressWarnings("ALL")

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;
}
