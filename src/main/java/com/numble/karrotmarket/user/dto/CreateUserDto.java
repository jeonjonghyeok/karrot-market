package com.numble.karrotmarket.user.dto;

import com.numble.karrotmarket.auth.controller.dto.SignUpRequest;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserDto {

    private String email;

    private String password;

    private String name;

    private String phoneNumber;

    private String nickname;

    public static CreateUserDto of(final SignUpRequest request) {
        return CreateUserDto.builder()
            .email(request.getEmail())
            .password(request.getPassword())
            .name(request.getName())
            .nickname(request.getNickname())
            .phoneNumber(request.getPhoneNumber())
            .build();
    }

}
