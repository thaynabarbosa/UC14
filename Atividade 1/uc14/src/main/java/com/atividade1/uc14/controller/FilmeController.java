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
        return "cadastroFilmes";
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
        
        for(Analise a: listaAnalise){
            if(a.getFilmes().getId()==idFilme){
                analiseEncontrada =a;
                break;
            }
        }
        
        model.addAttribute("registroFilme", registroEncontrado);
        model.addAttribute("analiseFilme", analiseEncontrada);
        return "ExibirFilmes";
    }

    @PostMapping("/avaliacao")
    public String cadastrarAnalise(@ModelAttribute Filme filmes,@ModelAttribute Analise analise, Model model) {
        analise.setId(listaAnalise.size()+1);
        analise.setFilmes(filmes);
        listaAnalise.add(analise);
        //model.addAttribute("analiseFilme",analise);
        return "redirect:/lista";
    }
    
    @GetMapping("/analise")
    public String analiseFilmes(Model model){
      //model.addAttribute("analise", new Analise());
      model.addAttribute("analiseFilme",listaAnalise);
        return "Analise";
}    
    
 /*   
   @GetMapping("/analise")
    public String analiseFilmes(Model model, @RequestParam String id) {
        Integer idFilme = Integer.parseInt(id);
        Filme registroEncontrado = new Filme();
        for (Filme f : listafilmes) {
            if (f.getId() == idFilme) {
                registroEncontrado = f;
                break;
            }
        }
        //model.addAttribute("avaliacao",new Analise());
        model.addAttribute("avaliacao", registroEncontrado);
        return "Analise";
    }
   */
 /*
    @PostMapping("/avaliacao")
    public String cadastrarAnalise(@ModelAttribute Analise analises, Model model){
        
    }
     */
}
