/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conectar.coneccao;
import modelo.Membro;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Fernando João
 */
public class MembroDAO {
    private Connection con;
    public void adicionarMembro(Membro membro){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_membro.adicionar_membro ("+membro.getIdMembro()+",'"+membro.getTipo()+"','"+membro.getObs()+"','"+membro.getBi()+"','"+membro.getIdEquipa()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Membro Registrado Com Sucesso!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public long novoIdMembro(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(idmembro) FROM membro");
            rs.next();
            return rs.getLong(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public void removerMembro(long idMembro){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_membro.eliminar_membro ('"+idMembro+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Membro Eliminado Com Sucesso!"," Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void actualizarMembro(Membro membro){
        try {
            con = coneccao.Conectar();
            
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_membro.actualizar_membro ("+membro.getIdMembro()+",'"+membro.getTipo()+"','"+membro.getObs()+"','"+membro.getBi()+"','"+membro.getIdEquipa()+"'); END;");
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
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM membro WHERE  idequipa="+IdEquipa);
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public Object[][] listarMembro(long IdEquipa){
        //JOptionPane.showMessageDialog(null, IdEquipa+" idEquipa ","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        try {
            int linha=0;
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT membro.idmembro, pessoa.nome, membro.bi, pessoa.telefone, membro.tipo, pessoa.email  FROM membro, pessoa WHERE membro.bi=pessoa.bi AND membro.idequipa="+IdEquipa+" ORDER BY membro.idmembro");
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
    
    public boolean existeMembro(long idMembro) {
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idmembro FROM membro WHERE idmembro="+idMembro);
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public Membro obterMembro(long idMembro) {
        try {
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM membro WHERE idmembro = "+idMembro);
            Membro membro = new Membro();
            if(existeMembro(idMembro)){
                rs.next();
                membro.setIdMembro(idMembro);
                membro.setTipo(rs.getString(2));
                membro.setObs(rs.getString(3));
                membro.setBi(rs.getString(4));
                membro.setIdEquipa(rs.getLong(5));
                return membro;
            }else{
                JOptionPane.showMessageDialog(null, "O(a) Membro(a) Digitado Não Existe.");
            }
        } catch (SQLException ex) {}
        return null;
    }
}