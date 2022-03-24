/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conectar.coneccao;
import modelo.Equipa;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Fernando João
 */
public class EquipaDAO {
    private Connection con;
    public void adicionarEquipa(Equipa equipa){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_equipa.adicionar_equipa ("+equipa.getIdEquipa()+",'"+equipa.getDescricao()+"',"+equipa.getNumIdFiscal()+"); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Equipa Registrado Com Sucesso!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public long novoIdEquipa(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(idequipa) FROM equipa");
            rs.next();
            return rs.getLong(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public void removerEquipa(long idEquipa){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_equipa.eliminar_equipa ('"+idEquipa+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Equipa Eliminado Com Sucesso!"," Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void actualizarEquipa(Equipa equipa){
        try {
            con = coneccao.Conectar();
            
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_equipa.adicionar_equipa ("+equipa.getIdEquipa()+",'"+equipa.getDescricao()+"',"+equipa.getNumIdFiscal()+"); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Equipa Actualizada Com Sucesso","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public int tamanho(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM equipa");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public Object[][] listarEquipa(){
        try {
            int linha=0;
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM equipa");
            Object[][] dados = new Object[tamanho()][5];
            while(rs.next()){
                dados[linha][0] = rs.getLong(1);//rs.getLong("socio.idutilizador")
                dados[linha][1] = rs.getString(2);//rs.getString("pessoa.nome")                
                dados[linha++][2] = rs.getString(3);//rs.getString("pessoa.email")
            }
            return dados;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    public Object[][] listarEquipaCampeonato(){
        try {
            int linha=0;
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT clube.nome, clube.inicias, equipa.idequipa FROM clube, equipa WHERE clube.numidfiscal=equipa.numidfiscal ORDER BY equipa.idequipa");
            Object[][] dados = new Object[tamanho()][3];
            while(rs.next()){
                dados[linha][0] = rs.getString(1);//rs.getLong("socio.idutilizador")
                dados[linha][1] = rs.getString(2);//rs.getString("pessoa.nome")                
                dados[linha++][2] = rs.getLong(3);//rs.getString("pessoa.email")
            }
            return dados;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    public boolean existeEquipa(long idEquipa) {
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idequipa FROM equipa WHERE idequipa="+idEquipa);
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public Equipa obterEquipa(long idEquipa) {
        try {
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM equipa WHERE idequipa = "+idEquipa);
            Equipa equipa = new Equipa();
            if(existeEquipa(idEquipa)){
                rs.next();
                equipa.setIdEquipa(idEquipa);
                equipa.setDescricao(rs.getString(2));
                equipa.setNumIdFiscal(rs.getLong(3));
                return equipa;
            }else{
                JOptionPane.showMessageDialog(null, "A Equipa Digitado Não Existe.");
            }
        } catch (SQLException ex) {}
        return null;
    }
}
