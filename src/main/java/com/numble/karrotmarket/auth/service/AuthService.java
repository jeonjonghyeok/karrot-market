package com.numble.karrotmarket.auth.service;

import com.numble.karrotmarket.auth.controller.dto.SignInRequest;
import com.numble.karrotmarket.auth.controller.dto.SignUpRequest;
import com.numble.karrotmarket.common.component.jwt.JwtTokenProvider;
import com.numble.karrotmarket.user.domain.User;
import com.numble.karrotmarket.user.service.vo.CreateUserVo;
import com.numble.karrotmarket.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final JwtTokenProvider tokenProvider;

    public User signup(final SignUpRequest request) {
        return userService.createUser(CreateUserVo.of(request));
    }

    public String login(final SignInRequest request) {
        final User user = userService.getUserByEmail(request.email());

        userService.validatePassword(request.password(), user.getPassword());
        return tokenProvider.generateToken(user.getSeq().toString(), user.getRole());
    }

}
