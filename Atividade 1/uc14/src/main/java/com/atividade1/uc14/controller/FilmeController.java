package com.atividade1.uc14.controller;

import com.atividade1.uc14.model.Analise;
import com.atividade1.uc14.model.Filme;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilmeController {

    private List<Filme> listafilmes = new ArrayList<>();
    private List<Analise> listaAnalise = new ArrayList<>();

    @GetMapping("/index")
    public String inicio(Model model) {
        model.addAttribute("filme", new Filme());
        return "CadastroFilmes";
    }

    @PostMapping("/cadastro")
    public String cadastroFilmes(@ModelAttribute Filme filmes, Model model) {
        filmes.setId(listafilmes.size() + 1);
        listafilmes.add(filmes);
        model.addAttribute("filme", filmes);
        return "redirect:/lista";
    }

    @GetMapping("/lista")
    public String listaFilmes(Model model) {
        model.addAttribute("lista", listafilmes);
        return "listaFilmes";
    }

    @GetMapping("/exibir")
    public String mostrarDetalhesFilme(Model model, @RequestParam String id) {
        Integer idFilme = Integer.parseInt(id);
        Filme registroEncontrado = new Filme();
        for (Filme f : listafilmes) {
            if (f.getId() == idFilme) {
                registroEncontrado = f;
                break;
            }
        }
        Analise analiseEncontrada = new Analise();
        
        for (Analise a : listaAnalise) {
            if (a.getId() == idFilme) {
                analiseEncontrada = a;
                break;
            }
        }
        System.out.println(analiseEncontrada);
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
        analise.setId(listaAnalise.size()+1);
        listaAnalise.add(analise);
        model.addAttribute("analiseModel", listaAnalise);
        return "redirect:/lista";
    }
   
    
}

