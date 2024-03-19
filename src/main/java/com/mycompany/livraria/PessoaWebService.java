package com.mycompany.livraria;

import com.mycompany.exception.AutorizacaoException;
import com.mycompany.exception.ValidacaoException;
import com.mycompany.livraria.interfaces.PessoaInterfaces;
import com.mycompany.livraria.model.Pessoa;
import com.mycompany.livraria.services.PessoaService;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;


@WebService(endpointInterface = "com.mycompany.livraria.interfaces.PessoaInterfaces")
public class PessoaWebService implements PessoaInterfaces{

    PessoaService ps = new PessoaService();
    
    @Override
    public ArrayList<Pessoa> listAll() throws SQLException, ValidacaoException, AutorizacaoException {

        return ps.listAll();
        
    }

    @Override
    public Pessoa findById(int id) throws SQLException, ValidacaoException, AutorizacaoException {

        return ps.findById(id);
        
    }

    @Override
    public Pessoa inserir(Pessoa pessoa) throws SQLException, ValidacaoException, AutorizacaoException {
 
        return ps.insert(pessoa);
    
    }

    @Override
    public Pessoa atualizar(Pessoa pessoa) throws SQLException, ValidacaoException, AutorizacaoException {

        return ps.atualizar(pessoa);

    }

    @Override
    public void deletar(int id) throws SQLException, ValidacaoException, AutorizacaoException {

        ps.deletar(id);
        
    }
    
}
