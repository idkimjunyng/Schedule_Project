package org.example.schedule_project.dto;

import lombok.Getter;

@Getter
public class UpdateMemberRequestDto {

    private final String name;
    private final String email;
    private final String password;


    public UpdateMemberRequestDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
