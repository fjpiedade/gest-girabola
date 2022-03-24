/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conectar.coneccao;
import modelo.Arbitro;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Fernando João
 */
public class ArbitroDAO {
    private Connection con;
    public void adicionarArbitro(Arbitro arbitro){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_arbitro.adicionar_arbitro ("+arbitro.getIdArbitro()+",'"+arbitro.getTipo()+"','"+arbitro.getClassifcacao()+"','"+arbitro.getBi()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Árbitro Registrado Com Sucesso!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public long novoIdArbitro(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(idarbitro) FROM arbitro");
            rs.next();
            return rs.getLong(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public void removerArbitro(long idArbitro){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_arbitro.eliminar_arbitro ('"+idArbitro+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Árbitro Eliminado Com Sucesso!"," Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void actualizarArbitro(Arbitro arbitro){
        try {
            con = coneccao.Conectar();
            
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_arbitro.actualizar_arbitro ("+arbitro.getIdArbitro()+",'"+arbitro.getTipo()+"','"+arbitro.getClassifcacao()+"','"+arbitro.getBi()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Árbitro Actualizada Com Sucesso","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public int tamanho(){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM arbitro");
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public Object[][] listarArbitro(){
        try {
            int linha=0;
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT arbitro.idarbitro, pessoa.nome, arbitro.bi, pessoa.telefone, pessoa.email  FROM arbitro, pessoa WHERE arbitro.bi=pessoa.bi ORDER BY arbitro.idarbitro");
            Object[][] dados = new Object[tamanho()][5];
            while(rs.next()){
                dados[linha][0] = rs.getLong(1);//rs.getLong("socio.idutilizador")
                dados[linha][1] = rs.getString(2);//rs.getString("pessoa.nome")
                dados[linha][2] = rs.getString(3);//rs.getString("socio.bi")
                dados[linha][3] = rs.getString(4);//rs.getString("pessoa.telefone")
                dados[linha++][4] = rs.getString(5);//rs.getString("pessoa.email")
            }
            return dados;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    public boolean existeArbitro(long idArbitro) {
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idarbitro FROM arbitro WHERE idarbitro="+idArbitro);
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public Arbitro obterArbitro(long idArbitro) {
        try {
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM arbitro WHERE idarbitro = "+idArbitro);
            Arbitro arbitro = new Arbitro();
            if(existeArbitro(idArbitro)){
                rs.next();
                arbitro.setIdArbitro(idArbitro);
                arbitro.setTipo(rs.getString(2));
                arbitro.setClassifcacao(rs.getString(3));
                arbitro.setBi(rs.getString(4));
                return arbitro;
            }else{
                JOptionPane.showMessageDialog(null, "O Arbitro Digitado Não Existe.");
            }
        } catch (SQLException ex) {}
        return null;
    }
    
}
