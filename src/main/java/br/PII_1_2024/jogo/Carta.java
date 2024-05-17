/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.PII_1_2024.jogo;

/**
 *
 * @author anton
 */
import javax.swing.*;
import java.awt.*;

public class Carta extends JButton {
    private int numero;
    private ImageIcon imagemVirada;
    private ImageIcon imagemPadrao;
    private boolean virada;

    public Carta(int numero, ImageIcon imagemVirada) {
        this.numero = numero;
        this.imagemVirada = imagemVirada;
        this.imagemPadrao = new ImageIcon("src/main/resources/images/ImagemPadrao.png"); // Caminho da imagem de carta virada para baixo
        this.virada = false;

        // Definir a imagem padrão (carta virada para baixo)
        setIcon(imagemPadrao);
    }

    public void virar() {
        if (!virada) {
            setIcon(imagemVirada); // Mostra a imagem da carta virada para cima
            virada = true;
        } else {
            setIcon(imagemPadrao); // Volta a exibir a imagem padrão de carta virada para baixo
            virada = false;
        }
    }

    public boolean isVirada() {
        return virada;
    }

    public int getNumero() {
        return numero;
    }
}