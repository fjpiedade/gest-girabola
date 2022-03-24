/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmCriarCampeonatos.java
 *
 * Created on 10/11/2011, 15:18:31
 */
package view;

import java.sql.*;
import conectar.coneccao;

import java.awt.Color;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Calendar;

import java.util.Random;

import dao.CampeonatoDAO;
import dao.JornadaDAO;
import dao.ClubeDAO;
import dao.EquipaDAO;


import modelo.Campeonato;
import modelo.Jornada;
import modelo.Clube;
import modelo.Equipa;

import modelo.jornadaJogos;
import modelo.jornadasEscolhidos;



/**
 *
 * @author Fernando João
 */
public class frmCriarCampeonatos extends javax.swing.JDialog {

    /** Creates new form frmCriarCampeonatos */
    private static Connection con;
    
    ClubeDAO daoClube = new ClubeDAO();
    
    EquipaDAO daoEquipa = new EquipaDAO();
        
    Calendar hora,data;
    DecimalFormat formato;
    
    int HH,MM,SS;
    int dia,mes,ano;
    
    CampeonatoDAO daoCampeonato = new CampeonatoDAO();
    JornadaDAO daoJornada = new JornadaDAO();
    EquipaDAO daoEquipaExistente = new EquipaDAO();
    
    jornadasEscolhidos novaJornada=new jornadasEscolhidos();
    
    private ArrayList clubeEscolhido = new ArrayList();
    private ArrayList jogoJornada = new ArrayList();
    
    private String[] cabecalho_Equipa = {"Clube", "Inicias", "Equipa"};
        
    public frmCriarCampeonatos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    public void actualizaTabelaEquipaExistente(){
        tabela_ClubesExistente.setModel(new DefaultTableModel(daoEquipaExistente.listarEquipaCampeonato(), cabecalho_Equipa));
    }
    
    public void preencherComboAno(){
        data=Calendar.getInstance();
        dia=data.get(Calendar.DAY_OF_MONTH);
        mes=data.get(Calendar.MONTH);
        ano=data.get(Calendar.YEAR);
        //String data_Criado=(dia+"/"+mes+"/"+ano);
        
        long anoActual=ano+4;
        long i;
        
        for(i=anoActual; i>=1000;i--){
            cbo_AnoRealizado.addItem(i);  
        }
    }
    
    public void setIDCampeonato(){
        long idCampeonato= new CampeonatoDAO().novoIdCampeonato()+1;
        lbl_idCampeonato.setText(""+idCampeonato+"");
    }
    
    public void adicionarJogoJornada(long numJornada, String clubeCasa, String clubeVisita, String estadoJogo,long idCapeonato){//Metodo para eliminar um artista desejado	
        jornadaJogos novoJogo= new jornadaJogos(numJornada, clubeCasa, clubeVisita, estadoJogo, idCapeonato);
        jogoJornada.add(novoJogo);
    }
    
    public boolean verificarJogo(ArrayList dadosClube, String Casa, String Visita, long numJornada){//Metodo para eliminar um artista desejado	
	for(int j=0;j<dadosClube.size();j++){
            jornadaJogos baseTeste =(jornadaJogos) dadosClube.get(j);	
            if(baseTeste.getClubeCasa().equals(Casa) && baseTeste.getClubeVisita().equals(Visita) && baseTeste.getNumJornada()==numJornada){
                return true;				
            }
            if(baseTeste.getClubeVisita().equals(Casa) && baseTeste.getClubeCasa().equals(Visita) && baseTeste.getNumJornada()==numJornada){
                return true;
            }
	}
        return false;
    }
    
    public void actualizarJogosJornada(ArrayList dadosClube){
        //DefaultTableModel model_TabelaEscolhidos = (javax.swing.table.DefaultTableModel)tabela_ClubesEscolhidos.getModel();
        
        javax.swing.table.DefaultTableModel model_Jornada = (javax.swing.table.DefaultTableModel)tabela_Jornada.getModel();
        //JOptionPane.showMessageDialog(null, model_TabelaEscolhidos.getRowCount(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        
        for(int i = tabela_Jornada.getRowCount()-1; i >= 0; --i)
            model_Jornada.removeRow(i);
        
        for(int cont=0;cont<dadosClube.size();cont++){
            jornadaJogos baseTeste =(jornadaJogos) dadosClube.get(cont);
            model_Jornada.addRow(new Object[]{""+baseTeste.getNumJornada()+"",""+baseTeste.getClubeCasa()+"",""+baseTeste.getClubeVisita()+""});
        }
    }
    
