/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.PII_1_2024.modelo;

/**
 *
 * @author anton
 */
public class Fase {
    private int codigoFase;
    private int numero;
    private String nome;
    
    public Fase(int codigoFase, String nome){
        this.codigoFase = codigoFase;
        this.nome = nome;
    }
    public Fase(int codigoFase){
        this.codigoFase = codigoFase;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }

    public int getCodigoFase() {
        return codigoFase;
    }

    public void setCodigoFase(int codigoFase) {
        this.codigoFase = codigoFase;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
