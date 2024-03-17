package com.mycompany.livraria.repository;

import com.mycompany.livraria.infrastructure.ConnectionFactory;
import com.mycompany.livraria.model.Livro;
import com.mycompany.livraria.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LivroRepository {

    private String query;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public Livro insert(Livro livro) throws SQLException {
        query = "INSERT INTO livro (nome, dt_lancto, nr_paginas, editora_id, autor_id) VALUES (?,?,?,?,?)";

        try {
            conn = new ConnectionFactory().getConnection();

            pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, livro.getNome());
            pstmt.setDate(2, new java.sql.Date(livro.getAnoLancamento().getTime()));
            pstmt.setInt(3, livro.getNumeroPaginas());
            pstmt.setInt(4, livro.getEditora().getId());
            pstmt.setInt(5, livro.getAutor().getId());

            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();

            rs.next();
            livro.setId(rs.getInt(1));
            //conn.commit();
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
        return livro;
    }

    public ArrayList<Livro> listAll() throws SQLException {
        ArrayList<Livro> livros = new ArrayList<>();
        query = "SELECT l.id, l.nome, l.dt_lancto, l.nr_paginas, e.nome as editora_nome, a.nome as autor_nome "
                + "FROM livro l "
                + "JOIN pessoa e ON l.editora_id = e.id "
                + "JOIN pessoa a ON l.autor_id = a.id";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setNome(rs.getString("nome"));
                livro.setAnoLancamento(rs.getDate("dt_lancto"));
                livro.setNumeroPaginas(rs.getInt("nr_paginas"));

                Pessoa editora = new Pessoa();
                editora.setNome(rs.getString("editora_nome"));
                livro.setEditora(editora);

                Pessoa autor = new Pessoa();
                autor.setNome(rs.getString("autor_nome"));
                livro.setAutor(autor);

                livros.add(livro);
            }
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
        return livros;
    }

    public ArrayList<Livro> findLivro(String nome) throws SQLException {
        ArrayList<Livro> livros = new ArrayList<>();
        query = "SELECT l.id, l.nome, l.dt_lancto, l.nr_paginas, e.nome as editora_nome, a.nome as autor_nome "
                + "FROM livro l "
                + "JOIN pessoa e ON l.editora_id = e.id "
                + "JOIN pessoa a ON l.autor_id = a.id "
                + "WHERE l.nome LIKE ?";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + nome + "%");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setNome(rs.getString("nome"));
                livro.setAnoLancamento(rs.getDate("dt_lancto"));
                livro.setNumeroPaginas(rs.getInt("nr_paginas"));

                Pessoa editora = new Pessoa();
                editora.setNome(rs.getString("editora_nome"));
                livro.setEditora(editora);

                Pessoa autor = new Pessoa();
                autor.setNome(rs.getString("autor_nome"));
                livro.setAutor(autor);

                livros.add(livro);
            }
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
        return livros;
    }

    public Livro findById(int id) throws SQLException {
        Livro livro = null;
        query = "SELECT l.id, l.nome, l.dt_lancto, l.nr_paginas, e.nome as editora_nome, a.nome as autor_nome "
                + "FROM livro l "
                + "JOIN pessoa e ON l.editora_id = e.id "
                + "JOIN pessoa a ON l.autor_id = a.id "
                + "WHERE l.id = ?";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setNome(rs.getString("nome"));
                livro.setAnoLancamento(rs.getDate("dt_lancto"));
                livro.setNumeroPaginas(rs.getInt("nr_paginas"));

                Pessoa editora = new Pessoa();
                editora.setNome(rs.getString("editora_nome"));
                livro.setEditora(editora);

                Pessoa autor = new Pessoa();
                autor.setNome(rs.getString("autor_nome"));
                livro.setAutor(autor);
            }
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
        return livro;
    }

    public void update(Livro livro) throws SQLException {
        query = "UPDATE livro SET nome = ?, dt_lancto = ?, nr_paginas = ?, editora_id = ?, autor_id = ? WHERE id = ?";

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, livro.getNome());
            pstmt.setDate(2, new java.sql.Date(livro.getAnoLancamento().getTime()));
            pstmt.setInt(3, livro.getNumeroPaginas());
            pstmt.setInt(4, livro.getEditora().getId());
            pstmt.setInt(5, livro.getAutor().getId());
            pstmt.setInt(6, livro.getId());

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

    public void delete(int id) throws SQLException {
        query = "DELETE FROM livro WHERE id = ?";

        try {
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
