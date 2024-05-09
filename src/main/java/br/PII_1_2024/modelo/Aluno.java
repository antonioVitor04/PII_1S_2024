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

    int codigo;
    String nome;
    int codigoTurma;
    String turma;
    
    public Aluno(int codigo, String nome, int codigoTurma) {
        this.codigo = codigo;
        this.nome = nome;
        this.codigoTurma = codigoTurma;
    }
    
    public Aluno(String nome, int codigoTurma) {
        this.nome = nome;
        this.codigoTurma = codigoTurma;
    }

    public Aluno(int codigo) {
        this.codigo = codigo;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
