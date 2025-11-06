package com.bibek.ecommercespring.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private Long id;
    private String title;
    private float price;
    private String image;
    private String color;
    private String description;
    private float discount;
    private String brand;
    private boolean popular;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
