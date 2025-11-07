package com.bibek.ecommercespring.service.impl;

import com.bibek.ecommercespring.dto.ProductResponse;
import com.bibek.ecommercespring.dto.RequestProduct;
import com.bibek.ecommercespring.exception.custom.ProductNotFoundException;
import com.bibek.ecommercespring.mapper.ProductMapper;
import com.bibek.ecommercespring.model.Product;
import com.bibek.ecommercespring.repository.ProductRepository;
import com.bibek.ecommercespring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toDto)
                .toList();
    }

    @Override
    public Optional<ProductResponse> getProductById(Long id) {
        Optional<Product> productById = productRepository.findById(id);

        if(productById.isEmpty())
            throw new ProductNotFoundException("Product not found with id:" + id);

        return Optional.ofNullable(ProductMapper.toDto(productById.get()));
    }

    @Override
    public ProductResponse updateProduct(Long id, RequestProduct request) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id:" + id));

        existingProduct.setTitle(request.getTitle());
        existingProduct.setDescription(request.getDescription());
        existingProduct.setBrand(request.getBrand());
        existingProduct.setColor(request.getColor());
        existingProduct.setImage(request.getImage());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setDiscount(request.getDiscount());
        existingProduct.setPopular(request.isPopular());

        productRepository.save(existingProduct);
        return ProductMapper.toDto(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id:" + id));

        productRepository.delete(product);

    }
}
