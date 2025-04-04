package org.example.schedule_project.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.schedule_project.dto.DetailTodoResponseDto;
import org.example.schedule_project.dto.TodoResponseDto;
import org.example.schedule_project.entity.Member;
import org.example.schedule_project.entity.Todo;
import org.example.schedule_project.repository.MemberRepository;
import org.example.schedule_project.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final MemberRepository memberRepository;
    private final TodoRepository todoRepository;

    public TodoResponseDto create(String todo_title, String todo_content, String member_email) {

        Member findMember = memberRepository.findMemberByMemberEmailOrElseThrow(member_email);

        Todo todo = new Todo(todo_title, todo_content);
        todo.setMember(findMember);

        Todo createTodo = todoRepository.save(todo);

        return new TodoResponseDto(createTodo.getId(), createTodo.getTitle(), createTodo.getContent());

    }

    public List<TodoResponseDto> findAll() {
        return todoRepository.findAll().stream().map(TodoResponseDto::toDto).toList();
    }

    public DetailTodoResponseDto findById(Long id) {
        Todo findTodo = todoRepository.findByIdOrElseThrow(id);
        Member writer = findTodo.getMember();

        return new DetailTodoResponseDto(findTodo.getId(), findTodo.getTitle(), findTodo.getContent(), writer.getId(), writer.getEmail(), writer.getName());
    }

    @Transactional
    public void updateTodo(Long id, String title, String content) {

        Todo findTodo = todoRepository.findByIdOrElseThrow(id);

        findTodo.updateTodo(id, title, content);

    }

    public void deleteTodo(Long id) {
        Todo findTodo = todoRepository.findByIdOrElseThrow(id);
        todoRepository.delete(findTodo);
    }
}
