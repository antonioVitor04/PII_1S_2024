/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.PII_1_2024.db;

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
        String sql = "SELECT * FROM tb_usuario WHERE login = ? AND senha = ?";
        //2. Estabelecer uma conexão com o banco
        try(Connection con = ConexaoBD.obterConexao();
        //3. preparar o comando
                PreparedStatement ps = con.prepareStatement(sql)){
        //4. Substituir os eventuais placeholders
            ps.setString(1, u.getLogin());
            ps.setString(2, u.getSenha());
        //5. Executar
        try(ResultSet rs= ps.executeQuery()){
        //6. Lidar com resultado
            boolean achou = rs.next();
        //7. Fechar a conexão
            rs.close();
            ps.close();
            con.close();
        //8. responder se existe ou não
            return achou;
        }
        }
    }

}



