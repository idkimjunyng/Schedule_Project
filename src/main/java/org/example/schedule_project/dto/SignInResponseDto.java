package org.example.schedule_project.dto;

import lombok.Getter;

@Getter
public class SignInResponseDto {

    private final Long id;
    private final String email;
    private final String password;

    public SignInResponseDto(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
