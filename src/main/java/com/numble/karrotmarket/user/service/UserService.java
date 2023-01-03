package com.numble.karrotmarket.user.service;

import com.numble.karrotmarket.common.exception.error.ErrorCode;
import com.numble.karrotmarket.user.domain.Role;
import com.numble.karrotmarket.user.domain.User;
import com.numble.karrotmarket.user.repository.UserRepository;
import com.numble.karrotmarket.user.service.dto.CreateUserDto;
import java.util.InputMismatchException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User getUserByEmail(final String email) {
        return userRepository.findByEmail(email).orElseThrow(() ->
            new UsernameNotFoundException(ErrorCode.USER_NOT_FOUND.getMessage()));
    }

    public User createUser(final CreateUserDto createUserDto) {
        if (userRepository.existsByEmail(createUserDto.getEmail())) {
            throw new DuplicateKeyException(ErrorCode.USER_DUPLICATE.getMessage());
        }

        final User user = User.builder()
            .email(createUserDto.getEmail())
            .name(createUserDto.getName())
            .nickname(createUserDto.getNickname())
            .password(bCryptPasswordEncoder.encode(createUserDto.getPassword()))
            .phoneNumber(createUserDto.getPhoneNumber())
            .role(Role.ROLE_USER)
            .build();

        return userRepository.save(user);
    }

    public void validatePassword(final String inputPassword, final String password) {
        boolean matches = bCryptPasswordEncoder.matches(inputPassword, password);
        if (!matches) {
            throw new InputMismatchException(ErrorCode.PASSWORD_MISMATCH.getMessage());
        }
    }

}
