/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conectar.coneccao;
import modelo.Clube;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Fernando João
 */
public class ClubeDAO {
    private Connection con;
    public void adicionarClube(Clube clube){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_clube.adicionar_clube ("+clube.getNumIdFiscal()+",'"+clube.getNomeClube()+"','"+clube.getInicias()+"',"+clube.getCapitaSocial()+",'"+clube.getSituacaoFiscal()+"','"+clube.getMoradaSede()+"','"+clube.getTelefoneSede()+"','"+clube.getIdPresidente()+"','"+clube.getBandeira()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Clube Registrado Com Sucesso!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
        
    public void removerClube(long numIdFiscal){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_clube.eliminar_clube ('"+numIdFiscal+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Clube Eliminado Com Sucesso!"," Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void actualizarClube(Clube clube){
        try {
            con = coneccao.Conectar();
            
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_clube.adicionar_clube ("+clube.getNumIdFiscal()+",'"+clube.getNomeClube()+"','"+clube.getInicias()+"','"+clube.getCapitaSocial()+"','"+clube.getSituacaoFiscal()+"','"+clube.getMoradaSede()+"','"+clube.getTelefoneSede()+"','"+clube.getIdPresidente()+"','"+clube.getBandeira()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Clube Actualizado Com Sucesso","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public int tamanho(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM clube");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public Object[][] listarClube(){
        try {
            int linha=0;
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT numIdFiscal, nome, inicias, capitalsocial, situacaofiscal, telefonesede  FROM clube ORDER BY numIdFiscal");
            Object[][] dados = new Object[tamanho()][6];
            while(rs.next()){
                dados[linha][0] = rs.getLong(1);//rs.getLong("socio.idutilizador")
                dados[linha][1] = rs.getString(2);//rs.getString("pessoa.nome")
                dados[linha][2] = rs.getString(3);//rs.getString("socio.bi")
                dados[linha][3] = rs.getDouble(4);//rs.getString("pessoa.telefone")
                dados[linha][4] = rs.getString(5);//rs.getString("pessoa.email")
                dados[linha++][5] = rs.getString(6);//rs.getLong("socio.idutilizador")
                            
            }
            return dados;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    public boolean existeClube(long numIdFiscal) {
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT numIdFiscal FROM clube WHERE numIdFiscal="+numIdFiscal);
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public Clube obterClube(long numIdFiscal) {
        try {
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM clube WHERE numidfiscal = "+numIdFiscal);
            Clube clube = new Clube();
            if(existeClube(numIdFiscal)){
                rs.next();
                clube.setNumIdFiscal(numIdFiscal);
                clube.setNomeClube(rs.getString(2));
                clube.setInicias(rs.getString(3));
                clube.setCapitaSocial(rs.getDouble(4));
                clube.setSituacaoFiscal(rs.getString(5));
                clube.setMoradaSede(rs.getString(6));
                clube.setTelefoneSede(rs.getString(7));
                clube.setIdPredinte(rs.getLong(8));
                return clube;
            }else{
                JOptionPane.showMessageDialog(null, "O Presidente Digitado Não Existe.");
            }
        } catch (SQLException ex) {}
        return null;
    }
    
    public long obterEquipaClube(long numIdFiscal){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idequipa FROM equipa WHERE numidfiscal="+numIdFiscal);
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
}