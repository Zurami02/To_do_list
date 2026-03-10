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
    public String greating() {
        return "Bem vindo a Mbtec";
    }

    @PostMapping("/add")
    public ResponseEntity<?> adicionarTodoList(@RequestBody Todolist tarefa) {
        Todolist tarefa1 = service.adicionarTarefa(tarefa);
        System.out.println(tarefa1);
        return new ResponseEntity<>(tarefa1, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Todolist>> alistartarefas() {
        return new ResponseEntity<>(service.alistarTodasTarefas(), HttpStatus.OK);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarTarefa(@PathVariable int id, @RequestBody Todolist tarefa) {
        Todolist tarefa1 = null;

        tarefa1 = service.atualizartarefa(id, tarefa);
        if (tarefa1 != null)
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        else
            return new ResponseEntity<>("Failled to update", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<String> excluirTarefaPorId(@PathVariable int id) {
        Todolist tarefa = service.alistarPorId(id);

        if (tarefa != null) {
            service.deletarTarefa(id);
            return new ResponseEntity<>("Tarefa excluida com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tarefa nao existe", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/concluir/{id}")
    public ResponseEntity<String> tarefaFeita(@PathVariable int id, @RequestBody Todolist tarefa) {
        Todolist tarefa1 = null;

        tarefa1 = service.atualizartaStatus(id, tarefa);
        if (tarefa1 != null)
            return new ResponseEntity<>("Estado atualizado: " + tarefa1.getTarefa(), HttpStatus.OK);
        else
            return new ResponseEntity<>("Falha na atualizacao" + id, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/pesquisar/{pesquisado}")
    public ResponseEntity<List<Todolist>> pesquisar(@PathVariable String pesquisado){
        List<Todolist> tarefas = service.pesquisarTarefas(pesquisado);
        return new ResponseEntity<>(tarefas, HttpStatus.OK);
    }
}
