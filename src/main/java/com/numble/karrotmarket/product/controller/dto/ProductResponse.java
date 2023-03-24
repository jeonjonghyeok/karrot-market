package com.numble.karrotmarket.product.controller.dto;

import com.numble.karrotmarket.product.domain.Category;
import com.numble.karrotmarket.product.domain.constants.ProductStatus;

public record ProductResponse(String location, String title, Long price, String content,
                              ProductStatus status, Category category) {

}
