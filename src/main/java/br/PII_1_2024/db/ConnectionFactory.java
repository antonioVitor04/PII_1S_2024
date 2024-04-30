/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.PII_1_2024.db;

/**
 *
 * @author anton
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class ConnectionFactory {
    private String host = "mysql-14b63315-pooteladelogin.b.aivencloud.com";
    private String port = "24968";
    private String db = "defaultdb";
    private String user = "avnadmin";
    private String password = "AVNS_8lo0TqiYiQTx6oOFY-4";
    
    //4 partes: tipo de retorno, nome,lista de parâmetros, corpo
    public Connection obterConexao(){
        try{
            //http://www.google.com:80/search
            //jdbc:mysql://host:port/db
            String stringConexao = String.format(
                "jdbc:mysql://%s:%s/%s", host, port, db
            );
            var conexao = DriverManager.getConnection(stringConexao, user, password);
            return conexao;
         
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Tente novamente mais tarde");
            return null;
        }
            
    }
}
