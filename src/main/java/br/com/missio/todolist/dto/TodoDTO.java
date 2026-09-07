package br.com.missio.todolist.dto;

import br.com.missio.todolist.entities.Todo;
import jakarta.validation.constraints.*;

public class TodoDTO {

    private Long id;

    @NotBlank(message = "O nome não pode ser vazio")
    @Size(max = 50, min = 6, message = "O nome não pode ter mais de 50 caracteres")
    private String nome;

    @Size(max = 200, message = "A descrição não pode ter mais de 200 caracteres")
    private String descricao;

    @NotNull(message = "O campo concluido é obrigatório")
    private boolean concluido;

    @Min(value = 1, message = "Prioridade mínima é 1")
    @Max(value = 5, message = "Prioridade máxima é 5")
//    @NotNull(message = "Prioridade é obrigatória")
    private int prioridade;

    private TodoDTO() {

    }


    public TodoDTO(Todo entity) {
        id = entity.getId();
        nome = entity.getNome();
        descricao = entity.getDescricao();
        concluido = entity.isConcluido();
        prioridade = entity.getPrioridade();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}
