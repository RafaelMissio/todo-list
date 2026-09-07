package br.com.missio.todolist.dto;

import br.com.missio.todolist.entities.Todo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TodoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private boolean concluido;
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
