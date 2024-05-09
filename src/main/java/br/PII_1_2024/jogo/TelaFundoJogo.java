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
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;
public class TelaFundoJogo extends JPanel {
//armazenará uma referência à imagem
    private Image background;
    public TelaFundoJogo(URL url) {
    //leitura da imagem a partir de um objeto URL
    //URL é o tipo de retorno de getResource
    //deve ser utilizado em projetos Maven
    try {
        background = ImageIO.read(url);
    } 
    catch (IOException e) {
        e.printStackTrace();
    }
}
//aqui dizemos que, depois de o componente ser desenhado, desenhamos também a imagem sobre ele
//a partir das coordenadas x = 0 e y = 0
    @Override
    public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(background, 0, 0, this);
    }
}
