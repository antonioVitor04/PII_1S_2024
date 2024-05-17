/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.PII_1_2024.db;

import br.PII_1_2024.modelo.AlunoFase;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author anton
 */
public class AlunoFaseDAO {
    public void inserirAlunoFase (AlunoFase alunoFase) throws Exception{
        String sql = "INSERT INTO tb_aluno_fase (fase, id_aluno, tempo_completado)"
                + " VALUES (?,?,?);";
        try (Connection con = ConexaoBD.obterConexao();
        PreparedStatement ps = con.prepareStatement(sql)){
        ps.setInt(1, alunoFase.getCodigoFase());
        ps.setInt(2, alunoFase.getCodigoAluno());
        ps.setInt(3,alunoFase.getTempoCompletado());
        ps.execute();
        }
    }
}
