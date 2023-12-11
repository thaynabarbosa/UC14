package com.atividade1.uc14.model;

public class Analise {

    private int id;
    private String filme;
    private String analise;
    private int nota;
    private Filme filmes;

    public Analise() {

    }
    
    public Analise(int id, String filme, String analise, int nota, Filme filmes){
        
    }
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getFilme() {return filme;}
    public void setFilme(String filme) {this.filme = filme;}
    public String getAnalise(){return analise;}
    public void setAnalise(String analise) {this.analise = analise;}
    public int getNota() {return nota;}
    public void setNota(int nota) {this.nota = nota;}
    public Filme getFilmes() {return filmes;}
    public void setFilmes(Filme filmes) {this.filmes = filmes;}
}
