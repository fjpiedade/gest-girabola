/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conectar.coneccao;
import java.sql.*;
import javax.swing.*;
import modelo.Estadio;

/**
 *
 * @author Fernando João
 */
public class EstadioDAO {
    private Connection con;
    public void adicionarEstadio(Estadio estadio){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_estadio.adicionar_estadio ("+estadio.getIdEstadio()+","+estadio.getLotacao()+","+estadio.getLocal()+",'"+estadio.getNome()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Estadio Registrado Com Sucesso!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public long novoIdEstadio(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(idestadio) FROM estadio");
            rs.next();
            return rs.getLong(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public void removerEstadio(long idEstadio){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_estadio.eliminar_estadio ('"+idEstadio+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Estadio Eliminado Com Sucesso!"," Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void actualizarEstadio(Estadio estadio){
        try {
            con = coneccao.Conectar();
            
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_estadio.actualizar_estadio ("+estadio.getIdEstadio()+","+estadio.getLotacao()+","+estadio.getLocal()+",'"+estadio.getNome()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Estadio Actualizada Com Sucesso","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public int tamanho(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM estadio");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public Object[][] listarEstadio(){
        try {
            int linha=0;
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idestadio, nome, lotacao, local FROM estadio ORDER BY idestadio");
            Object[][] dados = new Object[tamanho()][4];
            while(rs.next()){
                dados[linha][0] = rs.getLong(1);//rs.getLong("socio.idutilizador")
                dados[linha][1] = rs.getString(2);//rs.getString("pessoa.nome")
                dados[linha][2] = rs.getLong(3);//rs.getString("pessoa.nome")
                dados[linha++][3] = rs.getString(4);//rs.getString("pessoa.email")
            }
            return dados;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    public boolean existeEstadio(long idEstadio) {
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idestadio FROM estadio WHERE idarbitro="+idEstadio);
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public Estadio obterEstadio(long idEstadio) {
        try {
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM estadio WHERE idarbitro = "+idEstadio);
            Estadio estadio = new Estadio();
            if(existeEstadio(idEstadio)){
                rs.next();
                estadio.setIdEstadio(idEstadio);
                estadio.setLotacao(rs.getLong(2));
                estadio.setLocal(rs.getString(3));
                estadio.setNome(rs.getString(4));
                
                return estadio;
            }else{
                JOptionPane.showMessageDialog(null, "O Estadio Digitado Não Existe.");
            }
        } catch (SQLException ex) {}
        return null;
    }
}
