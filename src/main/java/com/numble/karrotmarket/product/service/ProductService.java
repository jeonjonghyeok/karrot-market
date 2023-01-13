package com.numble.karrotmarket.product.service;

import com.numble.karrotmarket.product.domain.mapper.ProductDtoMapper;
import com.numble.karrotmarket.product.controller.dto.ProductCreationRequest;
import com.numble.karrotmarket.product.controller.dto.ProductResponse;
import com.numble.karrotmarket.product.domain.Product;
import com.numble.karrotmarket.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDtoMapper productDtoMapper;

    public List<ProductResponse> getProducts() {
        List<Product> products = productRepository.findAll();
        return productDtoMapper.toProductResponses(products);
    }

    @Transactional
    public Product createProduct(final ProductCreationRequest request) {
        final Product product = productDtoMapper.toProduct(request);
        product.setSellerId(request.getSellerId());
        return productRepository.save(product);
    }

}
