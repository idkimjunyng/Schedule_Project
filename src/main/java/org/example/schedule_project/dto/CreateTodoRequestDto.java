package org.example.schedule_project.dto;

import lombok.Getter;

@Getter
public class CreateTodoRequestDto {

    private final Long id;
    private final String title;
    private final String content;
    private final String email;

    public CreateTodoRequestDto(Long id, String title, String content, String email) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.email = email;
    }
}
