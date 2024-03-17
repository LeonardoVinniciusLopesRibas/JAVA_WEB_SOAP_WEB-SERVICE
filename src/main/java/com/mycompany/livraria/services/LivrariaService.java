package com.mycompany.livraria.services;

import com.mycompany.livraria.model.Livro;
import com.mycompany.livraria.repository.LivroRepository;
import java.sql.SQLException;
import java.util.ArrayList;

public class LivrariaService {

    public Livro insert(Livro livro) throws SQLException {
        LivroRepository livroRepository = new LivroRepository();
        return livroRepository.insert(livro);
    }

    public ArrayList<Livro> listAll() throws SQLException {
        LivroRepository livroRepository = new LivroRepository();
        return livroRepository.listAll();
    }

    public Livro findById(int id) throws SQLException {
        LivroRepository livroRepository = new LivroRepository();

        return livroRepository.findById(id);
    }

    public ArrayList<Livro> findLivro(String nome) throws SQLException {
        LivroRepository livroRepository = new LivroRepository();

        return livroRepository.findLivro(nome);
    }

    public Livro atualizar(Livro livro) throws SQLException {
        LivroRepository livroRepository = new LivroRepository();
        livroRepository.update(livro);
        return livro;
    }

    public void deletar(int id) throws SQLException {
        LivroRepository livroRepository = new LivroRepository();
        livroRepository.delete(id);
    }

}
