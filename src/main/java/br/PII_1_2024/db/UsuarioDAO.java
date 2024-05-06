/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.PII_1_2024.db;

import br.PII_1_2024.modelo.Turma;
import br.PII_1_2024.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author anton
 */
public class UsuarioDAO {
    public boolean existe(Usuario u) throws Exception{
        //1. Especificar o comando sql
        String sql = "SELECT * FROM tb_usuario_t2 WHERE login = ? AND senha = ?";
        //2. Estabelecer uma conexão com o banco
        Connection conexao = new ConnectionFactory().obterConexao();
        //3. preparar o comando
        PreparedStatement ps = conexao.prepareStatement(sql);
        //4. Substituir os eventuais placeholders
        ps.setString(1, u.getLogin());
        ps.setString(2, u.getSenha());
        //5. Executar
        ResultSet rs= ps.executeQuery();
        //6. Lidar com resultado
        boolean achou = rs.next();
        //7. Fechar a conexão
        rs.close();
        ps.close();
        conexao.close();
        //8. responder se existe ou não
        return achou;
    }
    public Turma [] obterTurma () throws Exception{
        String sql = "SELECT * FROM tb_turma";
        try (Connection conexao = new ConnectionFactory().obterConexao();
            PreparedStatement ps =
                conexao.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery()){

        int totalDeTurmas = rs.last () ? rs.getRow() : 0;
        Turma [] turmas = new Turma[totalDeTurmas];
        rs.beforeFirst();
        int contador = 0;
        while (rs.next()){
            int codigo = rs.getInt("idturma");
            String descricao = rs.getString("turma");
            turmas[contador++] = new Turma (codigo, descricao);
        }
        return turmas;
    }
 }

}



