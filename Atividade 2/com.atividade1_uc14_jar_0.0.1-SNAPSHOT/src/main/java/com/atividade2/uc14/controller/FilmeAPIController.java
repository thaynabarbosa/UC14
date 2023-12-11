package com.atividade2.uc14.controller;

import com.atividade2.uc14.model.Filme;
import com.atividade2.uc14.service.FilmeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/listar")
    public ResponseEntity<List> listarFilme(){
        List<Filme> filmes = filmeService.listarTodos();
        return new ResponseEntity<>(filmes,HttpStatus.OK);
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Filme> pesquisar(@PathVariable Integer id){
        Filme filmeEncontrado = filmeService.buscarPorId(id);
        return new ResponseEntity<>(filmeEncontrado,HttpStatus.OK);
    }
    
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirFilme(@PathVariable Integer id){
        filmeService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
