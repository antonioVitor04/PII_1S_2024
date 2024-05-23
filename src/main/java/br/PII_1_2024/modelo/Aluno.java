/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.PII_1_2024.modelo;

/**
 *
 * @author anton
 */
public class Aluno{

    int codigoAluno;
    String nome;
    int codigoTurma;
    String turma;
    
    public Aluno(int codigoAluno, String nome, int codigoTurma) {
        this.codigoAluno = codigoAluno;
        this.nome = nome;
        this.codigoTurma = codigoTurma;
    }
    
    public Aluno(String nome, int codigoTurma) {
        this.nome = nome;
        this.codigoTurma = codigoTurma;
    }

    public Aluno(int codigoAluno) {
        this.codigoAluno = codigoAluno;
    }
    public Aluno(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }
    
    public int getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(int codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public int getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigo(int codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}
