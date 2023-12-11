package com.atividade2.uc14.repository;

import com.atividade2.uc14.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository <Filme,Integer> {
    
}

