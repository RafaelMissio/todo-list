package br.com.missio.todolist.services;

import br.com.missio.todolist.dto.TodoDTO;
import br.com.missio.todolist.entities.Todo;
import br.com.missio.todolist.repositories.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo  create(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<TodoDTO> findAll(Pageable pageable) {

        Page<Todo> result = todoRepository.findAll(pageable);
        return result.stream().map(TodoDTO::new).toList();
    }

    @Transactional
    public TodoDTO findById(Long id) {
       Todo todo = todoRepository.findById(id).get();
       return new TodoDTO(todo);
    }

    public Todo update(Todo todo) {
        if(todoRepository.existsById(todo.getId())) {
            return todoRepository.save(todo);
        } else {
            return null;
        }
    }

    public List<Todo> delete(Long id) {
        if(todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
        }
        return todoRepository.findAll();
    }
}
