/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conectar.coneccao;
import java.sql.*;
import javax.swing.*;
import modelo.Jornada;
import modelo.Campeonato;

/**
 *
 * @author Fernando João
 */
public class JornadaDAO {
    private Connection con;
    public void adicionarJornada(Jornada jornada){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_jornada.adicionar_jornada ('"+jornada.getNumJornada()+"','"+jornada.getIdEquipaVisitada()+"','"+jornada.getIdEquipaVisitante()+"','"+jornada.getEstadoJogo()+"','"+jornada.getIdCampeonato()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Jornada Registrado Com Sucesso!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
      
    public void removerJornada(long idCampeonato){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_jornada.eliminar_jornada ('"+idCampeonato+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null,"Campeonato Eliminado Com Sucesso!"," Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void actualizarJornada(Jornada jornada){
        try {
            con = coneccao.Conectar();
            
            Statement st= con.createStatement();
            st.executeUpdate("DECLARE BEGIN pack_campeonato.actualizar_campeonato ('"+jornada.getNumJornada()+"','"+jornada.getIdEquipaVisitada()+"','"+jornada.getIdEquipaVisitante()+"','"+jornada.getEstadoJogo()+"','"+jornada.getIdCampeonato()+"'); END;");
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Campeonato Actualizada Com Sucesso","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public int tamanho(long idCampeonato){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM jornada WHERE idCampeonato="+idCampeonato);
            rs.next();
            return rs.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public Object[][] listarJornada(long idCampeonato){
        try {
            int linha=0;
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT numjornada, (SELECT nome FROM clube WHERE numidfiscal=(SELECT numidfiscal FROM equipa WHERE equipa.idequipa=jornada.Visitado)), (SELECT nome FROM clube WHERE numidfiscal=(SELECT numidfiscal FROM equipa WHERE equipa.idequipa=jornada.Visitante)), estado FROM jornada WHERE idcampeonato="+idCampeonato+" ORDER BY numjornada");
            Object[][] dados = new Object[tamanho(idCampeonato)][4];
            while(rs.next()){
                dados[linha][0] = rs.getLong(1);//rs.getLong("socio.idutilizador")
                dados[linha][1] = rs.getString(2);//rs.getString("pessoa.nome")
                dados[linha][2] = rs.getString(3);//rs.getString("pessoa.nome")
                dados[linha++][3] = rs.getString(4);//rs.getString("pessoa.email")
            }
            return dados;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    public boolean existeJornada(long idCampeonato) {
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idCampeonato FROM campeonato WHERE idcampeonato="+idCampeonato);
            while(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    public Campeonato obterJornada(long idCampeonato) {
        try {
            con = coneccao.Conectar(); //cria a conecao com a BD
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Campeonato WHERE idCampeonato = "+idCampeonato);
            Campeonato campeonato = new Campeonato();
            if(existeJornada(idCampeonato)){
                rs.next();
                campeonato.setIdCampeonato(idCampeonato);
                campeonato.setDescricao(rs.getString(3));
                campeonato.setAno(rs.getLong(4));
                
                return campeonato;
            }else{
                JOptionPane.showMessageDialog(null, "O Campeonato Digitado Não Existe.");
            }
        } catch (SQLException ex) {}
        return null;
    }
}
