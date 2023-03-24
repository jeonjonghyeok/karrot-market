package com.numble.karrotmarket.product.service;

import com.numble.karrotmarket.product.controller.dto.ProductCreationRequest;
import com.numble.karrotmarket.product.controller.dto.ProductResponse;
import com.numble.karrotmarket.product.domain.Product;
import com.numble.karrotmarket.product.domain.mapper.ProductDtoMapper;
import com.numble.karrotmarket.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDtoMapper productDtoMapper;

    public List<ProductResponse> getProducts() {
        List<Product> products = productRepository.findAll();
        return productDtoMapper.toProductResponses(products);
    }

    public ProductResponse getProduct(final Long productId) throws NotFoundException {
        Product product = productRepository.findById(productId).orElseThrow(() -> new NotFoundException());
        return productDtoMapper.toProductResponse(product);
    }

    @Transactional
    public Product createProduct(final ProductCreationRequest request, final Long sellerId) {
        final Product product = productDtoMapper.toProduct(request, sellerId);
        return productRepository.save(product);
    }

}
