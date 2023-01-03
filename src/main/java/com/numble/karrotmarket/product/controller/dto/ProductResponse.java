package com.numble.karrotmarket.product.controller.dto;

import com.numble.karrotmarket.product.domain.constants.ProductStatus;
import com.numble.karrotmarket.product.domain.Category;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductResponse {

    private String location;

    private String title;

    private Long price;

    private String content;

    private ProductStatus status;

    private Category category;
}
