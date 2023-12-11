package com.atividade2.uc14.service;


import com.atividade2.uc14.model.Analise;
import com.atividade2.uc14.model.Filme;
import com.atividade2.uc14.repository.AnaliseRepository;
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
    
    public List<Analise> listarTodos(){
       return analiseRepository.findAll();
    }
    
    public Analise buscarPorId(Integer id){
        return analiseRepository.findById(id).orElseThrow();
    }
    
    public void excluir (Integer id){
      Analise analiseEncontrado = buscarPorId(id);
      analiseRepository.deleteById(analiseEncontrado.getId());
    }
    
    public Analise atualizar(Integer id,Analise analiseAtualizada){
        Analise analiseEncontrada = buscarPorId(id);
        analiseEncontrada.setFilme(analiseAtualizada.getFilme());
        analiseEncontrada.setAnalise(analiseAtualizada.getAnalise());
        analiseEncontrada.setNota(analiseAtualizada.getNota());
        analiseRepository.save( analiseEncontrada);
        return analiseEncontrada;
    }
}
