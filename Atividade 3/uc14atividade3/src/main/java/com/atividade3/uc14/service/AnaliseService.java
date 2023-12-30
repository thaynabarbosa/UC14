package com.atividade3.uc14.service;

import com.atividade3.uc14.model.Analise;
import com.atividade3.uc14.repository.AnaliseRepository;
import java.util.List;
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
    
    public List<Analise> listarTodos(Integer id){
       return analiseRepository.findByFilmesId(id);
    }
    
        public Analise buscarPorId(Integer id){
        return analiseRepository.findById(id).orElseThrow();
    }
    
    //exclui a análise do filme no banco de dados
    public void excluirAnalise (Integer id){
      Analise analiseEncontrado = buscarPorId(id);
      analiseRepository.deleteById(analiseEncontrado.getId());
    }
    
    //exclui todas as análise relacionadas ao filme no banco de dados
    public void excluirTodasAnalises(Integer id){
      for(Analise analise : listarTodos(id)){
          excluirAnalise(analise.getId());
      }
    }
    
    public Analise atualizar(Integer id,Analise analiseAtualizada){
        Analise analiseEncontrada = buscarPorId(id);
        //analiseEncontrada.setFilme(analiseAtualizada.getFilme());
        analiseEncontrada.setAnalises(analiseAtualizada.getAnalises());
        analiseEncontrada.setNota(analiseAtualizada.getNota());
        analiseRepository.save(analiseEncontrada);
        return analiseEncontrada;
    }
}
