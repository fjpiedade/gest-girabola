/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmPrincipal.java
 *
 * Created on 18/10/2011, 00:34:02
 */
package view;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Fernando João
 */
public class frmPrincipal extends javax.swing.JFrame {
    
    /** Creates new form frmPrincipal */
    public frmPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    public void nomeUtilizador(String nomeUtilizador){
        lbl_Utilizador.setText("Seja Bemvindo, [ "+nomeUtilizador+" ]");
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
  //  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bt_Arbitro = new javax.swing.JButton();
        bt_Campeonatos = new javax.swing.JButton();
        bt_Utilizadores = new javax.swing.JButton();
        bt_Estadios = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        bt_Clube = new javax.swing.JButton();
        bt_Socios = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbl_Sair = new javax.swing.JLabel();
        lbl_Utilizador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/finalBainer.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FAF", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12), new java.awt.Color(204, 204, 255))); // NOI18N
        jPanel2.setOpaque(false);

        bt_Arbitro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/bt_Arbitrios.png"))); // NOI18N
        bt_Arbitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ArbitroActionPerformed(evt);
            }
        });

        bt_Campeonatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/bt_Campeonatos.png"))); // NOI18N
        bt_Campeonatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_CampeonatosActionPerformed(evt);
            }
        });

        bt_Utilizadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/bt_Utilizadores.png"))); // NOI18N
        bt_Utilizadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_UtilizadoresActionPerformed(evt);
            }
        });

        bt_Estadios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/bt_Estadios.png"))); // NOI18N
        bt_Estadios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_EstadiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_Arbitro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_Campeonatos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_Utilizadores, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(bt_Estadios, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_Estadios, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(bt_Utilizadores, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(bt_Campeonatos, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(bt_Arbitro, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "System", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12), new java.awt.Color(204, 204, 255))); // NOI18N
        jPanel3.setOpaque(false);

        bt_Clube.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/bt_Clubes.png"))); // NOI18N
        bt_Clube.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ClubeActionPerformed(evt);
            }
        });

        bt_Socios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/bt_Socios.png"))); // NOI18N
        bt_Socios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SociosActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/bt_Procurar.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_Clube, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_Socios, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_Socios, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(bt_Clube, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 11));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Campeonato Angolano de Futebol - Girabola © 2011 - Todos os Direitos  Reservados.");
        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12), new java.awt.Color(204, 204, 255))); // NOI18N
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel2MouseMoved(evt);
            }
        });

        lbl_Sair.setBackground(new java.awt.Color(204, 204, 255));
        lbl_Sair.setFont(new java.awt.Font("Trebuchet MS", 0, 11));
        lbl_Sair.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Sair.setText("Sair [ ]");
        lbl_Sair.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12), new java.awt.Color(204, 204, 255))); // NOI18N
        lbl_Sair.setOpaque(true);
        lbl_Sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_SairMouseClicked(evt);
            }
        });
        lbl_Sair.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_SairMouseMoved(evt);
            }
        });

        lbl_Utilizador.setFont(new java.awt.Font("Trebuchet MS", 1, 11));
        lbl_Utilizador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Utilizador.setText("Seja Bem - vindo, [ ]");
        lbl_Utilizador.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12), new java.awt.Color(204, 204, 255))); // NOI18N
        lbl_Utilizador.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbl_UtilizadorMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Utilizador, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(845, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1158, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                .addComponent(lbl_Utilizador)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1157, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_ClubeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ClubeActionPerformed
        // TODO add your handling code here:
        frmClubes clube =new frmClubes(new javax.swing.JFrame(), true);
        clube.actualizaTabela();
        clube.setVisible(true);
       
    }//GEN-LAST:event_bt_ClubeActionPerformed

    private void bt_ArbitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ArbitroActionPerformed
        // TODO add your handling code here:
        frmArbitrios arbitro =new frmArbitrios(new javax.swing.JFrame(), true);
        arbitro.actualizaTabela();
        arbitro.setVisible(true);
    }//GEN-LAST:event_bt_ArbitroActionPerformed

        private void lbl_SairMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_SairMouseMoved
        // TODO add your handling code here:
            lbl_Sair.setBackground(Color.white);
    }//GEN-LAST:event_lbl_SairMouseMoved

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:
        lbl_Sair.setBackground(new java.awt.Color(204, 204, 255));
    }//GEN-LAST:event_jPanel1MouseMoved

    private void jLabel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseMoved
        // TODO add your handling code here:
        lbl_Sair.setBackground(new java.awt.Color(204, 204, 255));
    }//GEN-LAST:event_jLabel2MouseMoved

    private void lbl_SairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_SairMouseClicked
        // TODO add your handling code here:
        
        int Op;
        Object[] btOp={"Sim","Não"};
        Op=JOptionPane.showOptionDialog(null,"Deseja Realmente Sair ?","Campeonato Angolano de Futebol",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,btOp,btOp[0]);
        if (Op==JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_lbl_SairMouseClicked

    private void bt_SociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SociosActionPerformed
        // TODO add your handling code here:
        frmSocios socios =new frmSocios(new javax.swing.JFrame(), true);
        socios.actualizaTabela();
        socios.setVisible(true);
    }//GEN-LAST:event_bt_SociosActionPerformed

    private void bt_UtilizadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_UtilizadoresActionPerformed
        // TODO add your handling code here:
        frmUtilizadores utilizador =new frmUtilizadores(new javax.swing.JFrame(), true);
        utilizador.actualizaTabela();
        utilizador.setVisible(true);
        
    }//GEN-LAST:event_bt_UtilizadoresActionPerformed

    private void bt_CampeonatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_CampeonatosActionPerformed
        // TODO add your handling code here:
        frmCampeonatos Campeonato =new frmCampeonatos(new javax.swing.JFrame(), true);
        Campeonato.preencherComboAno();
        Campeonato.actualizaTabela();
        Campeonato.setVisible(true);
    }//GEN-LAST:event_bt_CampeonatosActionPerformed

    private void bt_EstadiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_EstadiosActionPerformed
        // TODO add your handling code here:
        frmEstadios Estadios =new frmEstadios(new javax.swing.JFrame(), true);
        Estadios.actualizaTabela();
        Estadios.setVisible(true);
    }//GEN-LAST:event_bt_EstadiosActionPerformed

    private void lbl_UtilizadorMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_UtilizadorMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_UtilizadorMouseMoved

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        //</editor-fold>

        /* Create and display the form */
        
        
        //java.awt.EventQueue.invokeLater(new Runnable() {

          //  public void run() {
            //    frmLogin verLogin = null;
        
              //  if (verLogin == null){
                //    verLogin.dispose();
                //}
                //new frmPrincipal().setVisible(true);
                
        //   }
      // });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Arbitro;
    private javax.swing.JButton bt_Campeonatos;
    private javax.swing.JButton bt_Clube;
    private javax.swing.JButton bt_Estadios;
    private javax.swing.JButton bt_Socios;
    private javax.swing.JButton bt_Utilizadores;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_Sair;
    private javax.swing.JLabel lbl_Utilizador;
    // End of variables declaration//GEN-END:variables
}
