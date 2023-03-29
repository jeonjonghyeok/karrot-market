package com.numble.karrotmarket.product.controller;

import com.numble.karrotmarket.common.argumentresolver.annotation.InjectUserId;
import com.numble.karrotmarket.product.controller.dto.ProductCreationRequest;
import com.numble.karrotmarket.product.controller.dto.ProductResponse;
import com.numble.karrotmarket.product.domain.Category;
import com.numble.karrotmarket.product.domain.Product;
import com.numble.karrotmarket.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "상품 리스트 조회", description = "상품 리스트 조회", tags = { "Product Controller" })
    @SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
    @GetMapping
    public List<ProductResponse> getProducts() {
        return productService.getProducts();
    }

    @Operation(summary = "상품 단건 조회", description = "상품 단건 조회", tags = { "Product Controller" })
    @SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable Long id) throws NotFoundException {
        return productService.getProduct(id);
    }

    @Operation(summary = "상품 생성", description = "상품 생성", tags = { "Product Controller" })
    @SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
    @PostMapping
    public Product createProduct(@RequestBody @Valid final ProductCreationRequest request, @InjectUserId final Long userId) {
        return productService.createProduct(request, userId);
    }

    @Operation(summary = "상품 카테고리 조회", description = "상품 카테고리 조회", tags = { "Product Controller" })
    @SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
    @GetMapping("/category")
    public List<Category> getCategoryList() {
        return Category.getCategory();
    }

}
