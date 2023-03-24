package com.numble.karrotmarket.product.controller.dto;

import com.numble.karrotmarket.product.domain.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductCreationRequest(@NotBlank String location,
                                     @NotBlank String title, @NotNull Long price,
                                     @NotBlank String content, @NotNull Category category) {

}
