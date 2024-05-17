/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.PII_1_2024.modelo;

/**
 *
 * @author anton
 */
public class Professor {
    private int codigo;
    private String nome;
    private String senha;

    public Professor(int codigo, String nome, String senha) {
        this.codigo = codigo;
        this.nome = nome;
        this.senha = senha;
    }

    public Professor(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    public Professor(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }
    public Professor(int codigo){
        this.codigo = codigo;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }
   
    
    
    public int getCodigo(){
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
