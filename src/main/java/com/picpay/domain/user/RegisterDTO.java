package com.picpay.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
