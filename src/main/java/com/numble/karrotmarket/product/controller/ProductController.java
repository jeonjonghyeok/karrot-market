package com.numble.karrotmarket.product.controller;

import com.numble.karrotmarket.product.controller.dto.ProductCreationRequest;
import com.numble.karrotmarket.product.controller.dto.ProductResponse;
import com.numble.karrotmarket.product.domain.Product;
import com.numble.karrotmarket.product.service.ProductService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductResponse> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody @Valid final ProductCreationRequest request) {
        return productService.createProduct(request);
    }

}
