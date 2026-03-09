package com.mbtec.to_do_list.repo;

import com.mbtec.to_do_list.modal.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodolistRepository extends JpaRepository<Todolist, Integer> {
}
