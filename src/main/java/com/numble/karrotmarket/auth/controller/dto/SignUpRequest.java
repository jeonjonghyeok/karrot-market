package com.numble.karrotmarket.auth.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record SignUpRequest(@NotBlank String email, @NotBlank String password,
                            @NotBlank String name, @NotBlank String phoneNumber,
                            @NotBlank String nickname) {

}
