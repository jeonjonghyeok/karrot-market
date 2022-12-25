package com.numble.karrotmarket.auth.controller;

import com.numble.karrotmarket.auth.service.AuthService;
import com.numble.karrotmarket.auth.controller.dto.SignInRequest;
import com.numble.karrotmarket.auth.controller.dto.SignUpRequest;
import com.numble.karrotmarket.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public User signup(@RequestBody @Validated SignUpRequest request) {
        return authService.signup(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody @Validated SignInRequest request) {
        return authService.login(request);
    }

}
