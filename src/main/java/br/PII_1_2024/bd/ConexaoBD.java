/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.PII_1_2024.bd;

/**
 *
 * @author anton
 */
import java.sql.Connection;
import java.sql.DriverManager;
public class ConexaoBD {
    private static String host = "mysql-14b63315-pooteladelogin.b.aivencloud.com";
    private static String port = "24968";
    private static String db = "defaultdb";
    private static String user = "avnadmin";
    private static String password = "AVNS_8lo0TqiYiQTx6oOFY-4";
    
    //4 partes: tipo de retorno, nome,lista de parâmetros, corpo
    public static Connection obterConexao () throws Exception{
            //http://www.google.com:80/search
            //jdbc:mysql://host:port/db
            String stringConexao = String.format(
                "jdbc:mysql://%s:%s/%s", host, port, db
            );
            return DriverManager.getConnection(stringConexao, user, password);
            
    }
}
