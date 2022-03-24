/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conectar;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Fernando João
 */
public class coneccao {
    private static Connection con;
    public static Connection Conectar(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "project_AS", "project_AS");
            //JOptionPane.showMessageDialog(null,"Conecção Realizada Com Sucesso!");
            //System.out.println("Conecção Realizada Com Sucesso!");
            return con;
        } catch (ClassNotFoundException cnf) {
            JOptionPane.showMessageDialog(null,"Erro ao Carregar Drives");
        }
        catch(SQLException sq){
        
        }
            return null;
    }
    
    public static void main(String[] args){
        Conectar();
    }
    
}
