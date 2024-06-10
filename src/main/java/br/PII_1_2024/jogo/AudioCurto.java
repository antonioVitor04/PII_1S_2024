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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class AudioCurto {
    private byte[] audioData;

    // Construtor que chama o método loadAudio para carregar o arquivo de áudio na memória
    public AudioCurto(String filePath) {
        try {
            this.audioData = loadAudio(filePath);  // Chama o método loadAudio
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método loadAudio que lê o arquivo de áudio e retorna um array de bytes
    private byte[] loadAudio(String filePath) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  // Stream para armazenar os dados do áudio
        try (FileInputStream fis = new FileInputStream(filePath)) {  // Lê o arquivo do sistema de arquivos
            byte[] buffer = new byte[1024];  // Buffer para leitura do arquivo
            int read;
            while ((read = fis.read(buffer)) != -1) {  // Lê o arquivo até o final
                baos.write(buffer, 0, read);  // Escreve os dados lidos no ByteArrayOutputStream
            }
        }
        return baos.toByteArray();  // Retorna os dados do áudio como um array de bytes
    }

    // Método playSound que cria uma nova thread para tocar o som
    public void playSound() {
        new Thread(() -> {
            try {
                ByteArrayInputStream bais = new ByteArrayInputStream(audioData);  // Cria um InputStream a partir dos dados do áudio
                AdvancedPlayer player = new AdvancedPlayer(bais);  // Cria o player
                player.play();  // Toca o som
            } 
            catch (JavaLayerException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
