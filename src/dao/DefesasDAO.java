/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conectar.coneccao;
import modelo.Cartao;
import modelo.Defesas;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Fernando João
 */
public class DefesasDAO {
    private Connection con;
    public void adicionarDefesa(Defesas defesa){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_Defesajogador.adicionar_Defesajogador ("+defesa.getHoradefesa()+",'"+defesa.getForma()+"','"+defesa.getLocalremate()+"','"+defesa.getNumFAF()+"','"+defesa.getIdjogo()+"','"+defesa.getIdEquipa()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Defesa do Jogador Registrado Com Sucesso!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public long novoIDCartao(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(idCastigo) FROM Defesajogador");
            rs.next();
            return rs.getLong(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public void removerDefesa(long idJogo, long numFAF){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_Defesajogador.eliminar_Defesajogador ('"+idJogo+"','"+numFAF+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Golo do Jogador Eliminado Com Sucesso!"," Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void actualizarDefesa(Defesas defesa){
        try {
            con = coneccao.Conectar();
            
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_Defesajogador.actualizar_Defesajogador ("+defesa.getHoradefesa()+",'"+defesa.getForma()+"','"+defesa.getLocalremate()+"','"+defesa.getNumFAF()+"','"+defesa.getIdjogo()+"','"+defesa.getIdEquipa()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Defesa do Jogador Actualizado Com Sucesso","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public int tamanho(long numFAF, long idEquipa){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM Defesajogador WHERE  numfaf="+numFAF+" AND idequipa="+idEquipa);
            rs.next();
            //JOptionPane.showMessageDialog(null, rs.getInt(1),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public Object[][] listarDefesa(long numFAF, long idEquipa){
        //JOptionPane.showMessageDialog(null, IdEquipa+" idEquipa ","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        try {
            int linha=0;
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT horadefesa, Idjogo, localremate, forma  FROM Defesajogador WHERE numfaf="+numFAF+" AND idequipa="+idEquipa);
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
    
    public Cartao obterDefesa(long numFAF, long idJogo) {
        try {
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Defesajogador WHERE idCastigo = "+numFAF);
            Cartao cartao = new Cartao();
            if(existeDefesa(numFAF, idJogo)){
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
