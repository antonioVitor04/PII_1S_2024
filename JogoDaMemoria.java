import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

public class JogoDaMemoria extends JFrame {
    private ArrayList<Carta> cartas;
    private Carta cartaSelecionada;
    private int paresEncontrados;
    private long tempoInicial;

    public JogoDaMemoria(String fase) {
        super("Jogo da Memória - Fase: " + fase);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        cartas = new ArrayList<>();
        paresEncontrados = 0;

        // Inicializar o jogo da memória
        inicializarJogo();
    }

    private void inicializarJogo() {
        // Criar pares de imagens para as cartas
        Map<Integer, ImageIcon> imagensCartas = carregarImagensCartas();

        // Adicionar cartas ao jogo da memória
        for (int i = 1; i <= 10; i++) {
            ImageIcon imagem = imagensCartas.get(i);
            Carta carta1 = new Carta(i, imagem);
            Carta carta2 = new Carta(i, imagem);
            cartas.add(carta1);
            cartas.add(carta2); // Cada número forma um par
        }

        // Embaralhar as cartas
        Collections.shuffle(cartas);

        JPanel painelCartas = new JPanel(new GridLayout(4, 5, 10, 10));
        for (Carta carta : cartas) {
            carta.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!carta.isVirada()) {
                        virarCarta(carta);
                    }
                }
            });
            painelCartas.add(carta);
        }

        add(painelCartas, BorderLayout.CENTER);

        // Registrar o tempo inicial
        tempoInicial = System.currentTimeMillis();
    }

    private void virarCarta(Carta carta) {
        carta.virar(); // Virar a carta clicada

        if (cartaSelecionada == null) {
            cartaSelecionada = carta;
        } else {
            // Verificar se as cartas formam um par
            if (carta.getNumero() == cartaSelecionada.getNumero()) {
                paresEncontrados++;
                carta.setEnabled(false);
                cartaSelecionada.setEnabled(false);
                cartaSelecionada = null; // Limpar a carta selecionada
            } else {
                // Aguardar um momento e desvirar as cartas
                Timer timer = new Timer(1000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        carta.virar(); // Desvirar a carta clicada
                        cartaSelecionada.virar(); // Desvirar a carta previamente selecionada
                        cartaSelecionada = null; // Limpar a carta selecionada
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        }

        // Verificar se todos os pares foram encontrados
        if (paresEncontrados == 10) {
            long tempoTotal = (System.currentTimeMillis() - tempoInicial) / 1000;
            JOptionPane.showMessageDialog(this, "Parabéns! Você completou a fase em " + tempoTotal + " segundos.", "Fim da Fase", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    private Map<Integer, ImageIcon> carregarImagensCartas() {
        Map<Integer, ImageIcon> imagensCartas = new HashMap<>();
        // Carregar as imagens necessárias para as cartas (substitua os caminhos pelas suas imagens)
        imagensCartas.put(1, new ImageIcon("caminho/para/imagem1.jpg"));
        imagensCartas.put(2, new ImageIcon("caminho/para/imagem2.jpg"));
        // Adicionar as imagens para os outros números de carta...

        return imagensCartas;
    }
}