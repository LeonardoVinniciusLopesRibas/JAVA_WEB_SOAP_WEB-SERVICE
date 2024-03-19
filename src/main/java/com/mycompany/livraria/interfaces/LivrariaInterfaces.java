package com.mycompany.livraria.interfaces;

import com.mycompany.exception.AutorizacaoException;
import com.mycompany.exception.ValidacaoException;
import com.mycompany.livraria.model.Livro;
import com.mycompany.livraria.model.Pessoa;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;

@WebService
public interface LivrariaInterfaces {
    
    @WebMethod
    ArrayList<Livro> findLivro(String nome)throws SQLException, ValidacaoException, AutorizacaoException; 
    
    @WebMethod
    ArrayList<Livro> listAll()throws SQLException, ValidacaoException, AutorizacaoException;
    
    @WebMethod
    Livro findById(int id)throws SQLException, ValidacaoException, AutorizacaoException;
   
    @WebMethod
    Livro inserir(Livro livro) throws SQLException, ValidacaoException, AutorizacaoException;
    
    @WebMethod
    Livro atualizar(Livro livro)throws SQLException, ValidacaoException, AutorizacaoException;
    
    @WebMethod
    void deletar(int id)throws SQLException, ValidacaoException, AutorizacaoException;
    
    
}
