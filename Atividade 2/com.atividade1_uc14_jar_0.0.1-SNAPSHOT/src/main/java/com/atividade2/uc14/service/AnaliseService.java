package com.atividade2.uc14.service;


import com.atividade2.uc14.model.Analise;
import com.atividade2.uc14.repository.AnaliseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnaliseService {
    
    @Autowired
    AnaliseRepository analiseRepository;
    
    public Analise criar(Analise analis){
        analis.setId(null);
        analiseRepository.save(analis);
        return analis;
    }
}
