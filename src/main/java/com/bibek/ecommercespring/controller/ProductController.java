package com.bibek.ecommercespring.controller;

import com.bibek.ecommercespring.dto.ProductResponse;
import com.bibek.ecommercespring.dto.RequestProduct;
import com.bibek.ecommercespring.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody RequestProduct request) {
        ProductResponse response = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> allProducts = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(allProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        ProductResponse productResponse = productService.getProductById(id).orElseThrow();
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody RequestProduct request) {
        ProductResponse updatedProduct = productService.updateProduct(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
