package com.mbtec.to_do_list.service;

import com.mbtec.to_do_list.modal.Todolist;
import com.mbtec.to_do_list.repo.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodolistService {

    @Autowired
    private TodolistRepository repos;

    public Todolist adicionarTarefa(Todolist tarefa) {
        return repos.save(tarefa);
    }

    public List<Todolist> alistarTodasTarefas() {
        return repos.findAll();
    }

    public Todolist atualizartarefa(int id, Todolist tarefa) {
        tarefa.setId(id);
        return repos.save(tarefa);
    }

    public Todolist atualizartaStatus(int id, Todolist tarefa) {
        Todolist tarefaExistente = repos.findById(id).orElse(null);
        if (tarefaExistente != null) {
            tarefaExistente.setStatus(tarefa.isStatus());
            return repos.save(tarefaExistente);
        }
        return null;
    }

    public Todolist alistarPorId(int id) {
        return repos.findById(id).orElse(null);
    }

    public void deletarTarefa(int id) {
        repos.deleteById(id);
    }

    public List<Todolist> pesquisarTarefas(String pesquisado) {
        return repos.pesquisartarefas(pesquisado);
    }
}
