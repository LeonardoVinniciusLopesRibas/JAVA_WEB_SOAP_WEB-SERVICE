package com.mycompany.livraria;

import com.mycompany.livraria.interfaces.PessoaInterfaces;
import com.mycompany.livraria.model.Livro;
import com.mycompany.livraria.model.Pessoa;
import com.mycompany.livraria.services.PessoaService;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;


@WebService(endpointInterface = "com.mycompany.livraria.interfaces.PessoaInterfaces")
public class PessoaWebService implements PessoaInterfaces{

    PessoaService ps = new PessoaService();
    
    @Override
    public ArrayList<Pessoa> listAll() throws SQLException {

        return ps.listAll();
        
    }

    @Override
    public Pessoa findById(int id) throws SQLException {

        return ps.findById(id);
        
    }

    @Override
    public Pessoa inserir(Pessoa pessoa) throws SQLException {
 
        return ps.insert(pessoa);
    
    }

    @Override
    public Pessoa atualizar(Pessoa pessoa) throws SQLException {

        return ps.atualizar(pessoa);

    }

    @Override
    public void deletar(int id) throws SQLException {

        ps.deletar(id);
        
    }
    
}
