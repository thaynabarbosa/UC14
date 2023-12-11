package com.atividade2.uc14.repository;


import com.atividade2.uc14.model.Analise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnaliseRepository extends JpaRepository <Analise,Integer>{
    
}