    public void trocarJogosJornada(ArrayList dadosClube, long numJornada, int numClubes){
        long numJornada1;
        String clubeCas;
        String clubvisit;
        String estadoJog="Aberto";
        int cont=0;
        int contP=0;
        
        long idCampeonato= Long.parseLong( lbl_idCampeonato.getText());
        
        for(long t=(numJornada/2)+1; t<=numJornada; t++){  
                
            for(cont=contP;cont<(contP+(numClubes/2));cont++){
                jornadaJogos baseTeste =(jornadaJogos) dadosClube.get(cont);
                    
                clubvisit=baseTeste.getClubeCasa();
                clubeCas=baseTeste.getClubeVisita();
                adicionarJogoJornada(t, clubeCas, clubvisit, estadoJog, idCampeonato);
            }
                //actualizarJogosJornada(jogoJornada);   
                contP=contP+(numClubes/2);
        }
    
    }
    
    public void adicionarClube(String nomeClube, String iniciasClube, long idEquipa){//Metodo para eliminar um artista desejado	
        jornadasEscolhidos novoClube= new jornadasEscolhidos(nomeClube, iniciasClube, idEquipa);
        clubeEscolhido.add(novoClube);
    }
    
    public void removerClube(ArrayList dadosClube,long idEquipa){//Metodo para eliminar um artista desejado	
	for(int cont=0;cont<dadosClube.size();cont++){
            jornadasEscolhidos baseTeste =(jornadasEscolhidos) dadosClube.get(cont);	
            if(baseTeste.getIdEquipa()==idEquipa){
                dadosClube.remove(cont);
                break;
            }
	}
    }
    
    public void actualizarClubesEscolhidos(ArrayList dadosClube){
        //DefaultTableModel model_TabelaEscolhidos = (javax.swing.table.DefaultTableModel)tabela_ClubesEscolhidos.getModel();
        
        javax.swing.table.DefaultTableModel model_TabelaEscolhidos = (javax.swing.table.DefaultTableModel)tabela_ClubesEscolhidos.getModel();
        //JOptionPane.showMessageDialog(null, model_TabelaEscolhidos.getRowCount(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        
        for(int i = tabela_ClubesEscolhidos.getRowCount()-1; i >= 0; --i)
            model_TabelaEscolhidos.removeRow(i);
        
        for(int cont=0;cont<dadosClube.size();cont++){
            jornadasEscolhidos baseTeste =(jornadasEscolhidos) dadosClube.get(cont);
            model_TabelaEscolhidos.addRow(new Object[]{""+baseTeste.getNomeClube()+"",""+baseTeste.getIniciasClube()+"",""+baseTeste.getIdEquipa()+""});
        }
    }
    
    public boolean verificarClube(ArrayList dadosClube,long idEquipa){//Metodo para eliminar um artista desejado	
	for(int j=0;j<dadosClube.size();j++){
            jornadasEscolhidos baseTeste =(jornadasEscolhidos) dadosClube.get(j);	
            if(baseTeste.getIdEquipa()==idEquipa){
                return true;				
            }
	}
        return false;
    }
    
