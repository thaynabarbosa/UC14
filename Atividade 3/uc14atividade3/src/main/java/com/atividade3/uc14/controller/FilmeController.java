package com.atividade3.uc14.controller;
import com.atividade3.uc14.model.Analise;
import com.atividade3.uc14.model.Filme;
import com.atividade3.uc14.service.AnaliseService;
//import com.atividade3.uc14.service.AnaliseService;
import com.atividade3.uc14.service.FilmeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FilmeController {

    @Autowired
    FilmeService filmeservice;
    
    @Autowired
    AnaliseService analiseservice;

    //página inicial, para cadastrar o filme
    @GetMapping("/index")
    public String inicio(Model model) {
        model.addAttribute("filme", new Filme());
        return "CadastrarFilme";
    }
    
    //Casdastra o filme no banco de dados, na tabela Filme
    @PostMapping("/cadastro")
    public String cadastroFilmes(@ModelAttribute Filme filmes, Model model) {

        if (filmes.getId() != null) {
            filmeservice.atualizar(filmes.getId(), filmes);
            model.addAttribute("filme", filmes);
        } else {
            filmeservice.criar(filmes);
            model.addAttribute("filme", filmes);
        }

        return "redirect:/lista";
    }
    
    //Lista todos os filmes em uma tabela
    @GetMapping("/lista")
    public String listaFilmes(Model model) {
        model.addAttribute("lista", filmeservice.listarTodos());
        return "listaFilmes";
    }
    
    //Alterar os dados dos filmes
    @GetMapping("/alterar")
    public String alterarFilme(Model model, @RequestParam String id) {
        Integer idFilme = Integer.parseInt(id);
        Filme filmeencontrado = filmeservice.buscarPorId(idFilme);
        model.addAttribute("filme", filmeencontrado);
        return "alterar";
    }
    
    //Exclui o filme do banco de dados
    @GetMapping("/excluir")
    public String deletaFilme(Model model, @RequestParam String id) {
        Integer idFilme = Integer.parseInt(id);
        analiseservice.excluirTodasAnalises(idFilme);
        filmeservice.excluir(idFilme);
        return "redirect:/lista";
    }
    
    @GetMapping("/formularioAnalises")
    public String cadastroAnalise(Model model,@RequestParam String id) {
        Integer idFilme = Integer.parseInt(id);
        Filme filmeencontrado = filmeservice.buscarPorId(idFilme);
        model.addAttribute("filme", filmeencontrado);
        model.addAttribute("analiseModel", new Analise());
        return "CadastroAnalise";
    }
    
    //Grava a analise sobre o filme no banco de dados
    @PostMapping("/gravar-avaliacao")
    public String gravarAnalise(@ModelAttribute Filme filme, @ModelAttribute Analise analise, Model model) {
       /*
        if (analise.getId() != null) {
            analiseservice.atualizar(analise.getId(), analise);
            model.addAttribute("analiseModel", analise);
        } else {
            analise.setFilmes(filme);
            analise.setFilme(filme.getTitulo());
            analiseservice.criar(analise);
            model.addAttribute("analiseModel", analise);
        }
        */
            analise.setFilmes(filme);
            analise.setFilme(filme.getTitulo());
            analiseservice.criar(analise);
            model.addAttribute("analiseModel", analise);
            
        return "redirect:/lista";
    }
  
    
    @GetMapping("/exibir")
    public String mostrarDetalhesFilme(Model model, @RequestParam String id) {
        Integer idFilme = Integer.parseInt(id);

        Filme registroEncontrado = new Filme();
        registroEncontrado = filmeservice.buscarPorId(idFilme);

        List<Analise> analiseEncontrada = new ArrayList<>();
        analiseEncontrada = analiseservice.listarTodos(idFilme);

        model.addAttribute("registroFilme", registroEncontrado);
        model.addAttribute("analise",new Analise());
        model.addAttribute("analiseFilme", analiseEncontrada);
        return "ExibirFilmeAnalise";
    }
    
    //Exclui a analise do banco de dados
    @GetMapping("/excluirAnalise")
    public String excluiAnalise(Model model, @RequestParam String id) {
        Integer idAnalise = Integer.parseInt(id);
        analiseservice.excluirAnalise(idAnalise);
        return "redirect:/lista";
    }
    
    //Alterar os dados da Analise
    @GetMapping("/alterarAnalise")
    public String alterarAnalise(Model model, @RequestParam String id, @ModelAttribute Filme filme, @ModelAttribute Analise analise) {
        analise.setFilmes(filme);
        Integer idAnalise = Integer.parseInt(id);
        Analise Analiseencontrado = analiseservice.buscarPorId(idAnalise);
        model.addAttribute("analiseModel", Analiseencontrado);
        
        return "alterarAnalise";
    }
    
    
    @PostMapping("/alterar-avaliacao")
    public String alterarAnalise(@ModelAttribute Filme filme, @ModelAttribute Analise analise, Model model) {
        analiseservice.atualizar(analise.getId(), analise);
        model.addAttribute("analiseModel", analise);
        return "redirect:/lista";
    }
    
}
