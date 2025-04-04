package org.example.schedule_project.dto;

import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private final Long id;
    private final String name;
    private final String email;
    private final String password;

    public SignUpResponseDto(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
