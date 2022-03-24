/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conectar.coneccao;
import modelo.Presidente;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Fernando João
 */
public class PresidenteDAO {
    private Connection con;
    public void adicionarPresidente(Presidente presidente){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_presidente.adicionar_presidente ("+presidente.getIdPresidente()+",'"+presidente.getBi()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Presidente(a) Registrado(a) Com Sucesso!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public long novoIdPresidente(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(idpresidente) FROM presidente");
            rs.next();
            return rs.getLong(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public void removerPresidente(long idPresidente){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_presidente.eliminar_presidente ('"+idPresidente+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Presidente Eliminado Com Sucesso!"," Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void actualizarPresidente(Presidente presidente){
        try {
            con = coneccao.Conectar();
            
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_presidente.adicionar_presidente ("+presidente.getIdPresidente()+",'"+presidente.getBi()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Presidente Actualizada Com Sucesso","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public int tamanho(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM presidente");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public Object[][] listarPresidente(){
        try {
            int linha=0;
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT presidente.idpresidente, pessoa.nome, presidente.bi, pessoa.telefone, pessoa.email  FROM presidente, pessoa WHERE presidente.bi=pessoa.bi ORDER BY presidente.idpresidente");
            Object[][] dados = new Object[tamanho()][5];
            while(rs.next()){
                dados[linha][0] = rs.getLong(1);//rs.getLong("socio.idutilizador")
                dados[linha][1] = rs.getString(2);//rs.getString("pessoa.nome")
                dados[linha][2] = rs.getString(3);//rs.getString("socio.bi")
                dados[linha][3] = rs.getString(4);//rs.getString("pessoa.telefone")
                dados[linha++][4] = rs.getString(5);//rs.getString("pessoa.email")
            }
            return dados;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    public boolean existePresidente(long idPresidente) {
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idpresidente FROM presidente WHERE idpresidente="+idPresidente);
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public Presidente obterPresidente(long idPresidente) {
        try {
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM presidente WHERE idpresidente = "+idPresidente);
            Presidente presidente = new Presidente();
            if(existePresidente(idPresidente)){
                rs.next();
                presidente.setIdPresidente(idPresidente);
                presidente.setBi(rs.getString(2));
                return presidente;
            }else{
                JOptionPane.showMessageDialog(null, "O Presidente Digitado Não Existe.");
            }
        } catch (SQLException ex) {}
        return null;
    }
}
