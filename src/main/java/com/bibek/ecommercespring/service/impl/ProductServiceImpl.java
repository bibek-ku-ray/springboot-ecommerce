package com.bibek.ecommercespring.service.impl;

import com.bibek.ecommercespring.dto.ProductResponse;
import com.bibek.ecommercespring.dto.RequestProduct;
import com.bibek.ecommercespring.mapper.ProductMapper;
import com.bibek.ecommercespring.model.Product;
import com.bibek.ecommercespring.repository.ProductRepository;
import com.bibek.ecommercespring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponse createProduct(RequestProduct request) {
        Product product = Product.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .brand(request.getBrand())
                .color(request.getColor())
                .image(request.getImage())
                .price(request.getPrice())
                .discount(request.getDiscount())
                .popular(request.isPopular())
                .build();
        Product savedProduct = productRepository.save(product);
        return ProductMapper.toDto(savedProduct);
    }
}
