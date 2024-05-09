/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.PII_1_2024.db;


import br.PII_1_2024.modelo.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author anton
 */
public class ProfessorDAO {
    public boolean existe(Professor u) throws Exception{
        //1. Especificar o comando sql
        String sql = "SELECT * FROM tb_professor "
                + "WHERE nome_professor = ? and senha = ?";
        //2. Estabelecer uma conexão com o banco
        try(Connection con = ConexaoBD.obterConexao();
        //3. preparar o comando
                PreparedStatement ps = con.prepareStatement(sql)){
        //4. Substituir os eventuais placeholders
            ps.setString(1, u.getNome());
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
    public Professor [] obterProfessor () throws Exception{
        String sql = "SELECT * FROM tb_professor";
        try (Connection con = ConexaoBD.obterConexao();
            PreparedStatement ps =
                con.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery()){

        int totalDeProfessores = rs.last () ? rs.getRow() : 0;
        Professor [] professores = new Professor[totalDeProfessores];
        rs.beforeFirst();
        int contador = 0;
        while (rs.next()){
            int codigo = rs.getInt("id_professor");
            String nomeProfessor = rs.getString("nome_professor");
            String senha = rs.getString("senha");
            professores[contador++] = new Professor (codigo, nomeProfessor, senha);
        }
        return professores;
    }
    }
    public void inserirProfessor (Professor professor) throws Exception{
        String sql = "INSERT INTO tb_professor (nome_professor, senha) "
                + "VALUES (?,?);";
        try (Connection con = ConexaoBD.obterConexao();
        PreparedStatement ps = con.prepareStatement(sql)){
        ps.setString(1, professor.getNome());
        ps.setString(2, professor.getSenha());
        ps.execute();
        }
    }
    public void atualizarProfessor (Professor professor) throws Exception{
        String sql = "UPDATE tb_professor "
                + "SET nome_professor = ?, senha = ? WHERE id_professor = ?";
        try (Connection con = ConexaoBD.obterConexao();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString (1, professor.getNome());
            ps.setString(2, professor.getSenha());
            ps.setInt (3, professor.getCodigo());
            ps.execute();
        }
    }
    public void removerProfessor (Professor professor) throws Exception{
        String sql = "DELETE FROM tb_professor WHERE id_professor = ?";
        try (Connection conexao = ConexaoBD.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql);){
            ps.setInt (1, professor.getCodigo());
            ps.execute();
        }
    }
}
