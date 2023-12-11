package com.atividade2.uc14.controller;

import com.atividade2.uc14.model.Filme;
import com.atividade2.uc14.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filme")
public class FilmeAPIController {

    @Autowired
    FilmeService filmeService;
    
    
    @PostMapping("/adicionar")
    public ResponseEntity<Filme> addFilme(@RequestBody Filme film){
        var novoFilm = filmeService.criar(film);
        return new ResponseEntity<>(novoFilm,HttpStatus.CREATED);
    }
}

