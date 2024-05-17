/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.PII_1_2024.db;

import br.PII_1_2024.modelo.Fase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author anton
 */
public class FaseDAO {
    public Fase [] obterFase () throws Exception{
        String sql = "SELECT * FROM tb_fase";
        try (Connection con = ConexaoBD.obterConexao();
            PreparedStatement ps =
                con.prepareStatement(sql,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery()){

        int totalDeFases = rs.last () ? rs.getRow() : 0;
        Fase [] fases = new Fase[totalDeFases];
        rs.beforeFirst();
        int contador = 0;
        while (rs.next()){
            String nome = rs.getString("nome_fase");
            int codigo = rs.getInt("id_fase");
            fases[contador++] = new Fase (codigo, nome);
        }
        return fases;
    }
    }
}
