package com.atividade3.uc14.repository;

import com.atividade3.uc14.model.Analise;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AnaliseRepository extends JpaRepository <Analise,Integer>{
    
    List<Analise> findByFilmesId(Integer filmeId);
    
    
}
