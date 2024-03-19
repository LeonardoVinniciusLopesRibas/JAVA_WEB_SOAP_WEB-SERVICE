package com.mycompany.livraria.services;

import com.mycompany.exception.AutorizacaoException;
import com.mycompany.exception.ValidacaoException;
import com.mycompany.livraria.model.Livro;
import com.mycompany.livraria.repository.LivroRepository;
import java.sql.SQLException;
import java.util.ArrayList;

public class LivrariaService {

    public Livro insert(Livro livro) throws SQLException, ValidacaoException, AutorizacaoException {
        
        if(livro.getNome().length()<=3){
            
            throw new ValidacaoException("Nome do livro deve possui mais do que 3 caracteres");
        }
        
        if(livro.getNumeroPaginas() <= 0 ){
            
            throw new ValidacaoException("Número de páginas do livro deve ser maior que zero");
        }
        
        try{
        
        LivroRepository livroRepository = new LivroRepository();
        
        return livroRepository.insert(livro);
        
        }catch(SQLException ex){
            
            throw new ValidacaoException("ERRO INTERNO NO SERVIDOR!");
            
        }
    }

    public ArrayList<Livro> listAll() throws SQLException, ValidacaoException, AutorizacaoException {
        LivroRepository livroRepository = new LivroRepository();
        return livroRepository.listAll();
    }

    public Livro findById(int id) throws SQLException, ValidacaoException, AutorizacaoException {
        LivroRepository livroRepository = new LivroRepository();

        return livroRepository.findById(id);
    }

    public ArrayList<Livro> findLivro(String nome) throws SQLException, ValidacaoException, AutorizacaoException {
        LivroRepository livroRepository = new LivroRepository();

        return livroRepository.findLivro(nome);
    }

    public Livro atualizar(Livro livro) throws SQLException,  ValidacaoException, AutorizacaoException {
        LivroRepository livroRepository = new LivroRepository();
        livroRepository.update(livro);
        return livro;
    }

    public void deletar(int id) throws SQLException, ValidacaoException, AutorizacaoException {
        LivroRepository livroRepository = new LivroRepository();
        livroRepository.delete(id);
    }

}
