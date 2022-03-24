/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conectar.coneccao;
import modelo.Jogador;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Fernando João
 */
public class JogadorDAO {
    private Connection con;
    public void adicionarJogador(Jogador jogador){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_jogador.adicionar_jogador ("+jogador.getNumFAF()+",'"+jogador.getPosicao()+"','"+jogador.getBi()+"','"+jogador.getIdEquipa()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Jogador Registrado Com Sucesso!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public long novoNumFAF(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(numfaf) FROM jogador");
            rs.next();
            return rs.getLong(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public void removerJogador(long numFAF){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_jogador.eliminar_jogador ('"+numFAF+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Jogador Eliminado Com Sucesso!"," Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void actualizarJogador(Jogador jogador){
        try {
            con = coneccao.Conectar();
            
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_jogador.actualizar_jogador ("+jogador.getNumFAF()+",'"+jogador.getPosicao()+"','"+jogador.getBi()+"','"+jogador.getIdEquipa()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Membro Actualizado Com Sucesso","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public int tamanho(long IdEquipa){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM jogador WHERE  idequipa="+IdEquipa);
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public Object[][] listarJogador(long IdEquipa){
        //JOptionPane.showMessageDialog(null, IdEquipa+" idEquipa ","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        try {
            int linha=0;
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT jogador.numfaf, pessoa.nome, jogador.bi, pessoa.telefone, jogador.posicao, pessoa.email  FROM jogador, pessoa WHERE jogador.bi=pessoa.bi AND jogador.idequipa="+IdEquipa+" ORDER BY jogador.numfaf");
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
    
    public boolean existeJogador(long numFAF) {
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT numfaf FROM jogador WHERE numfaf="+numFAF);
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public Jogador obterJogador(long numFAF) {
        try {
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM jogador WHERE numfaf = "+numFAF);
            Jogador jogador = new Jogador();
            if(existeJogador(numFAF)){
                rs.next();
                jogador.setNumFAF(numFAF);
                jogador.setPosicao(rs.getString(2));
                jogador.setBi(rs.getString(3));
                jogador.setIdEquipa(rs.getLong(4));
                return jogador;
            }else{
                JOptionPane.showMessageDialog(null, "O(a) Jogador(a) Digitado Não Existe.");
            }
        } catch (SQLException ex) {}
        return null;
    }
}
