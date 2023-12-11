package com.atividade1.uc14.model;

public class Filme {


    private int id;
    private String titulo;
    private String sinopse;
    private String genero;
    private int anoLancamento;

    //metodo construtor vazio
    public Filme(){
        
    }
    
    //metodo construtor com atributos
    public Filme(int id, String titulo, String sinopse, String genero, int anoLancamento){
        this.id = id;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getTitulo() {return titulo;}
    public void setTitutlo(String titulo) {this.titulo = titulo;}
    public String getSinopse() { return sinopse;}
    public void setSinopse(String sinopse) {this.sinopse = sinopse;}
    public String getGenero() {return genero;}
    public void setGenero(String genero) {this.genero = genero;}
    public int getAnoLancamento() {return anoLancamento;}
    public void setAnoLancamento(int anoLancamento) {this.anoLancamento = anoLancamento;}
    
}
