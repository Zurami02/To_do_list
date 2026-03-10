package com.mbtec.to_do_list.repo;

import com.mbtec.to_do_list.modal.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodolistRepository extends JpaRepository<Todolist, Integer> {

    @Query("SELECT t FROM Todolist t WHERE " +
            "LOWER(t.tarefa) LIKE LOWER (CONCAT('%', :pesquisado, '%')) OR " +
            "LOWER(t.datatime) LIKE LOWER (CONCAT('%', :pesquisado, '%'))")
    List<Todolist> pesquisartarefas(@Param("pesquisado") String pesquisado);
}
