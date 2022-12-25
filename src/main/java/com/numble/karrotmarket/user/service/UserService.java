package com.numble.karrotmarket.user.service;

import com.numble.karrotmarket.common.exception.error.ErrorCode;
import com.numble.karrotmarket.user.controller.dto.SignUpRequest;
import com.numble.karrotmarket.user.domain.Role;
import com.numble.karrotmarket.user.domain.User;
import com.numble.karrotmarket.user.repository.UserRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserByEmail(final String email) {
        return userRepository.findByEmail(email).orElseThrow(() ->
            new UsernameNotFoundException(ErrorCode.USER_NOT_FOUND.getMessage()));
    }

    public User createUser(final SignUpRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateKeyException(ErrorCode.USER_DUPLICATE.getMessage());
        }

        final User user = User.builder()
            .email(request.getEmail())
            .name(request.getName())
            .nickname(request.getNickname())
            .password(request.getPassword())
            .phoneNumber(request.getPhoneNumber())
            .registDtm(LocalDateTime.now())
            .role(Role.ROLE_USER)
            .build();

        return userRepository.save(user);
    }

}
