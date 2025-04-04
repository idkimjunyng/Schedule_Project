package org.example.schedule_project.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedule_project.dto.CreateTodoRequestDto;
import org.example.schedule_project.dto.DetailTodoResponseDto;
import org.example.schedule_project.dto.TodoResponseDto;
import org.example.schedule_project.dto.UpdateTodoRequestDto;
import org.example.schedule_project.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponseDto> create_todo(@RequestBody CreateTodoRequestDto createTodoRequestDto) {

        TodoResponseDto todoResponseDto = todoService.create(createTodoRequestDto.getTitle(), createTodoRequestDto.getContent(), createTodoRequestDto.getEmail());

        return new ResponseEntity<>(todoResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> findAll() {
        List<TodoResponseDto> todoResponseDto = todoService.findAll();

        return new ResponseEntity<>(todoResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailTodoResponseDto> findById(@PathVariable Long id) {
        DetailTodoResponseDto detailTodoResponseDto = todoService.findById(id);

        return new ResponseEntity<>(detailTodoResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateTodo(@PathVariable Long id, @RequestBody UpdateTodoRequestDto updateTodoRequestDto) {

        todoService.updateTodo(id, updateTodoRequestDto.getTitle(), updateTodoRequestDto.getContent());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TodoResponseDto> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
