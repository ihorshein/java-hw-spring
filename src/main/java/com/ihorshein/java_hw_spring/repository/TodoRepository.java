package com.ihorshein.java_hw_spring.repository;

import com.ihorshein.java_hw_spring.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> { }
