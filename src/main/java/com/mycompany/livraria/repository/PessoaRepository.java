package com.mycompany.livraria.repository;

import com.mycompany.exception.AutorizacaoException;
import com.mycompany.exception.ValidacaoException;
import com.mycompany.livraria.infrastructure.ConnectionFactory;
import com.mycompany.livraria.model.Livro;
import com.mycompany.livraria.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PessoaRepository {

    private String query;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    
    public ArrayList<Pessoa> listAll()throws SQLException, ValidacaoException, AutorizacaoException{

        ArrayList<Pessoa> pessoa = new ArrayList<>();
        query = "SELECT * FROM pessoa";
        
        try{
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                Pessoa p = new Pessoa();
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));
                
                pessoa.add(p);
            }
            
        }finally{
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return pessoa;
    }

    public Pessoa findById(int id)throws SQLException, ValidacaoException, AutorizacaoException {
        Pessoa p = new Pessoa();
        query = "SELECT * FROM pessoa WHERE id = ?";
        
        try{
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));
            }
        }finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return p;
            
    }

    public Pessoa insert(Pessoa pessoa)throws SQLException, ValidacaoException, AutorizacaoException {

        query = "INSERT INTO pessoa (nome) VALUES (?)";
        
        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, pessoa.getNome());
            
            pstmt.executeUpdate();
            
        } finally {
            
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
            
        }
        return pessoa;
    }

    public void update(Pessoa pessoa) throws SQLException, ValidacaoException, AutorizacaoException{

        query = "UPDATE pessoa SET nome = ? WHERE id = ?";
        
        try{
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, pessoa.getNome());
            pstmt.setInt(2, pessoa.getId());
            
            pstmt.executeUpdate();
        }finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public void delete(int id)throws SQLException {

        query = "DELETE FROM pessoa WHERE id = ?";
        
        try{
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }
    
}
