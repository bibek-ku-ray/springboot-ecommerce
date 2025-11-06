package com.bibek.ecommercespring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "products")
@Entity
public class Product extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private String image;

    private String color;

    @Column(nullable = false)
    private String description;

    private float discount;

    private String brand;

    @Column(nullable = false)
    private boolean popular;

}
