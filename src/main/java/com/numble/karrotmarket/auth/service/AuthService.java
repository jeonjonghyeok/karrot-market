package com.numble.karrotmarket.auth.service;

import com.numble.karrotmarket.common.component.jwt.JwtTokenProvider;
import com.numble.karrotmarket.user.controller.dto.SignInRequest;
import com.numble.karrotmarket.user.controller.dto.SignUpRequest;
import com.numble.karrotmarket.user.domain.User;
import com.numble.karrotmarket.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final JwtTokenProvider tokenProvider;

    public User signup(final SignUpRequest request) {
        return userService.createUser(request);
    }

    public String login(final SignInRequest request) {
        final User user = userService.getUserByEmail(request.getEmail());
        return tokenProvider.generateToken(user.getSeq().toString(), user.getRole());
    }


}
