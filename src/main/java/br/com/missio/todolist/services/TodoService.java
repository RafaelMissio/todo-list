package br.com.missio.todolist.services;

import br.com.missio.todolist.dto.TodoDTO;
import br.com.missio.todolist.entities.Todo;
import br.com.missio.todolist.repositories.TodoRepository;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;



@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final ModelMapper modelMapper;


    public TodoService(TodoRepository todoRepository, ModelMapper modelMapper) {
        this.todoRepository = todoRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public TodoDTO  create(TodoDTO dto) {
        Todo entity = new Todo();
        modelMapper.map(dto, entity);
        entity = todoRepository.save(entity);
        return new TodoDTO(entity);
    }

   @Transactional(readOnly = true)
    public Page<TodoDTO> findAll(Pageable pageable) {
        Page<Todo> result = todoRepository.findAll(pageable);
        return result.map(TodoDTO::new);
    }

    @Transactional(readOnly = true)
    public TodoDTO findById(Long id) {
       Todo todo = todoRepository.findById(id).orElseThrow(() ->
               new RuntimeException("Todo not found with id: " + id));
       return new TodoDTO(todo);
    }

    public TodoDTO update(Long id, TodoDTO dto) {
        Todo entity = todoRepository.getReferenceById(id);
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(dto, entity);

        entity = todoRepository.save(entity);
        return new TodoDTO(entity);
    }

    @Transactional
    public void delete(Long id){
        todoRepository.deleteById(id);
    }
}
