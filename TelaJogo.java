import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaJogo extends JFrame {
    public TelaJogo() {
        super("Escolha a fase");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel painelFases = new JPanel(new GridLayout(5, 1, 10, 10));

        // Adicionar botões para cada fase
        String[] fases = {"Hospital", "Casa", "Parquinho", "Restaurante", "Escola"};
        for (String fase : fases) {
            JButton botaoFase = new JButton(fase);
            botaoFase.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    iniciarJogoDaMemoria(fase);
                }
            });
            painelFases.add(botaoFase);
        }

        add(painelFases, BorderLayout.CENTER);
    }

    private void iniciarJogoDaMemoria(String fase) {
        JOptionPane.showMessageDialog(this, "Iniciando a fase: " + fase);

        // Inicializar o jogo da memória com a fase selecionada
        JogoDaMemoria jogoDaMemoria = new JogoDaMemoria(fase);
        jogoDaMemoria.setVisible(true);

        // Fechar a tela atual (tela inicial)
        setVisible(false);
        dispose(); // Liberar os recursos da tela inicial
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TelaJogo telaInicial = new TelaJogo();
                telaInicial.setVisible(true);
            }
        });
    }
}