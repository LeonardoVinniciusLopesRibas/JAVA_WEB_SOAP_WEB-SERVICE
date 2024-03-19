package com.mycompany.livraria;

import com.mycompany.exception.AutorizacaoException;
import com.mycompany.exception.ValidacaoException;
import com.mycompany.livraria.interfaces.LivrariaInterfaces;
import com.mycompany.livraria.model.Livro;
import com.mycompany.livraria.repository.LivroRepository;
import jakarta.jws.WebService;
import java.util.ArrayList;
import com.mycompany.livraria.services.LivrariaService;
import java.sql.SQLException;

@WebService(endpointInterface = "com.mycompany.livraria.interfaces.LivrariaInterfaces")
public class LivrariaWebService implements LivrariaInterfaces {

    @Override
    public Livro inserir(Livro livro) throws SQLException, ValidacaoException, AutorizacaoException {
        LivroRepository livroRepository = new LivroRepository();

        return livroRepository.insert(livro);
    }

    @Override
    public ArrayList<Livro> listAll() throws SQLException, ValidacaoException, AutorizacaoException {
        LivrariaService livrariaService = new LivrariaService();
        return livrariaService.listAll();
    }

    @Override
    public ArrayList<Livro> findLivro(String nome) throws SQLException, ValidacaoException, AutorizacaoException {
        LivrariaService livrariaService = new LivrariaService();
        return livrariaService.findLivro(nome);
    }

    @Override
    public Livro findById(int id) throws SQLException, ValidacaoException, AutorizacaoException {
        LivrariaService livrariaService = new LivrariaService();
        return livrariaService.findById(id);
    }

    @Override
    public Livro atualizar(Livro livro) throws SQLException, ValidacaoException, AutorizacaoException {
        LivrariaService livrariaService = new LivrariaService();
        return livrariaService.atualizar(livro);
    }

    @Override
    public void deletar(int id) throws SQLException, ValidacaoException, AutorizacaoException {
        LivrariaService livrariaService = new LivrariaService();
        livrariaService.deletar(id);
    }


}
