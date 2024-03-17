package com.mycompany.livraria.interfaces;

import com.mycompany.livraria.model.Livro;
import com.mycompany.livraria.model.Pessoa;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;

@WebService
public interface LivrariaInterfaces {
    
    @WebMethod
    ArrayList<Livro> findLivro(String nome)throws SQLException; 
    
    @WebMethod
    ArrayList<Livro> listAll()throws SQLException;
    
    @WebMethod
    Livro findById(int id)throws SQLException;
   
    @WebMethod
    Livro inserir(Livro livro) throws SQLException;
    
    @WebMethod
    Livro atualizar(Livro livro)throws SQLException;
    
    @WebMethod
    void deletar(int id)throws SQLException;
    
    
}
