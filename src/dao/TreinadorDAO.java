/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conectar.coneccao;
import modelo.Treinador;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Fernando João
 */
public class TreinadorDAO {
    private Connection con;
    public void adicionarTreinador(Treinador treinador){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_treinador.adicionar_treinador ("+treinador.getIdTreinador()+",'"+treinador.getTipo()+"','"+treinador.getObs()+"','"+treinador.getBi()+"','"+treinador.getIdEquipa()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Treinador Registrado Com Sucesso!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public long novoIdTreinador(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(idtreinador) FROM treinador");
            rs.next();
            return rs.getLong(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public void removerTreinador(long idTreinador){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_treinador.eliminar_treinador ('"+idTreinador+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Treinador Eliminado Com Sucesso!"," Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void actualizarTreinador(Treinador treinador){
        try {
            con = coneccao.Conectar();
            
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_treinador.actualizar_treinador ("+treinador.getIdTreinador()+",'"+treinador.getTipo()+"','"+treinador.getObs()+"','"+treinador.getBi()+"','"+treinador.getIdEquipa()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Treinador Actualizado Com Sucesso","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public int tamanho(long IdEquipa){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM treinador WHERE idequipa="+IdEquipa);
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public Object[][] listarTreinador(long IdEquipa){
        //JOptionPane.showMessageDialog(null, IdEquipa+" idEquipa ","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        try {
            int linha=0;
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT treinador.idtreinador, pessoa.nome, treinador.bi, pessoa.telefone, treinador.tipo, pessoa.email  FROM treinador, pessoa WHERE treinador.bi=pessoa.bi AND treinador.idequipa="+IdEquipa+" ORDER BY treinador.idtreinador");
            Object[][] dados = new Object[tamanho(IdEquipa)][6];
            while(rs.next()){
                dados[linha][0] = rs.getLong(1);//rs.getLong("socio.idutilizador")
                dados[linha][1] = rs.getString(2);//rs.getString("pessoa.nome")                
                dados[linha][2] = rs.getString(3);//rs.getString("pessoa.nome")                
                dados[linha][3] = rs.getString(4);//rs.getString("pessoa.nome")                
                dados[linha][4] = rs.getString(5);//rs.getString("pessoa.nome")                
                dados[linha++][5] = rs.getString(6);//rs.getString("pessoa.email")
            }
            return dados;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    public boolean existeTreinador(long idTreinador) {
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idtreinador FROM treinador WHERE idTreinador="+idTreinador);
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public Treinador obterTreinador(long idTreinador) {
        try {
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM treinador WHERE idtreinador = "+idTreinador);
            Treinador treinador = new Treinador();
            if(existeTreinador(idTreinador)){
                rs.next();
                treinador.setIdTreinador(idTreinador);
                treinador.setTipo(rs.getString(2));
                treinador.setObs(rs.getString(3));
                treinador.setBi(rs.getString(4));
                treinador.setIdEquipa(rs.getLong(5));
                return treinador;
            }else{
                JOptionPane.showMessageDialog(null, "O(a) Treinador(a) Digitado Não Existe.");
            }
        } catch (SQLException ex) {}
        return null;
    }
}
