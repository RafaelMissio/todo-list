package br.com.missio.todolist.services;

import br.com.missio.todolist.entities.Todo;
import br.com.missio.todolist.repositories.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo>  create(Todo todo) {
        todoRepository.save(todo);
        return findAll();
    }

    public List<Todo> findAll() {
        Sort sort = Sort.by("prioridade").descending().and((
                Sort.by("nome").ascending()
                ));
        return todoRepository.findAll(sort);
    }

    public Todo findById(Long id) {
        return todoRepository.findById(id).orElse(null);
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
        return findAll();
    }
}
