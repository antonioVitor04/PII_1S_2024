/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.PII_1_2024.jogo;

/**
 *
 * @author anton
 */
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class AudioLoop {
    private String filePath;
    private boolean isPlaying;
    private Thread playThread;
    private final int songDurationMs = 17000; // Duração da música em milissegundos
    private final int overlapMs = 240; // Tempo de sobreposição entre as músicas
 

    public AudioLoop(String filePath) {
        this.filePath = filePath;
    }
    

    public void playLoop() {
        isPlaying = true;
        playThread = new Thread(() -> {
            while (isPlaying) {
                try {
                    playAudio();
                } catch (IOException | JavaLayerException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        playThread.start();
    }

    private void playAudio() throws IOException, JavaLayerException, InterruptedException {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filePath))) {
            AdvancedPlayer player = new AdvancedPlayer(inputStream);

            Thread playerThread = new Thread(() -> {
                try {
                    player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            });

            playerThread.start();

            // Aguarda um pouco antes do final da música para iniciar a próxima reprodução
            Thread.sleep(songDurationMs - overlapMs);

            // Termina a reprodução atual
            playerThread.interrupt();
        }
    }

    public void stop() {
        isPlaying = false;
        if (playThread != null) {
            playThread.interrupt();
        }
    }
}
