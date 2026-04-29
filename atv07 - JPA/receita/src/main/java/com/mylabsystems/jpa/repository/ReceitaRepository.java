package com.mylabsystems.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mylabsystems.jpa.model.Receita;

public interface ReceitaRepository
        extends JpaRepository<Receita, Long> {

    List<Receita> buscarPorEmPromocao();
}
