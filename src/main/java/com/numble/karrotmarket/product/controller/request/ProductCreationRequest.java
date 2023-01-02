package com.numble.karrotmarket.product.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ProductCreationRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

}
