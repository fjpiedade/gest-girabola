/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conectar.coneccao;
import modelo.Pessoa;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Fernando João
 */
public class PessoaDAO {
    
    private Connection con;
    public void adicionarPessoa(Pessoa pessoa){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_pessoa.adicionar_Pessoa ('"+pessoa.getBi()+"','"+pessoa.getNome()+"','"+pessoa.getSexo()+"','"+pessoa.getDataNasc()+"','"+pessoa.getTelefone()+"','"+pessoa.getMorada()+"','"+pessoa.getEmail()+"','"+pessoa.getFoto()+"'); END;");
            st.close();
            con.close();
            //JOptionPane.showMessageDialog(null, "Pessoa Registrada Com Sucesso","Registro de Pessoal", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void removerPessoa(String bi){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_pessoa.eliminar_Pessoa ('"+bi+"'); END;");
            st.close();
            con.close();
            //JOptionPane.showMessageDialog(null,"Pessoa Removida Com Sucesso","Removre Pessoal", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void actualizarPessoa(Pessoa pessoa){
        try {
            con = coneccao.Conectar();
            
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_pessoa.adicionar_Pessoa ('"+pessoa.getBi()+"','"+pessoa.getNome()+"','"+pessoa.getSexo()+"',"+pessoa.getDataNasc()+",'"+pessoa.getTelefone()+"','"+pessoa.getMorada()+"','"+pessoa.getEmail()+"','"+pessoa.getFoto()+"'); END;");
            st.close();
            con.close();
            //JOptionPane.showMessageDialog(null, "Pessoa Actualizada Com Sucesso","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
   
    public boolean existePessoa(String bi) {
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT bi FROM pessoa WHERE bi="+bi);
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public Pessoa obterPessoa(String bi) {
        try {
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM pessoa WHERE bi = "+bi);
            Pessoa pessoa = new Pessoa();
            if(existePessoa(bi)){
                rs.next();
                pessoa.setBi(bi);
                pessoa.setNome(rs.getString(2));
                pessoa.setSexo(rs.getString(3));
                pessoa.setDataNasc(rs.getString(4));
                pessoa.setTelefone(rs.getString(5));
                pessoa.setMorada(rs.getString(6));
                pessoa.setEmail(rs.getString(7));
                pessoa.setFoto(rs.getString(8));
                return pessoa;
            }else{
                JOptionPane.showMessageDialog(null, "O Número do BI Digitado Não Existe.");
            }
        } catch (SQLException ex) {}
        return null;
    }
    
}
