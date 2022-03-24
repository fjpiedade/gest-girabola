/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conectar.coneccao;
import modelo.Socio;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Fernando João
 */
public class SocioDAO {
    private Connection con;
    public void adicionarSocio(Socio socio){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_socio.adicionar_socio ("+socio.getNumSocio()+",'"+socio.getBi()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Sócio(a) Registrado(a) Com Sucesso!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public long novoIdSocio(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(numsocio) FROM socio");
            rs.next();
            return rs.getLong(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public void removerUtilizador(long numSocio){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_socio.eliminar_socio ('"+numSocio+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Sócio Eliminado Com Sucesso!"," Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void actualizarSocio(Socio socio){
        try {
            con = coneccao.Conectar();
            
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_socio.adicionar_socio ("+socio.getNumSocio()+",'"+socio.getBi()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Sócio Actualizada Com Sucesso","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public int tamanho(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM socio");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public Object[][] listarSocio(){
        try {
            int linha=0;
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT socio.numsocio, pessoa.nome, socio.bi, pessoa.telefone, pessoa.email  FROM socio, pessoa WHERE socio.bi=pessoa.bi ORDER BY socio.numsocio");
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
    
    public boolean existeSocio(long numSocio) {
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT numsocio FROM socio WHERE numsocio="+numSocio);
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public Socio obterSocio(long numSocio) {
        try {
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM socio WHERE numsocio = "+numSocio);
            Socio socio = new Socio();
            if(existeSocio(numSocio)){
                rs.next();
                socio.setNumSocio(numSocio);
                socio.setBi(rs.getString(2));
                return socio;
            }else{
                JOptionPane.showMessageDialog(null, "O Sócio Digitado Não Existe.");
            }
        } catch (SQLException ex) {}
        return null;
    }
        
}
