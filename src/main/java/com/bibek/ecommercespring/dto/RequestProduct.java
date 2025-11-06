package com.bibek.ecommercespring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestProduct {

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @Positive(message = "Price cannot be negative")
    @NotNull(message = "Price cannot be empty or negative")
    private float price;

    @NotBlank(message = "Image url is required")
    private String image;

    private String color;

    @NotBlank(message = "Description url is required")
    private String description;

    @Positive(message = "Price cannot be negative")
    private float discount;

    private String brand;

    @NotNull(message = "Popular field cannot be empty")
    private boolean popular;
}
