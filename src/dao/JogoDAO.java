/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conectar.coneccao;
import java.sql.*;
import javax.swing.*;
import modelo.Jogo;
import modelo.Campeonato;
/**
 *
 * @author Fernando João
 */
public class JogoDAO {
    private Connection con;
    public void adicionarCampeonato(Campeonato campeonato){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_campeonato.adicionar_campeonato ("+campeonato.getIdCampeonato()+","+campeonato.getDescricao()+","+campeonato.getAno()+"); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Campeonato Registrado Com Sucesso!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public long novoIdCampeonato(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(idCampeonato) FROM campeonato");
            rs.next();
            return rs.getLong(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public void removerCampeonato(long idCampeonato){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_campeonato.eliminar_campeonato ('"+idCampeonato+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Campeonato Eliminado Com Sucesso!"," Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void actualizarCampeonato(Campeonato campeonato){
        try {
            con = coneccao.Conectar();
            
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_campeonato.actualizar_campeonato ("+campeonato.getIdCampeonato()+","+campeonato.getDescricao()+","+campeonato.getAno()+"); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Campeonato Actualizada Com Sucesso","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public int tamanho(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM campeonato");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public Object[][] listarCampeonato(){
        try {
            int linha=0;
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idCampeonato, descricao, ano FROM campeonato ORDER BY idCampeonato");
            Object[][] dados = new Object[tamanho()][3];
            while(rs.next()){
                dados[linha][0] = rs.getLong(1);//rs.getLong("socio.idutilizador")
                dados[linha][1] = rs.getString(2);//rs.getString("pessoa.nome")
                dados[linha++][2] = rs.getLong(3);//rs.getString("pessoa.email")
            }
            return dados;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    public boolean existeCampeonato(long idCampeonato) {
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idCampeonato FROM campeonato WHERE idcampeonato="+idCampeonato);
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public Campeonato obterCampeonato(long idCampeonato) {
        try {
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Campeonato WHERE idCampeonato = "+idCampeonato);
            Campeonato campeonato = new Campeonato();
            if(existeCampeonato(idCampeonato)){
                rs.next();
                campeonato.setIdCampeonato(idCampeonato);
                campeonato.setDescricao(rs.getString(3));
                campeonato.setAno(rs.getLong(4));
                
                return campeonato;
            }else{
                JOptionPane.showMessageDialog(null, "O Campeonato Digitado Não Existe.");
            }
        } catch (SQLException ex) {}
        return null;
    }
}
