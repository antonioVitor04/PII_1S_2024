/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.PII_1_2024.bd;

import br.PII_1_2024.modelo.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author anton
 */
public class AlunoDAO {
    public boolean existe(Aluno u) throws Exception{
        //1. Especificar o comando sql
        String sql = "SELECT * FROM tb_aluno WHERE nome_aluno = ?";
        //2. Estabelecer uma conexão com o banco
        try(Connection con = ConexaoBD.obterConexao();
        //3. preparar o comando
                PreparedStatement ps = con.prepareStatement(sql)){
        //4. Substituir os eventuais placeholders
            ps.setString(1, u.getNome());
        //5. Executar
        try(ResultSet rs= ps.executeQuery()){
        //6. Lidar com resultado
            boolean alunoOK = rs.next();
        //7. Fechar a conexão
            rs.close();
            ps.close();
            con.close();
        //8. responder se existe ou não
            return alunoOK;
        }
        }
    }
    public int obterCodigo(Aluno u) throws Exception{
        int codigo = 0;
        //1. Especificar o comando sql
        String sql = "SELECT id_aluno FROM tb_aluno WHERE nome_aluno = ?";
        //2. Estabelecer uma conexão com o banco
        try(Connection con = ConexaoBD.obterConexao();
        //3. preparar o comando
                PreparedStatement ps = con.prepareStatement(sql)){
        //4. Substituir os eventuais placeholders
            ps.setString(1, u.getNome());
        //5. Executar
        try(ResultSet rs= ps.executeQuery()){
        //6. Lidar com resultado
        if (rs.next()) {
            codigo = rs.getInt("id_aluno");
        }
        //7. Fechar a conexão
        rs.close();
        ps.close();
        con.close();
        //8. responder se existe ou não

        }
        }
        return codigo;
    }
    public Aluno [] obterAluno () throws Exception{
        String sql = "SELECT * FROM tb_aluno";
        try (Connection con = ConexaoBD.obterConexao();
            PreparedStatement ps =
                con.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery()){

        int totalDeAlunos = rs.last () ? rs.getRow() : 0;
        Aluno [] alunos = new Aluno[totalDeAlunos];
        rs.beforeFirst();
        int contador = 0;
        while (rs.next()){
            int codigo = rs.getInt("id_aluno");
            int codigoTurma = rs.getInt("turma");
            String nome = rs.getString("nome_aluno");
            alunos[contador++] = new Aluno (codigo, nome, codigoTurma);
        }
        return alunos;
    }
    }
    public void inserirAluno (Aluno aluno) throws Exception{
        String sql = "INSERT INTO tb_aluno (nome_aluno, turma) VALUES (?,?);";
        try (Connection con = ConexaoBD.obterConexao();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, aluno.getNome());
            ps.setInt(2, aluno.getCodigoTurma());
            ps.execute();
        }
    }
    public void atualizarAluno (Aluno aluno) throws Exception{
        String sql = "UPDATE tb_aluno "
                + "SET nome_aluno = ?, turma = ? WHERE id_aluno = ?";
        try (Connection con = ConexaoBD.obterConexao();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString (1, aluno.getNome());
            ps.setInt(2, aluno.getCodigoTurma());
            ps.setInt (3, aluno.getCodigoAluno());
            ps.execute();
        }
    }
    public void removerAluno (Aluno aluno) throws Exception{
        String sql = "DELETE FROM tb_aluno WHERE id_aluno = ?";
        try (Connection conexao = ConexaoBD.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql);){
            ps.setInt (1, aluno.getCodigoAluno());
            ps.execute();
        }
    }

}



