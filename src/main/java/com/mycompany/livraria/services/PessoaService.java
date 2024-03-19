/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.livraria.services;

import com.mycompany.exception.AutorizacaoException;
import com.mycompany.exception.ValidacaoException;
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

    public ArrayList<Pessoa> listAll() throws SQLException, ValidacaoException, AutorizacaoException {

        try {
            return pr.listAll();
        } catch (SQLException ex) {
            throw new ValidacaoException("ERRO INTERNO NO SERVIDOR!");
        }

    }

    public Pessoa findById(int id) throws SQLException, ValidacaoException, AutorizacaoException {

        if (id <= 0) {
            throw new ValidacaoException("Informe o ID de busca");
        }

        try {
            return pr.findById(id);
        } catch (SQLException ex) {
            throw new ValidacaoException("ERRO INTERNO NO SERVIDOR!");
        }
    }

    public Pessoa insert(Pessoa pessoa) throws SQLException, ValidacaoException, AutorizacaoException {

        if (pessoa.getNome().length() <= 3) {
            throw new ValidacaoException("Informe o nome - Mínimo 3 caracteres!");
        }
        try {
            return pr.insert(pessoa);
        } catch (SQLException ex) {
            throw new ValidacaoException("ERRO INTERNO NO SERVIDOR!");
        }
    }

    public Pessoa atualizar(Pessoa pessoa) throws SQLException, ValidacaoException, AutorizacaoException {

        if (pessoa.getNome().length() <= 3) {
            throw new ValidacaoException("Informe o nome - Mínimo 3 caracteres!");
        }
        try {
            pr.update(pessoa);
            return pessoa;
        } catch (SQLException ex) {
            throw new ValidacaoException("ERRO INTERNO NO SERVIDOR!");
        }
    }

    public void deletar(int id) throws SQLException, ValidacaoException, AutorizacaoException {

        if(id <= 0){
            throw new ValidacaoException("Informe o ID para deletar");
        }
        try{
        pr.delete(id);
        }catch(SQLException ex){
            throw new ValidacaoException("ERRO INTERNO NO SERVIDOR!");
        }
    }

}
