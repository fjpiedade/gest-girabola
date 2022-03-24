/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conectar.coneccao;
import modelo.Utilizador;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Fernando João
 */
public class UtilizadorDAO {
    private Connection con;
    public void adicionarUtilizador(Utilizador utilizador){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_utilizador.adicionar_utilizador ("+utilizador.getIdUtilizador()+",'"+utilizador.getNomeUtilizador()+"','"+utilizador.getSenhaUtilizador()+"','"+utilizador.getDataCriado()+"','"+utilizador.getBi()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Utilizador(a) Registrado(a) Com Sucesso!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public long novoIdUtilizador(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(idutilizador) FROM utilizador");
            rs.next();
            return rs.getLong(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public void removerUtilizador(long idutilizador){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_utilizador.eliminar_utilizador ('"+idutilizador+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Utilizador Eliminado Com Sucesso!"," Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void actualizarUtilizador(Utilizador utilizador){
        try {
            con = coneccao.Conectar();
            
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_utilizador.adicionar_utilizador ("+utilizador.getIdUtilizador()+",'"+utilizador.getNomeUtilizador()+"','"+utilizador.getSenhaUtilizador()+"',"+utilizador.getDataCriado()+",'"+utilizador.getBi()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Pessoa Actualizada Com Sucesso","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public int tamanho(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM utilizador");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public Object[][] listarUtilizador(){
        try {
            int linha=0;
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT utilizador.idutilizador, pessoa.nome, utilizador.bi, pessoa.telefone, pessoa.email  FROM utilizador, pessoa WHERE utilizador.bi=pessoa.bi ORDER BY utilizador.idutilizador");
            Object[][] dados = new Object[tamanho()][5];
            while(rs.next()){
                dados[linha][0] = rs.getLong(1);//rs.getLong("utilizador.idutilizador")
                dados[linha][1] = rs.getString(2);//rs.getString("pessoa.nome")
                dados[linha][2] = rs.getString(3);//rs.getString("utilizador.bi")
                dados[linha][3] = rs.getString(4);//rs.getString("pessoa.telefone")
                dados[linha++][4] = rs.getString(5);//rs.getString("pessoa.email")
            }
            return dados;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    public boolean existeUtilizador(long idUtilizador) {
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idUtilizador FROM utilizador WHERE idUtilizador="+idUtilizador);
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public Utilizador obterUtilizador(long idutilizador) {
        try {
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM utilizador WHERE idUtilizador = "+idutilizador);
            Utilizador utilizador = new Utilizador();
            if(existeUtilizador(idutilizador)){
                rs.next();
                utilizador.setIdUtilizador(idutilizador);
                utilizador.setNomeUtilizador(rs.getString(2));
                utilizador.setSenhaUtilizador(rs.getString(3));
                utilizador.setDataCriado(rs.getString(4));
                utilizador.setBi(rs.getString(5));
                return utilizador;
            }else{
                JOptionPane.showMessageDialog(null, "O Utilizador Digitado Não Existe.");
            }
        } catch (SQLException ex) {}
        return null;
    }
    
    public boolean existeUtilizadorLogin(String nomeUtilizador, String senhaUtilizador) {
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT nomeUtilizador, senhaUtilizador FROM utilizador WHERE nomeUtilizador='"+nomeUtilizador+"' AND "+"senhaUtilizador='"+senhaUtilizador+"'");
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    
}