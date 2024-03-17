package com.mycompany.livraria.interfaces;

import com.mycompany.livraria.model.Livro;
import com.mycompany.livraria.model.Pessoa;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;

@WebService
public interface PessoaInterfaces {
    
    @WebMethod
    ArrayList<Pessoa> listAll()throws SQLException;
    
    @WebMethod
    Pessoa findById(int id)throws SQLException;
    
    @WebMethod
    Pessoa inserir(Pessoa pessoa) throws SQLException;
    
    @WebMethod
    Pessoa atualizar(Pessoa pessoa) throws SQLException;
    
    @WebMethod
    void deletar(int id) throws SQLException;
    
}