    public long numIDFiscal(String nomeClube){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT numidfiscal FROM clube WHERE nome='"+nomeClube+"'");
            //ResultSet rs = st.executeQuery("SELECT numidfiscal FROM clube WHERE  idequipa="+IdEquipa);
            rs.next();
            return rs.getLong(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol - NomeClube", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    public long idEquipaClube(long numDFiscal){
        try {
            con = coneccao.Conectar();
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT idequipa FROM equipa WHERE numidfiscal="+numDFiscal);
            rs.next();
            return rs.getLong(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Campeonato Angolano de Futebol - IdEquipa", JOptionPane.INFORMATION_MESSAGE);
        }
        return 0;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        bt_Concluir = new javax.swing.JButton();
        bt_Cancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txt_Descricao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbo_AnoRealizado = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txt_NumClubes = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_ClubesExistente = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabela_ClubesEscolhidos = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        bt_Adicionar = new javax.swing.JButton();
        bt_Remover = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabela_Jornada = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        bt_OpcaoUm = new javax.swing.JButton();
        bt_OpaoDois = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbl_idCampeonato = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 11));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Criar Campeonatos © 2011");
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12), new java.awt.Color(204, 204, 255))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Campeonato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 18), new java.awt.Color(204, 204, 255))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Trebuchet MS", 0, 18));
        jPanel3.setOpaque(false);
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel3MouseMoved(evt);
            }
        });

        bt_Concluir.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        bt_Concluir.setText("Concluir");
        bt_Concluir.setEnabled(false);
        bt_Concluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ConcluirActionPerformed(evt);
            }
        });

        bt_Cancelar.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        bt_Cancelar.setText("Cancelar");
        bt_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_CancelarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Campeonato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setFont(new java.awt.Font("Trebuchet MS", 0, 18));
        jPanel4.setOpaque(false);
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel4MouseMoved(evt);
            }
        });

        txt_Descricao.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txt_Descricao.setText("Girabola");
        txt_Descricao.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        jLabel8.setText("Descrição");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        jLabel9.setText("Ano Realizado");

        cbo_AnoRealizado.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        cbo_AnoRealizado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o Ano" }));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 18));
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("*");

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 18));
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("*");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbo_AnoRealizado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(cbo_AnoRealizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados dos Clubes Para o Campeonato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel5.setFont(new java.awt.Font("Trebuchet MS", 0, 18));
        jPanel5.setOpaque(false);
        jPanel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel5MouseMoved(evt);
            }
        });

        txt_NumClubes.setFont(new java.awt.Font("Trebuchet MS", 0, 14));

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        jLabel12.setText("Nº de Clubes");

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 1, 18));
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("*");

        tabela_ClubesExistente.setFont(new java.awt.Font("Trebuchet MS", 0, 10));
        tabela_ClubesExistente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Clube", "Inicias", "Equipa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_ClubesExistente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tabela_ClubesExistente);

        tabela_ClubesEscolhidos.setFont(new java.awt.Font("Trebuchet MS", 0, 10));
        tabela_ClubesEscolhidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clube", "Inicias", "Equipa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_ClubesEscolhidos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(tabela_ClubesEscolhidos);

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        jLabel13.setText("Clubes Existentes");

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        jLabel14.setText("Clubes Escolhidos");

        bt_Adicionar.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        bt_Adicionar.setText(">>>");
        bt_Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_AdicionarActionPerformed(evt);
            }
        });

        bt_Remover.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        bt_Remover.setText("<<<");
        bt_Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_RemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_NumClubes, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bt_Adicionar)
                                    .addComponent(bt_Remover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_NumClubes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(bt_Adicionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                                .addComponent(bt_Remover))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jornadas do Campeonato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel6.setFont(new java.awt.Font("Trebuchet MS", 0, 18));
        jPanel6.setOpaque(false);
        jPanel6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel6MouseMoved(evt);
            }
        });

        tabela_Jornada.setFont(new java.awt.Font("Trebuchet MS", 0, 10));
        tabela_Jornada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº Jornada", "Clube Visitado", "Clube Visitante"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tabela_Jornada);

        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        jLabel18.setText("Listas de Jogos das Respectivas Jornadas");

        bt_OpcaoUm.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        bt_OpcaoUm.setText("1ª Opção - Gerar Jogos das Jornadas Automáticamente");
        bt_OpcaoUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_OpcaoUmActionPerformed(evt);
            }
        });

        bt_OpaoDois.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        bt_OpaoDois.setText("2ª Opção - Inserir Jogos das Jornadas Manualmente");
        bt_OpaoDois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_OpaoDoisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(bt_OpcaoUm)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bt_OpaoDois, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(bt_OpcaoUm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_OpaoDois))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(bt_Concluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_Cancelar)
                    .addComponent(bt_Concluir)))
        );

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 11));
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ID Campeonato >>");
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12), new java.awt.Color(204, 204, 255))); // NOI18N

        lbl_idCampeonato.setFont(new java.awt.Font("Trebuchet MS", 0, 11));
        lbl_idCampeonato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_idCampeonato.setText("ID Campeonato >>");
        lbl_idCampeonato.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12), new java.awt.Color(204, 204, 255))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_idCampeonato)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(lbl_idCampeonato))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseMoved

    }//GEN-LAST:event_jPanel3MouseMoved

    private void jPanel4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseMoved

        // TODO add your handling code here:}//GEN-LAST:event_jPanel4MouseMoved
    }
        private void jPanel5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseMoved

    private void jPanel6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel6MouseMoved

    private void bt_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_CancelarActionPerformed
        // TODO add your handling code here:
        this.hide();
    }//GEN-LAST:event_bt_CancelarActionPerformed

    private void bt_OpaoDoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_OpaoDoisActionPerformed
        // TODO add your handling code here:
               
        String clubeCasa   []={null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
        String clubeVisita []={null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
        
        String numClubes1=txt_NumClubes.getText();
           
        if (!numClubes1.isEmpty()){
            
            long numClub=Long.parseLong(txt_NumClubes.getText());
            if(numClub % 2 == 0){
                if (Long.parseLong(txt_NumClubes.getText())==tabela_ClubesEscolhidos.getRowCount()){

                    long numClubes=Long.parseLong(txt_NumClubes.getText());
                    long numJornadas=(numClubes*2)-2;

                    for(int j=0;j<clubeEscolhido.size();j++){
                        jornadasEscolhidos baseTeste =(jornadasEscolhidos) clubeEscolhido.get(j);	
                        //JOptionPane.showInputDialog(null,""+baseTeste.getNomeClube()+"", "Jornada - Apenas 1ª Mão", JOptionPane.INFORMATION_MESSAGE, null, clubeCasa,clubeCasa[0]);
                        clubeCasa[j]=""+baseTeste.getNomeClube()+"";
                        clubeVisita[j]=""+baseTeste.getNomeClube()+"";
                    }

                    for(long k=1; k<=(numJornadas/2); k++){
                        for(long y=1; y<=numClubes/2; y++){
                            Object clubeC=JOptionPane.showInputDialog(null,"Equipa da Casa", ""+ y +"º Jogo da "+ k +"ª Jornada Campeonato Angolano de Futebol - Apenas 1ª Mão", JOptionPane.INFORMATION_MESSAGE, null, clubeCasa,clubeCasa[0]);
                            //JOptionPane.showMessageDialog(null,"Voçê Escolheu o Membro "+ clubeC);

                            Object clubeV=JOptionPane.showInputDialog(null,"Equipa Visita", ""+ y +"º Jogo da "+ k +"ª Jornada Campeonato Angolano de Futebol - Apenas 1ª Mão", JOptionPane.INFORMATION_MESSAGE, null, clubeVisita,clubeVisita[0]);
                            //JOptionPane.showMessageDialog(null,"Voçê Escolheu o Membro "+ clubeV);

                            long numJornada  = k;
                            String clubeCas  = clubeC.toString();
                            String clubevisit = clubeV.toString();
                            String estadoJog ="Aberto";
                            long idCampeonato= Long.parseLong( lbl_idCampeonato.getText());

                            adicionarJogoJornada(numJornada, clubeCas, clubevisit, estadoJog, idCampeonato);
                           // actualizarJogosJornada(jogoJornada);

                        }
                    }

                    int numClu=Integer.parseInt(txt_NumClubes.getText());

                    trocarJogosJornada(jogoJornada, numJornadas, numClu);

                    actualizarJogosJornada(jogoJornada);

                    bt_OpaoDois.setEnabled(false);
                    bt_OpcaoUm.setEnabled(false);
                    txt_NumClubes.setEnabled(false);
                    bt_Concluir.setEnabled(true);

                    JOptionPane.showMessageDialog(null, "Jornada Criado Com Sucesso!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Informe Todos os Clubes Participante no Campeonato!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
                }
            
            }else{
                JOptionPane.showMessageDialog(null, "Informe O Número de Clubes de ser Divisível Por 2 \n Exemplo: 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 \n etc. !","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            }
                
        }
        else{
            JOptionPane.showMessageDialog(null, "Informe o Nº de Clubes Participante no Campeonato!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_bt_OpaoDoisActionPerformed

    private void bt_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_AdicionarActionPerformed
        // TODO add your handling code here:
        if (tabela_ClubesExistente.getSelectedRowCount()==1){
            String numClubes=txt_NumClubes.getText();
            
            if (!numClubes.isEmpty()){
                long numClub=Long.parseLong(txt_NumClubes.getText());
                if(numClub % 2 == 0){
                    if (tabela_ClubesEscolhidos.getRowCount() > Long.parseLong(txt_NumClubes.getText())-1){
                        JOptionPane.showMessageDialog(null, "Verifique o Nº de Clubes Participante do Campeonato!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{

                        String nomeClube = tabela_ClubesExistente.getValueAt(tabela_ClubesExistente.getSelectedRow(),0).toString();
                        String iniciasClube = tabela_ClubesExistente.getValueAt(tabela_ClubesExistente.getSelectedRow(),1).toString();
                        String idEquipa1 = tabela_ClubesExistente.getValueAt(tabela_ClubesExistente.getSelectedRow(),2).toString();
                        long idEquipa= Long.parseLong(idEquipa1);

                        if (verificarClube(clubeEscolhido, idEquipa)==false){
                            adicionarClube(nomeClube, iniciasClube, idEquipa);
                            actualizarClubesEscolhidos(clubeEscolhido);
                        }            
                        else{
                            JOptionPane.showMessageDialog(null, "Clube Seleccionado Ja foi Escolhido!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
                        }   
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Informe O Número de Clubes de ser Divisível Por 2 \n Exemplo: 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 \n etc. !","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
                }
                        
            }else
            {
                JOptionPane.showMessageDialog(null, "Informe o Nº de Clubes Participante no Campeonato!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Seleccione um Clube na Tabela Clubes Existentes!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bt_AdicionarActionPerformed

    private void bt_RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_RemoverActionPerformed
        // TODO add your handling code here:
        if (tabela_ClubesEscolhidos.getSelectedRowCount()==1){
            
            String idEquipa1 = tabela_ClubesEscolhidos.getValueAt(tabela_ClubesEscolhidos.getSelectedRow(),2).toString();
            long idEquipa= Long.parseLong(idEquipa1);
            
            removerClube(clubeEscolhido, idEquipa); 
            
            actualizarClubesEscolhidos(clubeEscolhido);
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Seleccione um Clube na Tabela Clubes Escolhidos!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bt_RemoverActionPerformed

    private void bt_OpcaoUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_OpcaoUmActionPerformed
        // TODO add your handling code here:
        String numClubes=txt_NumClubes.getText();
        
        if (!numClubes.isEmpty()){
            long numClub=Long.parseLong(txt_NumClubes.getText());
            
            if(numClub % 2 == 0){
                
                //JOptionPane.showMessageDialog(null,"Número de Clubes "+ numClub);
                long numJornadas=(numClub*2)-2;
                //JOptionPane.showMessageDialog(null,"Número de Jornada "+ numJornadas);
                ArrayList clubesTemp = new ArrayList();
                
                if (Long.parseLong(txt_NumClubes.getText())==tabela_ClubesEscolhidos.getRowCount()){
                    
                    for(long k=1; k<=(numJornadas/2); k++){
                        
                            for(int i = 0 ; i < numClub ; i++){//Inicializar equipas da jornada
                                clubesTemp.add(clubeEscolhido.get(i));
                            }
                        
                        for(long y=1; y<=numClub/2; y++){
                            boolean jogo_valido = false;
                            Random r = new Random();
                            long cont=0;
                            
                            while(!jogo_valido){
                                int random = r.nextInt(clubesTemp.size());
                                jornadasEscolhidos baseTeste =(jornadasEscolhidos) clubesTemp.get(random);
                                String nomClu1=baseTeste.getNomeClube();
                                Object home = clubesTemp.get(random);
                                clubesTemp.remove(home);
                                //JOptionPane.showMessageDialog(null,"Clube da Casa "+ nomClu1);

                                int rando = r.nextInt(clubesTemp.size());
                                jornadasEscolhidos baseTeste1 =(jornadasEscolhidos) clubesTemp.get(rando);
                                String nomClu2=baseTeste1.getNomeClube();
                                Object visitante = clubesTemp.get(rando);
                                clubesTemp.remove(visitante);
                                //JOptionPane.showMessageDialog(null,"Clube Visitante "+ nomClu2);
                                

                                String clubeCas  = nomClu1;
                                String clubevisit = nomClu2;
                                
                                if(verificarJogo(jogoJornada, clubeCas, clubevisit,k)){
                                    cont++;
                                    clubesTemp.add(home);
                                    clubesTemp.add(visitante);
                                    //JOptionPane.showMessageDialog(null,"Parei Aqui "+ clubesTemp.size());
                                    //jogo_valido = true;
                                    if(clubesTemp.size()==2 && cont>5 || clubesTemp.size()==4 && cont>5 ){
                                        jogo_valido = true;
                                        break;
                                    }
                                    
                                    System.out.print("Pareis "+clubesTemp.size());
                                    System.out.print("\n");
                                    System.out.print("Cont "+cont);
                                    System.out.print("\n");
                                    continue; 
                                }
                                
                                long numJornada  = k;
                                String estadoJog ="Aberto";
                                long idCampeonato= Long.parseLong( lbl_idCampeonato.getText());
                                adicionarJogoJornada(numJornada, clubeCas, clubevisit, estadoJog, idCampeonato);
                                jogo_valido = true;
                               
                                //JOptionPane.showMessageDialog(null,"Jogo Número "+ Cont1*k);
                            }
                        }

                    }

                }
                else{
                    JOptionPane.showMessageDialog(null, "Verifique o Nº de Clubes Participante no Campeonato!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
                }

                    int numClu=Integer.parseInt(txt_NumClubes.getText());
                    trocarJogosJornada(jogoJornada, numJornadas, numClu);
                    actualizarJogosJornada(jogoJornada);
                    //JOptionPane.showMessageDialog(null, "Num "+jogoJornada.size(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
                    bt_OpcaoUm.setEnabled(false);
                    bt_OpaoDois.setEnabled(false);
                    txt_NumClubes.setEnabled(false);
                    bt_Concluir.setEnabled(true);

                    JOptionPane.showMessageDialog(null, "Jornada Criada Com Sucesso!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            }else
            {
                JOptionPane.showMessageDialog(null, "Informe Um Número de Clubes Divisível Por 2 \n Exemplo: 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 \n etc. !","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            }
            
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Verifique o Nº de Clubes Participante no Campeonato!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bt_OpcaoUmActionPerformed

    private void bt_ConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ConcluirActionPerformed
        // TODO add your handling code here:
        
        String anoCombo=cbo_AnoRealizado.getSelectedItem().toString();
        
        if (!anoCombo.equals("Selecione o Ano")){
            
            long idCampeonato=Long.parseLong(lbl_idCampeonato.getText());
            String descricao=txt_Descricao.getText();
            long anoRealizado=Long.parseLong(cbo_AnoRealizado.getSelectedItem().toString());
            long numEquip= Long.parseLong(txt_NumClubes.getText());
            
            //Campeonato campeonato= new Campeonato(idCampeonato, descricao, anoRealizado, numEquip);
            //daoCampeonato.adicionarCampeonato(campeonato);
            
            //for(int j=0;j<jogoJornada.size();j++)
            int j=0;
            JOptionPane.showMessageDialog(null, "Tamanho do Jogos >> "+jogoJornada.size(),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            while(j!=jogoJornada.size()){
                jornadaJogos baseTeste =(jornadaJogos) jogoJornada.get(j);	
                
                JOptionPane.showMessageDialog(null, "Tamanho do Jogos >> "+ (j+1),"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
                
                long numJo = baseTeste.getNumJornada();
                String clubeCasa = baseTeste.getClubeCasa();
                String clubeVisitante = baseTeste.getClubeVisita();
                String estado = baseTeste.getEstadoJogo();
                long idCamp = baseTeste.getIdCampeonato();
                
                JOptionPane.showMessageDialog(null, clubeCasa+" "+clubeVisitante,"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
                
                long numIdFiscalCasa=numIDFiscal(clubeCasa);
                long numIdFiscalVisita=numIDFiscal(clubeVisitante);
                JOptionPane.showMessageDialog(null, numIdFiscalCasa+" "+numIdFiscalVisita,"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);

                //long idEquipaCasa=idEquipaClube(numIdFiscalCasa);
                //long idEquipaVisita=idEquipaClube(numIdFiscalVisita);
                //JOptionPane.showMessageDialog(null, idEquipaCasa+" "+idEquipaVisita,"Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
                j=j+1;
                //Jornada jornada= new Jornada(numJo, idEquipaCasa, idEquipaVisita, estado, idCamp);
                //daoJornada.adicionarJornada(jornada);
                    		
                //long numJornada, long idEquipaVisitada, long idEquipaVisitante, String estadoJogo, long idCampeonato;
            }
            
            this.hide();
        }
        else{
            JOptionPane.showMessageDialog(null, "Verifique o Ano a Realizar o Campeonato!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_bt_ConcluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmCriarCampeonatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCriarCampeonatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCriarCampeonatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCriarCampeonatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmCriarCampeonatos dialog = new frmCriarCampeonatos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Adicionar;
    private javax.swing.JButton bt_Cancelar;
    private javax.swing.JButton bt_Concluir;
    private javax.swing.JButton bt_OpaoDois;
    private javax.swing.JButton bt_OpcaoUm;
    private javax.swing.JButton bt_Remover;
    private javax.swing.JComboBox cbo_AnoRealizado;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_idCampeonato;
    private javax.swing.JTable tabela_ClubesEscolhidos;
    private javax.swing.JTable tabela_ClubesExistente;
    private javax.swing.JTable tabela_Jornada;
    private javax.swing.JTextField txt_Descricao;
    private javax.swing.JTextField txt_NumClubes;
    // End of variables declaration//GEN-END:variables
}
