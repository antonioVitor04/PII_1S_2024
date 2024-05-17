/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.PII_1_2024.db;

import br.PII_1_2024.modelo.Fase;
import br.PII_1_2024.modelo.Ranking;
import br.PII_1_2024.modelo.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anton
 */
public class RankingDAO {
    public List <Ranking> BuscarRankingPorTurma(Turma turma, Fase fase) throws Exception{
        String sql = "SELECT tb_aluno.nome_aluno "
                + "AS aluno, tb_turma.turma "
                + "AS nome_turma, tb_fase.nome_fase , MIN"
                + "(SEC_TO_TIME(tb_aluno_fase.tempo_completado)) AS tempo "
                + "FROM tb_aluno_fase "
                + "INNER JOIN tb_aluno "
                + "ON tb_aluno_fase.id_aluno = tb_aluno.id_aluno "
                + "INNER JOIN tb_turma "
                + "ON tb_aluno.turma = tb_turma.id_turma "
                + "INNER JOIN tb_fase "
                + "ON tb_aluno_fase.fase = tb_fase.id_fase "
                + "WHERE tb_turma.id_turma = ? AND tb_fase.id_fase = ? "
                + "GROUP BY tb_aluno.id_aluno, tb_fase.id_fase "
                + "ORDER BY tempo ASC";
        List <Ranking> rank = new ArrayList <> ();
        try (Connection conexao = ConexaoBD.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)){
        ps.setInt (1, turma.getCodigoTurma());
        ps.setInt(2, fase.getCodigoFase());
        try (ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                String nomeAluno = rs.getString("aluno");
                String nomeFase = rs.getString ("nome_fase");
                String nomeTurma = rs.getString("nome_turma");
                Time tempoFase = rs.getTime ("tempo");                
                rank.add(new Ranking (nomeAluno, nomeTurma, nomeFase, tempoFase));
            }
        }
    }
    return rank;
    }
    
   
}
