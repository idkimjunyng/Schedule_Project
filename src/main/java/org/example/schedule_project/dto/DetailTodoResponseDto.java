package org.example.schedule_project.dto;

import lombok.Getter;

@Getter
public class DetailTodoResponseDto {

    private Long id;
    private final String title;
    private final String content;
    private final Long writerId;
    private final String email;
    private final String name;

    public DetailTodoResponseDto(Long id, String title, String content, Long writerId, String email, String name) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writerId = writerId;
        this.email = email;
        this.name = name;
    }
}
