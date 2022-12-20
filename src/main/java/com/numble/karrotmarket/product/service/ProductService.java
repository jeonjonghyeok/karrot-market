package com.numble.karrotmarket.product.service;

import com.numble.karrotmarket.product.controller.request.ProductCreationRequest;
import com.numble.karrotmarket.product.domain.Product;
import com.numble.karrotmarket.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(ProductCreationRequest request) {
        final Product product = Product.builder()
            .title(request.getTitle())
            .content(request.getContent())
            .build();
        return productRepository.save(product);
    }

}
