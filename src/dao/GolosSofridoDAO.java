/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conectar.coneccao;
import modelo.Cartao;
import modelo.GolosSofrido;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Fernando João
 */
public class GolosSofridoDAO {
    private Connection con;
    public void adicionarGoloSofrido(GolosSofrido golo){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_Golosofridojogador.adicionar_Golosofridojogador ("+golo.getHoradefesa()+",'"+golo.getForma()+"','"+golo.getLocalremate()+"','"+golo.getNumFAF()+"','"+golo.getIdjogo()+"','"+golo.getIdEquipa()+"'); END;");
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
            ResultSet rs = st.executeQuery("SELECT MAX(idCastigo) FROM Golosofridojogador");
            rs.next();
            return rs.getLong(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public void removerGoloSofrido(long idJogo, long numFAF){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_Golosofridojogador.eliminar_Golosofridojogador ('"+idJogo+"','"+numFAF+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Golo do Jogador Eliminado Com Sucesso!"," Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void actualizarGoloSofrido(GolosSofrido golo){
        try {
            con = coneccao.Conectar();
            
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_Golosofridojogador.actualizar_Golosofridojogador ("+golo.getHoradefesa()+",'"+golo.getForma()+"','"+golo.getLocalremate()+"','"+golo.getNumFAF()+"','"+golo.getIdjogo()+"','"+golo.getIdEquipa()+"'); END;");
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
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM Golosofridojogador WHERE  numfaf="+numFAF+" AND idequipa="+idEquipa);
            rs.next();
            //JOptionPane.showMessageDialog(null, rs.getInt(1),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public Object[][] listarGoloSofrido(long numFAF, long idEquipa){
        //JOptionPane.showMessageDialog(null, IdEquipa+" idEquipa ","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        try {
            int linha=0;
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT horagolosofrido, Idjogo, local, forma  FROM Golosofridojogador WHERE numfaf="+numFAF+" AND idequipa="+idEquipa);
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
    
    public boolean existeGoloSofrido(long numFAF, long idJogo) {
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idCastigo FROM Golosofridojogador WHERE idCastigo="+numFAF);
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public Cartao obterGoloSofrido(long numFAF, long idJogo) {
        try {
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Golosofridojogador WHERE idCastigo = "+numFAF);
            Cartao cartao = new Cartao();
            if(existeGoloSofrido(numFAF, idJogo)){
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
