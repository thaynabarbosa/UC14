package com.atividade2.uc14.controller;


import com.atividade2.uc14.model.Analise;
import com.atividade2.uc14.service.AnaliseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analise")
public class AnaliseAPIController {
    
    @Autowired
    AnaliseService analiseService;
    
    @PostMapping("/adicionar")
    public ResponseEntity<Analise> addAnalise(@RequestBody Analise analises){
        var novaAnalise = analiseService.criar(analises);
        return new ResponseEntity<>(novaAnalise,HttpStatus.CREATED);
    }
}
