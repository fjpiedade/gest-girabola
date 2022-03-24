/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conectar.coneccao;
import modelo.Castigo;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Fernando João
 */
public class CastigoDAO {
    private Connection con;
    public void adicionarCastigojogador(Castigo castigo){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_Castigojogador.adicionar_Castigojogador ("+castigo.getIdCastigo()+",'"+castigo.getNumHistorialJogador()+"','"+castigo.getMotivoCastigo()+"','"+castigo.getInicioCastigo()+"','"+castigo.getFimCastigo()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Castigo Registrado Com Sucesso!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public long novoIDCastigo(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(idCastigo) FROM Castigojogador");
            rs.next();
            return rs.getLong(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public void removerCastigojogador(long idCastigo){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_Castigojogador.eliminar_Castigojogador ('"+idCastigo+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Castigo do Jogador Eliminado Com Sucesso!"," Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void actualizarCastigojogador(Castigo castigo){
        try {
            con = coneccao.Conectar();
            
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_Castigojogador.actualizar_Castigojogador("+castigo.getIdCastigo()+",'"+castigo.getNumHistorialJogador()+"','"+castigo.getMotivoCastigo()+"','"+castigo.getInicioCastigo()+"','"+castigo.getFimCastigo()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Castigo do Jogador Actualizado Com Sucesso","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public int tamanho(long numHistorial){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM Castigojogador WHERE  numhistorialjogador="+numHistorial);
            rs.next();
            //JOptionPane.showMessageDialog(null, rs.getInt(1),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public Object[][] listarCastigojogador(long numHistorial){
        //JOptionPane.showMessageDialog(null, IdEquipa+" idEquipa ","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        try {
            int linha=0;
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idCastigo, motivocastigo, iniciogastigo, fimcastigo  FROM castigojogador WHERE numhistorialjogador="+numHistorial+" ORDER BY idCastigo");
            Object[][] dados = new Object[tamanho(numHistorial)][4];
            while(rs.next()){
                dados[linha][0] = rs.getLong(1);//rs.getLong("socio.idutilizador")
                dados[linha][1] = rs.getString(2);//rs.getString("pessoa.nome")                
                dados[linha][2] = rs.getString(3);//rs.getString("pessoa.nome")
                dados[linha++][3] = rs.getString(4);//rs.getString("pessoa.email")
            }
            return dados;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    public boolean existeCastigojogador(long idCastigo) {
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idCastigo FROM Castigojogador WHERE idCastigo="+idCastigo);
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public Castigo obterCastigojogador(long idCastigo) {
        try {
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Castigojogador WHERE idCastigo = "+idCastigo);
            Castigo castigo = new Castigo();
            if(existeCastigojogador(idCastigo)){
                rs.next();
                castigo.setIdCastigo(idCastigo);
                castigo.setNumHistorialJogador(rs.getLong(2));
                castigo.setMotivoCastigo(rs.getString(3));
                castigo.setInicioCastigo(rs.getString(4));
                castigo.setFimCastigo(rs.getString(5));
                return castigo;
            }else{
                JOptionPane.showMessageDialog(null, "O(a) Jogador(a) Digitado Não Existe.");
            }
        } catch (SQLException ex) {}
        return null;
    }
}
