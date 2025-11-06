package com.bibek.ecommercespring.mapper;

import com.bibek.ecommercespring.dto.ProductResponse;
import com.bibek.ecommercespring.model.Product;

public class ProductMapper {

    public static ProductResponse toDto(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .image(product.getImage())
                .color(product.getColor())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }
}
