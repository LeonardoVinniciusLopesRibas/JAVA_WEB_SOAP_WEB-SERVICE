package com.mycompany.livraria.model;

import java.util.Date;




public class Livro {
    
    private int id;
    private String nome;
    private Date anoLancamento;
    private int numeroPaginas;
    private Pessoa editora;
    private Pessoa autor;

    public Livro() {
    }

    public Livro(int id, String nome, Date anoLancamento, int numeroPaginas, Pessoa editora, Pessoa autor) {
        this.id = id;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.numeroPaginas = numeroPaginas;
        this.editora = editora;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Date anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Pessoa getEditora() {
        return editora;
    }

    public void setEditora(Pessoa editora) {
        this.editora = editora;
    }

    public Pessoa getAutor() {
        return autor;
    }

    public void setAutor(Pessoa autor) {
        this.autor = autor;
    }
    
    
    
    
}
