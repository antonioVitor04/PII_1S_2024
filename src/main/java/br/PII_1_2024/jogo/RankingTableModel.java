/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.PII_1_2024.jogo;

import br.PII_1_2024.bd.RankingDAO;
import br.PII_1_2024.modelo.Fase;
import br.PII_1_2024.modelo.Ranking;
import br.PII_1_2024.modelo.Turma;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author anton
 */
public class RankingTableModel extends AbstractTableModel{
    private List <Ranking> rank;
    private String [] colunas = {"ALUNOS", "TURMA", "FASE", "TEMPO"};
    
    public RankingTableModel (Turma turma, Fase fase) throws Exception{
        RankingDAO dao = new RankingDAO();
        this.rank = dao.BuscarRankingPorTurma(turma, fase);
    }
    @Override
    public int getRowCount() {
        return rank.size();
    }
    @Override
    public int getColumnCount() {
        return 4;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex){
        case 0:
            return this.rank.get(rowIndex).getNomeAluno();
        case 1:
            return this.rank.get(rowIndex).getNomeTurma();
        case 2:
            return this.rank.get(rowIndex).getNomeFase();
        case 3:
            return this.rank.get(rowIndex).getTempoCompletado();
        default:
            return null;
        }
    }

    
    @Override
    public String getColumnName(int column) {
        return this.colunas[column];
    }

}
