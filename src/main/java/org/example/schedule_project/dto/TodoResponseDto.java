package org.example.schedule_project.dto;

import lombok.Getter;
import org.example.schedule_project.entity.Todo;

@Getter
public class TodoResponseDto {

    private final Long id;
    private final String title;
    private final String content;

    public TodoResponseDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static TodoResponseDto toDto(Todo todo) {
        return new TodoResponseDto(todo.getId(), todo.getTitle(), todo.getContent());
    }

}
