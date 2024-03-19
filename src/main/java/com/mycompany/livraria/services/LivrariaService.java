package com.mycompany.livraria.services;

import com.mycompany.exception.AutorizacaoException;
import com.mycompany.exception.ValidacaoException;
import com.mycompany.livraria.model.Livro;
import com.mycompany.livraria.repository.LivroRepository;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class LivrariaService {

    public Livro insert(Livro livro) throws SQLException, ValidacaoException, AutorizacaoException {

        if (livro.getNome().length() <= 3) {

            throw new ValidacaoException("Nome do livro deve possui mais do que 3 caracteres");
        }

        if (livro.getNumeroPaginas() <= 0) {

            throw new ValidacaoException("Número de páginas do livro deve ser maior que zero");
        }

        if (livro.getAutor() == null) {

            throw new ValidacaoException("Informe o ID do Autor");
        }

        if (livro.getEditora() == null) {
            throw new ValidacaoException("Informe o ID do Editor");

        }
        try {

            LivroRepository livroRepository = new LivroRepository();

            return livroRepository.insert(livro);

        } catch (SQLException ex) {

            throw new ValidacaoException("ERRO INTERNO NO SERVIDOR!");

        }
    }

    public ArrayList<Livro> listAll() throws SQLException, ValidacaoException, AutorizacaoException {
        try {
            LivroRepository livroRepository = new LivroRepository();
            return livroRepository.listAll();
        } catch (SQLException ex) {
            throw new ValidacaoException("ERRO INTERNO NO SERVIDOR!");
        }
    }

    public Livro findById(int id) throws SQLException, ValidacaoException, AutorizacaoException {

        if (id <= 0) {
            throw new ValidacaoException("Informe o ID de busca");
        }

        try {
            LivroRepository livroRepository = new LivroRepository();

            return livroRepository.findById(id);
        } catch (SQLException ex) {
            throw new ValidacaoException("ERRO INTERNO NO SERVIDOR!");
        }

    }

    public ArrayList<Livro> findLivro(String nome) throws SQLException, ValidacaoException, AutorizacaoException {

        Livro livro = new Livro();

        if (livro.getNome().length() <= 3) {
            throw new ValidacaoException("Para buscar o nome do livro, necessário mínimo de 3 caracteres");
        }

        try {
            LivroRepository livroRepository = new LivroRepository();

            return livroRepository.findLivro(nome);
        } catch (SQLException ex) {
            throw new ValidacaoException("ERRO INTERNO SERVIDOR!");
        }
    }

    public Livro atualizar(Livro livro) throws SQLException, ValidacaoException, AutorizacaoException {

        if (livro.getNome().length() <= 3) {
            throw new ValidacaoException("Livro precisa ter mais de 3 caracteres");
        }

        if (livro.getNumeroPaginas() <= 0) {

            throw new ValidacaoException("Número de páginas do livro deve ser maior que zero");
        }

        if (livro.getAutor() == null) {
            throw new ValidacaoException("Informe o Autor");
        }

        if (livro.getEditora() == null) {
            throw new ValidacaoException("Informe o Editor");
        }

        if (livro.getAnoLancamento() == null) {
            throw new ValidacaoException("Informe a Data");
        }

        Instant now = Instant.now();
        Instant releaseDate = livro.getAnoLancamento().toInstant();

        if (releaseDate.isAfter(now)) {
            throw new ValidacaoException("Data não pode ser maior que a data atual");
        }
        try {
            LivroRepository livroRepository = new LivroRepository();
            livroRepository.update(livro);
            return livro;
        } catch (SQLException ex) {
            throw new ValidacaoException("ERRO INTERNO NO SERVIDOR!");
        }
    }

    public void deletar(int id) throws SQLException, ValidacaoException, AutorizacaoException {
        if (id <= 0) {
            throw new ValidacaoException("Informe o ID");
        }

        try {
            LivroRepository livroRepository = new LivroRepository();
            livroRepository.delete(id);
        }catch(SQLException ex){
            throw new ValidacaoException("ERRO INTERNO NO SERVIDOR");
        }

    }

}
