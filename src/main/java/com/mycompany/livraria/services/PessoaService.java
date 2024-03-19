/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.livraria.services;

import com.mycompany.exception.AutorizacaoException;
import com.mycompany.exception.ValidacaoException;
import com.mycompany.livraria.model.Livro;
import com.mycompany.livraria.model.Pessoa;
import com.mycompany.livraria.repository.PessoaRepository;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author leona
 */
public class PessoaService {

    PessoaRepository pr = new PessoaRepository();
    
    public ArrayList<Pessoa> listAll() throws SQLException, ValidacaoException, AutorizacaoException{

        return pr.listAll();

    }

    public Pessoa findById(int id) throws SQLException, ValidacaoException, AutorizacaoException{

        return pr.findById(id);

    }

    public Pessoa insert(Pessoa pessoa) throws SQLException, ValidacaoException, AutorizacaoException{

        return pr.insert(pessoa);

    }

    public Pessoa atualizar(Pessoa pessoa) throws SQLException, ValidacaoException, AutorizacaoException{

        pr.update(pessoa);
        return pessoa;

    }

    public void deletar(int id) throws SQLException, ValidacaoException, AutorizacaoException{

        pr.delete(id);

    }
    
}
