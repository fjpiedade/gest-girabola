/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmClubes.java
 *
 * Created on 10/10/2011, 07:23:09
 */
package view;

import dao.ClubeDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fernando João
 */
public class frmClubes extends javax.swing.JDialog {
    
    
    ClubeDAO daoClube = new ClubeDAO();
             
    private String[] cabecalho = {"Número de Identificação Fiscal", "Nome", "Inicias", "Capital Social", "Situação Fiscal","Telefone Sede"};
    
    /** Creates new form frmClubes */
    public frmClubes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    frmClubes() {
        
    }
     
       
    public void actualizaTabela(){
        Tabela.setModel(new DefaultTableModel(daoClube.listarClube(), cabecalho));
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
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txt_nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        lbl_Procurar = new javax.swing.JLabel();
        bt_Adicionar = new javax.swing.JButton();
        bt_Editar = new javax.swing.JButton();
        bt_Remover = new javax.swing.JButton();
        lbl_verJogadores = new javax.swing.JLabel();
        lbl_verTreinadores = new javax.swing.JLabel();
        lbl_verMembros = new javax.swing.JLabel();
        bt_Remover1 = new javax.swing.JButton();

        setModal(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/finalBainer.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Clubes © 2011", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 18), new java.awt.Color(204, 204, 255))); // NOI18N
        jPanel3.setFont(new java.awt.Font("Trebuchet MS", 0, 18));
        jPanel3.setOpaque(false);
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel3MouseMoved(evt);
            }
        });

        txt_nome.setFont(new java.awt.Font("Trebuchet MS", 0, 14));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        jLabel3.setText("Código");

        Tabela.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Número de Identificação Fiscal", "Nome", "Inicias", "Capital Social", "Situação Fiscal", "Telefone Sede"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabela);

        lbl_Procurar.setBackground(new java.awt.Color(204, 204, 255));
        lbl_Procurar.setFont(new java.awt.Font("Trebuchet MS", 0, 11));
        lbl_Procurar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Procurar.setText("Buscar");
        lbl_Procurar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12), new java.awt.Color(204, 204, 255))); // NOI18N
        lbl_Procurar.setOpaque(true);
        lbl_Procurar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ProcurarMouseClicked(evt);
            }
        });
        lbl_Procurar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_ProcurarMouseMoved(evt);
            }
        });

        bt_Adicionar.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        bt_Adicionar.setText("Adicionar");
        bt_Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_AdicionarActionPerformed(evt);
            }
        });

        bt_Editar.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        bt_Editar.setText("Editar");

        bt_Remover.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        bt_Remover.setText("Remover");

        lbl_verJogadores.setBackground(new java.awt.Color(204, 204, 255));
        lbl_verJogadores.setFont(new java.awt.Font("Trebuchet MS", 0, 11));
        lbl_verJogadores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_verJogadores.setText("Ver Jogadores");
        lbl_verJogadores.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12), new java.awt.Color(204, 204, 255))); // NOI18N
        lbl_verJogadores.setOpaque(true);
        lbl_verJogadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_verJogadoresMouseClicked(evt);
            }
        });
        lbl_verJogadores.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_verJogadoresMouseMoved(evt);
            }
        });

        lbl_verTreinadores.setBackground(new java.awt.Color(204, 204, 255));
        lbl_verTreinadores.setFont(new java.awt.Font("Trebuchet MS", 0, 11));
        lbl_verTreinadores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_verTreinadores.setText("Ver Treinadores");
        lbl_verTreinadores.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12), new java.awt.Color(204, 204, 255))); // NOI18N
        lbl_verTreinadores.setOpaque(true);
        lbl_verTreinadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_verTreinadoresMouseClicked(evt);
            }
        });
        lbl_verTreinadores.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_verTreinadoresMouseMoved(evt);
            }
        });

        lbl_verMembros.setBackground(new java.awt.Color(204, 204, 255));
        lbl_verMembros.setFont(new java.awt.Font("Trebuchet MS", 0, 11));
        lbl_verMembros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_verMembros.setText("Ver Membros");
        lbl_verMembros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12), new java.awt.Color(204, 204, 255))); // NOI18N
        lbl_verMembros.setOpaque(true);
        lbl_verMembros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_verMembrosMouseClicked(evt);
            }
        });
        lbl_verMembros.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_verMembrosMouseMoved(evt);
            }
        });

        bt_Remover1.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        bt_Remover1.setText("Detalhes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(bt_Adicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Remover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Remover1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_Procurar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_verTreinadores, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_verMembros, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(lbl_verJogadores, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lbl_Procurar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_verJogadores, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_verTreinadores, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_verMembros, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_Adicionar)
                    .addComponent(bt_Editar)
                    .addComponent(bt_Remover)
                    .addComponent(bt_Remover1))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 792, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_ProcurarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ProcurarMouseClicked

    }//GEN-LAST:event_lbl_ProcurarMouseClicked

    private void lbl_ProcurarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ProcurarMouseMoved
        lbl_Procurar.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_lbl_ProcurarMouseMoved

    private void lbl_verJogadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_verJogadoresMouseClicked
        String nomeClube=null;
        String numIdFiscal=null;
        long idEquipa=0;
                
        if (Tabela.getSelectedRowCount()==1){
            
            //JOptionPane.showMessageDialog(null, "Peguei","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
             
            //String valorSelecionado = Tabela.getValueAt(Tabela.getSelectedRow(),0).toString();
            //JOptionPane.showMessageDialog(null, valorSelecionado+"","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            
            nomeClube= Tabela.getValueAt(Tabela.getSelectedRow(),1).toString();
            numIdFiscal=Tabela.getValueAt(Tabela.getSelectedRow(),0).toString();
            
            //JOptionPane.showMessageDialog(null, nomeClube+" nomeClube","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            //JOptionPane.showMessageDialog(null, numIdFiscal+" numIFiscal","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            
            idEquipa= daoClube.obterEquipaClube( Long.parseLong(numIdFiscal));
            
            //JOptionPane.showMessageDialog(null, idEquipa+" idEquipa ","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            
            frmJogadores Chamar =new frmJogadores(new javax.swing.JFrame(), true);
            Chamar.setClubeEquipa(nomeClube, idEquipa);
            Chamar.actualizaTabela(idEquipa);
            Chamar.setVisible(true);              
        
        }
        else{
            JOptionPane.showMessageDialog(null, "Seleccione um Clube!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_lbl_verJogadoresMouseClicked

    private void lbl_verJogadoresMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_verJogadoresMouseMoved
        lbl_verJogadores.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_lbl_verJogadoresMouseMoved

    private void jPanel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseMoved
        // TODO add your handling code here:
        lbl_Procurar.setBackground(new java.awt.Color(204, 204, 255));
        lbl_verJogadores.setBackground(new java.awt.Color(204, 204, 255));
        lbl_verTreinadores.setBackground(new java.awt.Color(204, 204, 255));
        lbl_verMembros.setBackground(new java.awt.Color(204, 204, 255));
    }//GEN-LAST:event_jPanel3MouseMoved

    private void bt_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_AdicionarActionPerformed
        // TODO add your handling code here:
        frmAddClube Chamar =new frmAddClube(new javax.swing.JFrame(), true);
                Chamar.setVisible(true);
    }//GEN-LAST:event_bt_AdicionarActionPerformed

    private void lbl_verTreinadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_verTreinadoresMouseClicked
