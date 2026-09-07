package br.com.missio.todolist.controllers;

import br.com.missio.todolist.dto.TodoDTO;
import br.com.missio.todolist.entities.Todo;
import br.com.missio.todolist.services.TodoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<TodoDTO> findByID(@PathVariable Long id){
        return ResponseEntity.ok().body(todoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<TodoDTO>> findAll(Pageable pageable){

        return ResponseEntity.ok().body((Page<TodoDTO>) todoService.findAll(pageable));
    }




}