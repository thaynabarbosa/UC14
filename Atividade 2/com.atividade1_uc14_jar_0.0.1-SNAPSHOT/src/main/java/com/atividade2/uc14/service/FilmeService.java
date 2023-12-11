package com.atividade2.uc14.service;

import com.atividade2.uc14.model.Filme;
import com.atividade2.uc14.repository.FilmeRepository;
import java.util.List;
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
    
    public List<Filme> listarTodos(){
       return filmeRepository.findAll();
    }
    
    public Filme buscarPorId(Integer id){
        return filmeRepository.findById(id).orElseThrow();
    }
    
    public void excluir (Integer id){
      Filme filmeEncontrado = buscarPorId(id);
      filmeRepository.deleteById(filmeEncontrado.getId());
    }
    
    public Filme atualizar(Integer id,Filme filmeAtualizado){
        Filme filmeEncontrado = buscarPorId(id);
        filmeEncontrado.setTitulo(filmeAtualizado.getTitulo());
        filmeEncontrado.setSinopse(filmeAtualizado.getSinopse());
        filmeEncontrado.setGenero(filmeAtualizado.getGenero());
        filmeEncontrado.setAnoLancamento(filmeAtualizado.getAnoLancamento());
        filmeRepository.save(filmeEncontrado);
        return filmeEncontrado;
    }
}
