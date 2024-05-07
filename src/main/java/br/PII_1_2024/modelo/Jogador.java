package br.PII_1_2024.modelo;

/**
 *
 * @author anton
 */
public class Jogador{

    int codigo;
    String nome;
    Turma turma;

    public Jogador(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Jogador(int codigo) {
        this.codigo = codigo;
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

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
