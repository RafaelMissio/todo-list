package br.com.missio.todolist.repositories;

import br.com.missio.todolist.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
