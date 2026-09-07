package br.com.missio.todolist.services;

import br.com.missio.todolist.dto.TodoDTO;
import br.com.missio.todolist.entities.Todo;
import br.com.missio.todolist.repositories.TodoRepository;

import br.com.missio.todolist.services.exceptions.ResorceNotFoundExceprion;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;




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
       Todo todo = todoRepository.findById(id).orElseThrow(
               () -> new ResorceNotFoundExceprion("Recurso nao encontrado" + id));
       return new TodoDTO(todo);
    }

    public TodoDTO update(Long id, TodoDTO dto) {

        try {Todo entity = todoRepository.getReferenceById(id);
            modelMapper.getConfiguration().setSkipNullEnabled(true);
            modelMapper.map(dto, entity);

            entity = todoRepository.save(entity);
            return new TodoDTO(entity);
        } catch (Exception e) {
            throw new ResorceNotFoundExceprion("Recurso nao encontrado" );
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!todoRepository.existsById(id)){
            throw new ResorceNotFoundExceprion("Recurso nao encontrado" );
        }

        todoRepository.deleteById(id);

    }
}
