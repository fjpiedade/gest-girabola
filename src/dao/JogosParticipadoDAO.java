/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conectar.coneccao;
import modelo.JogosParticipado;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Fernando João
 */
public class JogosParticipadoDAO {
    private Connection con;
    public void adicionarJogosJogador(JogosParticipado jjogador){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_Jogojogador.adicionar_Jogojogador ("+jjogador.getNumFAF()+",'"+jjogador.getIdJogo()+"','"+jjogador.getIdEquipa()+"','"+jjogador.getNomeCamisa()+"','"+jjogador.getNomeCamisa()+"','"+jjogador.getHoraEntrar()+"','"+jjogador.getHoraSaida()+"','"+jjogador.getMotivoSaida()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Castigo Registrado Com Sucesso!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
        
    public void removerJogojogador(long idCastigo){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_Jogojogador.eliminar_Jogojogador ('"+idCastigo+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Castigo do Jogador Eliminado Com Sucesso!"," Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void actualizarJogojogador(JogosParticipado jjogador){
        try {
            con = coneccao.Conectar();
            
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_Jogojogador.actualizar_Jogojogador("+jjogador.getNumFAF()+",'"+jjogador.getIdJogo()+"','"+jjogador.getIdEquipa()+"','"+jjogador.getNomeCamisa()+"','"+jjogador.getNomeCamisa()+"','"+jjogador.getHoraEntrar()+"','"+jjogador.getHoraSaida()+"','"+jjogador.getMotivoSaida()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Castigo do Jogador Actualizado Com Sucesso","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public int tamanho(long numFAF, long idEquipa){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM jogojogador WHERE  numfaf="+numFAF+" AND idequipa="+idEquipa);
            rs.next();
            //JOptionPane.showMessageDialog(null, rs.getInt(1),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public Object[][] listarJogojogador(long numFAF, long idEquipa){
        //JOptionPane.showMessageDialog(null, IdEquipa+" idEquipa ","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        try {
            int linha=0;
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idjogo, numcamisa, nomecamisa, horaentrar, horasaida, motivo  FROM jogojogador WHERE numfaf="+numFAF+" AND idequipa="+idEquipa);
            Object[][] dados = new Object[tamanho(numFAF, idEquipa)][6];
            while(rs.next()){
                dados[linha][0] = rs.getLong(1);
                dados[linha][1] = rs.getLong(2);
                dados[linha][2] = rs.getString(3);//rs.getLong("socio.idutilizador")
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
    
    public boolean existeDefesa(long numFAF, long idJogo) {
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idCastigo FROM Defesajogador WHERE idCastigo="+numFAF);
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public JogosParticipado obterDefesa(long numFAF, long idJogo) {
        try {
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Defesajogador WHERE idCastigo = "+numFAF);
            JogosParticipado cartao = new JogosParticipado();
            if(existeDefesa(numFAF, idJogo)){
                rs.next();
                cartao.setNumFAF(numFAF);
                cartao.setNomeCamisa(rs.getString(2));
                cartao.setNomeCamisa(rs.getString(3));
                cartao.setNumFAF(rs.getLong(4));
                cartao.setNumFAF(rs.getLong(5));
                cartao.setNumFAF(rs.getLong(5));
                cartao.setNumFAF(rs.getLong(5));
                return cartao;
            }else{
                JOptionPane.showMessageDialog(null, "O(a) Jogador(a) Digitado Não Existe.");
            }
        } catch (SQLException ex) {}
        return null;
    }
}
