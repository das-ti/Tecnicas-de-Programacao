package com.mylabsystems.jpa.repository;

import com.mylabsystems.jpa.model.Aluno;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AlunoRepository
        extends JpaRepository<Aluno, Long> {

    @Query("SELECT a FROM Aluno a WHERE a.nome = :nome")
    List<Aluno> buscarPorNome(@Param("nome") String nome);
}
