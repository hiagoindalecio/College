/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
        
    public Connection getConexao()
    {
        try {
            //Tentar estabelecer conexão
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/prog_obj_db_prova2",
                "root",
                ""
            );
            return conn;
        } catch (Exception e) {
            System.out.println("Erro ao conectar. "+ e.getMessage());
            return null;
        }
        
    }
}
