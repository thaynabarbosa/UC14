package com.atividade3.uc14.repository;

import com.atividade3.uc14.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository <Filme,Integer>  {
    
}
