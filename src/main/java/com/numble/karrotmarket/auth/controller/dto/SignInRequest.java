package com.numble.karrotmarket.auth.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record SignInRequest(
    @NotBlank String email,
    @NotBlank String password) {

}
