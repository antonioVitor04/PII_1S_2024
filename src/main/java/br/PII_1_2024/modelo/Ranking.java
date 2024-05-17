/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.PII_1_2024.modelo;

import java.sql.Time;

/**
 *
 * @author anton
 */
public class Ranking {
    private String nomeAluno;
    private String nomeTurma;
    private String nomeFase;
    private Time tempoFase;
    
    public Ranking(String nomeAluno, 
            String nomeTurma, 
            String nomeFase, 
            Time tempoFase){
        
        this.nomeAluno = nomeAluno;
        this.nomeFase = nomeFase;
        this.nomeTurma = nomeTurma;
        this.tempoFase = tempoFase;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public String getNomeFase() {
        return nomeFase;
    }

    public void setNomeFase(String nomeFase) {
        this.nomeFase = nomeFase;
    }

    public Time getTempoFase() {
        return tempoFase;
    }

    public void setTempoFase(Time tempoFase) {
        this.tempoFase = tempoFase;
    }
}
