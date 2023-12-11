package com.atividade2.uc14.service;

import com.atividade2.uc14.model.Filme;
import com.atividade2.uc14.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {
 
    @Autowired
    FilmeRepository filmeRepository;
    
    public Filme criar(Filme film){
        film.setId(null);
        filmeRepository.save(film);
        return film;
    }
    
}
