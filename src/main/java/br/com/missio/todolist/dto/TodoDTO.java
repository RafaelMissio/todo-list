package br.com.missio.todolist.dto;

import br.com.missio.todolist.entities.Todo;

public class TodoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private boolean concluido;
    private int prioridade;

    public TodoDTO(Long id, String nome, String descricao, boolean concluido, int prioridade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.concluido = concluido;
        this.prioridade = prioridade;
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
}
