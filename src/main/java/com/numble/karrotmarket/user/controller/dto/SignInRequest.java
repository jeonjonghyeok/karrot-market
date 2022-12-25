package com.numble.karrotmarket.user.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class SignInRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

}
