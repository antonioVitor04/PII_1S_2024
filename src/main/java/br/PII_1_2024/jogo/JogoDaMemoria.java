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
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

public class JogoDaMemoria extends javax.swing.JFrame{
       
    private ArrayList<Carta> cartas;
    private Carta cartaSelecionada;
    private int paresEncontrados;
    private long tempoInicial;
    private boolean virarPermitido = true;
    private JPanel backgroundImage;
    private ActionListener jogoTerminadoListener;

    /**
     *
     * @param nomeFase
     */
    public JogoDaMemoria(String nomeFase) {
        super("jogo da memória - fase: " +nomeFase);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        cartas = new ArrayList<>();
        paresEncontrados = 0;
        
        backgroundImage = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Desenhar a imagem de fundo
                ImageIcon backgroundImage = new ImageIcon("src/main/resources/images/ImagemDeFases.jpg"); // Substitua o caminho pela sua imagem de fundo
                Image image = backgroundImage.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        getContentPane().setBackground(Color.BLACK); // Definir cor de fundo do JFrame
        backgroundImage.setLayout(new BorderLayout());
        
        
        
        
        // Adicionar o painel de fundo ao JFrame
        add(backgroundImage);
        
        
        
    }
    

    public void inicializarJogoMemoria(int numeroDePares, String nomeFase) {
        
        // Criar pares de imagens para as cartas
        Map<Integer, ImageIcon> imagensCartas = carregarImagensCartas(numeroDePares, nomeFase);

        // Adicionar cartas ao jogo da memória 
        //(modo fácil com 8 pares de cartas)
        for (int i = 1; i <= numeroDePares; i++) {
            ImageIcon imagem = imagensCartas.get(i);
            Carta carta1 = new Carta(i, imagem);
            Carta carta2 = new Carta(i, imagem);
            cartas.add(carta1);
            cartas.add(carta2); // Cada número forma um par
        }

        // Embaralhar as cartas
        Collections.shuffle(cartas);
        
        JPanel cartasPainel = new JPanel(new GridLayout(4, 4, 10, 10));
        cartasPainel.setOpaque(false);
        
        
        for (Carta carta : cartas) {
            carta.setPreferredSize(new Dimension(200, 200));
            carta.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!carta.isVirada()) {
                        virarCarta(carta, numeroDePares);
                    }
                }
            });
            cartasPainel.add(carta);
        }
        JPanel centralPanel = new JPanel(new GridBagLayout());
        centralPanel.setOpaque(false);
        centralPanel.add(cartasPainel);
        
        backgroundImage.add(centralPanel, BorderLayout.CENTER);

        

        // Registrar o tempo inicial
        tempoInicial = System.currentTimeMillis();
    }
    
    
    

    public void virarCarta(Carta carta, int numeroDePares) {
            // Verificar se já foram encontrados todos os pares
        if (paresEncontrados == numeroDePares) {
            return;
        }

        // Verificar se a carta clicada já está virada
        if (carta.isVirada()) {
            return;
        }

        // Verificar se as cartas podem ser viradas neste momento
        if (!virarPermitido) {
            return;
        }

        carta.virar(); // Virar a carta clicada

        // Verificar se já existe uma carta selecionada
        if (cartaSelecionada == null) {
            cartaSelecionada = carta;
        } 
        else {
            // Verificar se as cartas formam um par
            if (carta.getNumero() == cartaSelecionada.getNumero()) {
                paresEncontrados++;
                carta.setEnabled(false);
                cartaSelecionada.setEnabled(false);
                cartaSelecionada = null; // Limpar a carta selecionada

                // Verificar se todos os pares foram encontrados
                if (paresEncontrados == numeroDePares) {
                    long tempoTotal = calcularTempoTotal();
                    JOptionPane.showMessageDialog(this, "PARABÉNS! VOCÊ COMPLETOU A FASE EM " + tempoTotal + " SEGUNDOS.", "FIM DA FASE", JOptionPane.INFORMATION_MESSAGE);
                    onJogoTerminado();
                }
                
            } 
            else {
                // Impedir virar de outras cartas até que o tempo de espera termine
                virarPermitido = false;

                // Aguardar um momento e desvirar as cartas
                Timer timer = new Timer(1000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        carta.virar(); // Desvirar a carta clicada
                        cartaSelecionada.virar(); // Desvirar a carta previamente selecionada

                        // Permitir virar de outras cartas novamente
                        virarPermitido = true;

                        cartaSelecionada = null; // Limpar a carta selecionada
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        }
    }
    public void setJogoTerminadoListener(ActionListener listener) {
        this.jogoTerminadoListener = listener;
    }
    
    private void onJogoTerminado() {
        if (jogoTerminadoListener != null) {
            jogoTerminadoListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
        }
    }
    
    private long calcularTempoTotal() {
        return (System.currentTimeMillis() - tempoInicial) / 1000;
    }

    public long getTempoTotal() {
        return calcularTempoTotal();
    }

    public Map<Integer, ImageIcon> carregarImagensCartas(int numeroDePares, String nomeFase) {
        Map<Integer, ImageIcon> imagensCartas = new HashMap<>();
        // Carregar as imagens necessárias para as cartas (substitua os caminhos pelas suas imagens)
        int i = 1;
        while(i <= numeroDePares){
        imagensCartas.put(i, new ImageIcon("src/main/resources/cartas/"+nomeFase+"Carta"+i+".png"));
        i++;
        }
        // Adicionar as imagens para os outros números de carta...

        return imagensCartas;
    }

}
