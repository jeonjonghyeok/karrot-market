package com.numble.karrotmarket.product.controller.dto;

import com.numble.karrotmarket.product.domain.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ProductCreationRequest {

    @NotNull
    private Long sellerId;

    @NotBlank
    private String location;

    @NotBlank
    private String title;

    @NotNull
    private Long price;

    @NotBlank
    private String content;

    @NotNull
    private Category category;

}
