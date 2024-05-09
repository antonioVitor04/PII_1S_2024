/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.PII_1_2024.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.PII_1_2024.modelo.Turma;

public class TurmaDAO {
    public Turma [] obterTurma () throws Exception{
        String sql = "SELECT * FROM tb_turma";
        try (Connection con = ConexaoBD.obterConexao();
            PreparedStatement ps =
                con.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery()){

        int totalDeTurmas = rs.last () ? rs.getRow() : 0;
        Turma [] turmas = new Turma[totalDeTurmas];
        rs.beforeFirst();
        int contador = 0;
        while (rs.next()){
            String nome = rs.getString("turma");
            int codigo = rs.getInt("id_turma");
            turmas[contador++] = new Turma (codigo, nome);
        }
        return turmas;
    }
    }
    public void inserirTurma (Turma turma) throws Exception{
        String sql = "INSERT INTO tb_turma (turma) VALUES (?);";
        try (Connection con = ConexaoBD.obterConexao();
        PreparedStatement ps = con.prepareStatement(sql)){
        ps.setString(1, turma.getNome());
        ps.execute();
        }
    }
    public void atualizarTurma (Turma turma) throws Exception{
        String sql = "UPDATE tb_turma SET turma = ? WHERE id_turma = ?";
        try (Connection con = ConexaoBD.obterConexao();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, turma.getNome());
            ps.setInt (2, turma.getCodigoTurma());
            ps.execute();
        }
    }
    public void removerTurma (Turma turma) throws Exception{
        String sql = "DELETE FROM tb_turma WHERE id_turma = ?";
        try (Connection conexao = ConexaoBD.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql);){
            ps.setInt (1, turma.getCodigoTurma());
            ps.execute();
        }
    }

}
