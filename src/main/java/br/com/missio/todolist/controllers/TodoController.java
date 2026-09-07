package br.com.missio.todolist.controllers;

import br.com.missio.todolist.dto.TodoDTO;
import br.com.missio.todolist.services.TodoService;
import jakarta.validation.Valid;
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
        TodoDTO todoDTO = todoService.findById(id);
        return ResponseEntity.ok().body(todoDTO);
    }

    @GetMapping
    public ResponseEntity<Page<TodoDTO>> findAll(Pageable pageable){
        Page<TodoDTO> dto = (Page<TodoDTO>) todoService.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<TodoDTO> create(@Valid @RequestBody TodoDTO dto) {
        dto = todoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TodoDTO> update( @PathVariable Long id,@Valid @RequestBody TodoDTO dto) {
        dto= todoService.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }



}