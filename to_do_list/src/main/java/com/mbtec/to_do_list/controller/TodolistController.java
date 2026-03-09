package com.mbtec.to_do_list.controller;

import com.mbtec.to_do_list.modal.Todolist;
import com.mbtec.to_do_list.service.TodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mbtec")
public class TodolistController {

    @Autowired
    private TodolistService service;

    @GetMapping("/greating")
    public String greating(){
        return "Bem vindo a Mbtec";
    }

    @PostMapping("/add")
    public ResponseEntity<?> adicionarTodoList(@RequestBody Todolist tarefa){
        Todolist tarefa1 =service.adicionarTarefa(tarefa);
        System.out.println(tarefa1);
        return new ResponseEntity<>(tarefa1, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Todolist>> alistartarefas(){
        return new ResponseEntity<>(service.alistarTodasTarefas(), HttpStatus.OK);
    }
}
