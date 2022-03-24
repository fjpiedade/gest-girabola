/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conectar.coneccao;
import modelo.HistorialJogador;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Fernando João
 */
public class HistorialJogadoDAO {
    private Connection con;
    public void adicionarHistorialjogador(HistorialJogador historial){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_Historialjogador.adicionar_Historialjogador ("+historial.getNumhistorialjogador()+",'"+historial.getNumfaf()+"','"+historial.getIdEquipa()+"','"+historial.getDatainicio()+"','"+historial.getDatafim()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Historial Registrado Com Sucesso!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public long novoIDHistorialjogador(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(Numhistorialjogador) FROM Historialjogador");
            rs.next();
            return rs.getLong(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public void removerHistorialjogador(long Numhistorialjogador){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_Historialjogador.eliminar_Historialjogador ('"+Numhistorialjogador+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Historial do Jogador Eliminado Com Sucesso!"," Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void actualizarHistorialjogador(HistorialJogador historial){
        try {
            con = coneccao.Conectar();
            
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_Historialjogador.actualizar_Historialjogador ("+historial.getNumhistorialjogador()+",'"+historial.getNumfaf()+"','"+historial.getIdEquipa()+"','"+historial.getDatainicio()+"','"+historial.getDatafim()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Historial do Jogador Actualizado Com Sucesso","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public int tamanho(long numFAF){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM HistorialJogador WHERE  numfaf="+numFAF);
            rs.next();
            //JOptionPane.showMessageDialog(null, rs.getInt(1),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public Object[][] listarHistorialjogador(long numFAF){
        //JOptionPane.showMessageDialog(null, IdEquipa+" idEquipa ","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        try {
            int linha=0;
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT numhistorialjogador, (SELECT nome FROM clube WHERE numidfiscal=(SELECT numidfiscal FROM equipa WHERE equipa.idequipa=HistorialJogador.idequipa)) ,HistorialJogador.idequipa, datainico, datafim  FROM HistorialJogador, equipa, clube WHERE numfaf="+numFAF+" AND equipa.idequipa=HistorialJogador.idequipa AND equipa.numidfiscal=clube.numidfiscal ORDER BY numhistorialjogador");
            Object[][] dados = new Object[tamanho(numFAF)][5];
            while(rs.next()){
                dados[linha][0] = rs.getLong(1);//rs.getLong("socio.idutilizador")
                dados[linha][1] = rs.getString(2);//rs.getString("pessoa.nome")                
                dados[linha][2] = rs.getLong(3);//rs.getString("pessoa.nome")
                dados[linha][3] = rs.getString(4);//rs.getString("pessoa.nome")                
                dados[linha++][4] = rs.getString(5);//rs.getString("pessoa.email")
            }
            return dados;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    public boolean existeHistorialjogador(long numhistorialjogador) {
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT numfaf FROM HistorialJogador WHERE numfaf="+numhistorialjogador);
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public HistorialJogador obterHistorialjogador(long numhistorialjogador) {
        try {
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM HistorialJogador WHERE numfaf = "+numhistorialjogador);
            HistorialJogador historial = new HistorialJogador();
            if(existeHistorialjogador(numhistorialjogador)){
                rs.next();
                historial.setNumhistorialjogador(numhistorialjogador);
                historial.setNumfaf(rs.getLong(2));
                historial.setIdEquipa(rs.getLong(3));
                historial.setDatainicio(rs.getString(4));
                historial.setDatafim(rs.getString(5));
                return historial;
            }else{
                JOptionPane.showMessageDialog(null, "O(a) Jogador(a) Digitado Não Existe.");
            }
        } catch (SQLException ex) {}
        return null;
    }
}
