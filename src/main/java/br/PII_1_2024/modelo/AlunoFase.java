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
public class AlunoFase {
    int codigoFase;
    int codigoAluno;
    int tempoCompletado;
    
    public AlunoFase(int codigoFase, int codigoAluno, int tempoCompletado){
        this.codigoFase = codigoFase;
        this.codigoAluno = codigoAluno;
        this.tempoCompletado = tempoCompletado;
    }

    public int getCodigoFase() {
        return codigoFase;
    }

    public void setCodigoFase(int codigoFase) {
        this.codigoFase = codigoFase;
    }

    public int getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(int codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public int getTempoCompletado() {
        return tempoCompletado;
    }

    public void setTempoCompletado(int tempoCompletado) {
        this.tempoCompletado = tempoCompletado;
    }
}