/*
        frmHistorialJogadores Chamar = new frmHistorialJogadores(new javax.swing.JFrame(), true);         Chamar.setVisible(true);     }//GEN-LAST:event_lbl_verTreinadoresMouseClicked
*/      
        String nomeClube=null;
        String numIdFiscal=null;
        long idEquipa=0;
                
        if (Tabela.getSelectedRowCount()==1){
            
            //JOptionPane.showMessageDialog(null, "Peguei","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
             
            //String valorSelecionado = Tabela.getValueAt(Tabela.getSelectedRow(),0).toString();
            //JOptionPane.showMessageDialog(null, valorSelecionado+"","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            
            nomeClube= Tabela.getValueAt(Tabela.getSelectedRow(),1).toString();
            numIdFiscal=Tabela.getValueAt(Tabela.getSelectedRow(),0).toString();
            
            //JOptionPane.showMessageDialog(null, nomeClube+" nomeClube","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            //JOptionPane.showMessageDialog(null, numIdFiscal+" numIFiscal","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            
            idEquipa= daoClube.obterEquipaClube( Long.parseLong(numIdFiscal));
            
            //JOptionPane.showMessageDialog(null, idEquipa+" idEquipa ","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            
            frmTreinadores chamarTreinadores = new frmTreinadores(new javax.swing.JFrame(), true);
            chamarTreinadores.setClubeEquipa(nomeClube, idEquipa);
            chamarTreinadores.actualizaTabela(idEquipa);
            chamarTreinadores.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Seleccione um Clube!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
        
    }
    private void lbl_verTreinadoresMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_verTreinadoresMouseMoved
    
        lbl_verTreinadores.setBackground(new java.awt.Color(255, 255, 255));
        /*
        lbl_verHistorial.setBackground(new java.awt.Color(255, 255, 255));     }//GEN-LAST:event_lbl_verTreinadoresMouseMoved
*/
    }
    private void lbl_verMembrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_verMembrosMouseClicked
        // TODO add your handling code here:
        String nomeClube=null;
        String numIdFiscal=null;
        long idEquipa=0;
                
        if (Tabela.getSelectedRowCount()==1){
            
            //JOptionPane.showMessageDialog(null, "Peguei","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
             
            //String valorSelecionado = Tabela.getValueAt(Tabela.getSelectedRow(),0).toString();
            //JOptionPane.showMessageDialog(null, valorSelecionado+"","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            
            nomeClube= Tabela.getValueAt(Tabela.getSelectedRow(),1).toString();
            numIdFiscal=Tabela.getValueAt(Tabela.getSelectedRow(),0).toString();
            
            //JOptionPane.showMessageDialog(null, nomeClube+" nomeClube","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            //JOptionPane.showMessageDialog(null, numIdFiscal+" numIFiscal","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            
            idEquipa= daoClube.obterEquipaClube( Long.parseLong(numIdFiscal));
            
            //JOptionPane.showMessageDialog(null, idEquipa+" idEquipa ","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
            
            frmMembros Chamar = new frmMembros(new javax.swing.JFrame(), true);  
            Chamar.setClubeEquipa(nomeClube, idEquipa);
            Chamar.actualizaTabela(idEquipa);
            Chamar.setVisible(true);              
        
        }
        else{
            JOptionPane.showMessageDialog(null, "Seleccione um Clube!","Campeonato Angolano de Futebol", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_lbl_verMembrosMouseClicked

    private void lbl_verMembrosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_verMembrosMouseMoved
        // TODO add your handling code here:
        lbl_verMembros.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_lbl_verMembrosMouseMoved

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
            java.util.logging.Logger.getLogger(frmClubes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmClubes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmClubes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmClubes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frmClubes dialog = new frmClubes(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable Tabela;
    private javax.swing.JButton bt_Adicionar;
    private javax.swing.JButton bt_Editar;
    private javax.swing.JButton bt_Remover;
    private javax.swing.JButton bt_Remover1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Procurar;
    private javax.swing.JLabel lbl_verJogadores;
    private javax.swing.JLabel lbl_verMembros;
    private javax.swing.JLabel lbl_verTreinadores;
    private javax.swing.JTextField txt_nome;
    // End of variables declaration//GEN-END:variables
}
