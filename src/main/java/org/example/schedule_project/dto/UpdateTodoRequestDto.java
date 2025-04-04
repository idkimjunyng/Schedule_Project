package org.example.schedule_project.dto;

import lombok.Getter;

@Getter
public class UpdateTodoRequestDto {

    private final String title;
    private final String content;


    public UpdateTodoRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
