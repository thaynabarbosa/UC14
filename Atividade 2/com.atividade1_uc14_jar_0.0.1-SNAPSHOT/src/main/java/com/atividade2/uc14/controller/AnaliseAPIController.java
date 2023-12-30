package com.atividade2.uc14.controller;


import com.atividade2.uc14.model.Analise;

import com.atividade2.uc14.service.AnaliseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  
    @GetMapping("/buscar/{id}")
    public ResponseEntity<List> pesquisar(@PathVariable Integer id){
        List<Analise> lista = analiseService.listarTodos(id);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirFilme(@PathVariable Integer id){
        analiseService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Analise> editarFilme (@PathVariable Integer id,@RequestBody Analise analis){
        var editarAnalise = analiseService.atualizar(id, analis);
        return new ResponseEntity<>(editarAnalise,HttpStatus.OK);
    }
}
