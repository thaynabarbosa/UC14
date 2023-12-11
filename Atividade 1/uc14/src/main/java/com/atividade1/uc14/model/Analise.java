package com.atividade1.uc14.model;

public class Analise {

    private int id;
    private String filme;
    private String analise;
    private int nota;

    public Analise() {

    }
    
    public Analise(int id, String filme, String analise, int nota){
        
    }
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getFilme() {return filme;}
    public void setFilme(String filme) {this.filme = filme;}
    public String getAnalise(){return analise;}
    public void setAnalise(String analise) {this.analise = analise;}
    public int getNota() {return nota;}
    public void setNota(int nota) {this.nota = nota;}
}
