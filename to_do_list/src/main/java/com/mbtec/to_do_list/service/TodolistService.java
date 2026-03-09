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
}
