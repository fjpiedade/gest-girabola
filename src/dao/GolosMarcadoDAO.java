/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conectar.coneccao;
import modelo.Cartao;
import modelo.GolosMarcado;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Fernando João
 */
public class GolosMarcadoDAO {
    private Connection con;
    public void adicionarGoloMarcado(GolosMarcado golo){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_Golojogo.adicionar_Golojogo ("+golo.getInstante()+",'"+golo.getIdjogo()+"','"+golo.getNumfaf()+"','"+golo.getIdequipa()+"','"+golo.getLocalgolo()+"','"+golo.getFormagolo()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Golo do Jogador Registrado Com Sucesso!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public long novoIDCartao(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(idCastigo) FROM Golojogo");
            rs.next();
            return rs.getLong(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public void removerGoloMarcado(long idJogo, long numFAF){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_Golojogo.eliminar_Golojogo ('"+idJogo+"','"+numFAF+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Golo do Jogador Eliminado Com Sucesso!"," Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void actualizarGoloMarcado(GolosMarcado golo){
        try {
            con = coneccao.Conectar();
            
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_Golojogo.actualizar_Golojogo ("+golo.getInstante()+",'"+golo.getIdjogo()+"','"+golo.getNumfaf()+"','"+golo.getIdequipa()+"','"+golo.getLocalgolo()+"','"+golo.getFormagolo()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Golo do Jogador Actualizado Com Sucesso","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public int tamanho(long numFAF, long idEquipa){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM Golojogo WHERE  numfaf="+numFAF+" AND idequipa="+idEquipa);
            rs.next();
            //JOptionPane.showMessageDialog(null, rs.getInt(1),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public Object[][] listarGoloMarcado(long numFAF, long idEquipa){
        //JOptionPane.showMessageDialog(null, IdEquipa+" idEquipa ","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        try {
            int linha=0;
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT Instante, Idjogo, localgolo, formagolo  FROM Golojogo WHERE numfaf="+numFAF+" AND idequipa="+idEquipa);
            Object[][] dados = new Object[tamanho(numFAF, idEquipa)][4];
            while(rs.next()){
                dados[linha][0] = rs.getString(1);//rs.getLong("socio.idutilizador")
                dados[linha][1] = rs.getLong(2);//rs.getString("pessoa.nome")                
                dados[linha][2] = rs.getString(3);//rs.getString("pessoa.nome")
                dados[linha++][3] = rs.getString(4);//rs.getString("pessoa.email")
            }
            return dados;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    public boolean existeGoloMarcado(long numFAF, long idJogo) {
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idCastigo FROM Castigojogador WHERE idCastigo="+numFAF);
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public Cartao obterGoloMarcado(long numFAF, long idJogo) {
        try {
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Castigojogador WHERE idCastigo = "+numFAF);
            Cartao cartao = new Cartao();
            if(existeGoloMarcado(numFAF, idJogo)){
                rs.next();
                cartao.setInstante(""+numFAF+"");
                cartao.setCor(rs.getString(2));
                cartao.setMotivo(rs.getString(3));
                cartao.setNumCartao(rs.getLong(4));
                cartao.setIdjogo(rs.getLong(5));
                cartao.setNumfaf(rs.getLong(5));
                cartao.setIdequipa(rs.getLong(5));
                return cartao;
            }else{
                JOptionPane.showMessageDialog(null, "O(a) Jogador(a) Digitado Não Existe.");
            }
        } catch (SQLException ex) {}
        return null;
    }
}
