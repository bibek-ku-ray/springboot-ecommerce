package com.bibek.ecommercespring.service;

import com.bibek.ecommercespring.dto.ProductResponse;
import com.bibek.ecommercespring.dto.RequestProduct;

public interface ProductService {
    ProductResponse createProduct(RequestProduct request);
}
