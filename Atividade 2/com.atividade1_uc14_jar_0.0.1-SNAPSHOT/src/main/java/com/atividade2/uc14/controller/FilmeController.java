package com.atividade2.uc14.controller;

import com.atividade2.uc14.model.Analise;
import com.atividade2.uc14.model.Filme;
import com.atividade2.uc14.service.AnaliseService;
import com.atividade2.uc14.service.FilmeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilmeController {

    @Autowired
    FilmeService filmeservice;
    AnaliseService analiseservice;
    
    @GetMapping("/index")
    public String inicio(Model model) {
       model.addAttribute("filme", new Filme());
        return "CadastroFilmes";
    }

    @PostMapping("/cadastro")
    public String cadastroFilmes(@ModelAttribute Filme filmes, Model model) {
        filmeservice.criar(filmes);
        model.addAttribute("filme", filmes);
        return "redirect:/lista";
    }

    @GetMapping("/lista")
    public String listaFilmes(Model model) {
        model.addAttribute("lista", filmeservice.listarTodos());
        return "listaFilmes";
    }

    @GetMapping("/exibir")
    public String mostrarDetalhesFilme(Model model, @RequestParam String id) {
        Integer idFilme = Integer.parseInt(id);
        
        Filme registroEncontrado = new Filme();
        registroEncontrado = filmeservice.buscarPorId(idFilme);
        
        Analise analiseEncontrada = new Analise();
        analiseEncontrada = analiseservice.buscarPorId(idFilme);
        
        model.addAttribute("registroFilme", registroEncontrado);
        model.addAttribute("analiseFilme", analiseEncontrada);
        return "ExibirFilmes";
    }

    @GetMapping("/formularioAnalises")
    public String cadastroAnalise(Model model){
        model.addAttribute("analiseModel", new Analise());
        return "CadastroAnalise";
    }
   
    @PostMapping("/avaliacao")
    public String gravarAnalise(Model model,@ModelAttribute Analise analise) {
        //analise.setId(listaAnalise.size()+1);
      //  listaAnalise.add(analise);
        analiseservice.criar(analise);
        model.addAttribute("analiseModel", analise);
        return "redirect:/lista";
    }
   
    @GetMapping("/excluir")
    public String deletaFilme(Model model, @RequestParam String id) {
        Integer idFilme = Integer.parseInt(id);
        filmeservice.excluir(idFilme);
        return "redirect:/lista";
    }
    
    @GetMapping("/alterar")
    public String alterarFilme(Model model, @RequestParam String id) {
        Integer idFilme = Integer.parseInt(id);
        Filme filmeencontrado = filmeservice.buscarPorId(idFilme);
        model.addAttribute("filme",filmeencontrado);
        return "alterar";
    }
}

