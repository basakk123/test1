package com.example.hellomarket.dto;

import com.example.hellomarket.domain.Users;

import lombok.Getter;
import lombok.Setter;

public class UsersReqDto {

    @Setter
    @Getter
    public static class JoinReqDto { // 로그인 전 인증관련 로직들은 전부 다 앞에 엔티티 안붙임. POST /user => /join
        private String username;
        private String password;

        public Users toEntity() {
            return Users.builder().username(username).password(password).build();
        }
    }

    @Setter
    @Getter
    public static class LoginReqDto {
        private String username;
        private String password;
    }

    @Setter
    @Getter
    public static class UpdatePasswordReqDto {
        private String password;
        private Long id; // 서비스 로직

        public Users toEntity() {
            return Users.builder()
                    .password(password)
                    .id(id)
                    .build();
        }
    }
}
