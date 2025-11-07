package com.bibek.ecommercespring.service;

import com.bibek.ecommercespring.dto.ProductResponse;
import com.bibek.ecommercespring.dto.RequestProduct;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductResponse createProduct(RequestProduct request);
    List<ProductResponse> getAllProducts();
    Optional<ProductResponse> getProductById(Long id);
    ProductResponse updateProduct(Long id, RequestProduct request);
    void deleteProduct(Long id);
}
