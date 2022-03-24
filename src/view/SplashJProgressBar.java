/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
/**
 *
 * @author Fernando João
 */
public class SplashJProgressBar extends javax.swing.JWindow {
    private JLabel jLabelSplashImage;
    private JLabel jLabelTextoCarregamento;
    private static JLabel jLabelTextoDinamicoPlugins;
    private static JProgressBar jProgressBarSistema;
    frmLogin appLogin=new frmLogin();
            
    public SplashJProgressBar() {
        try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO: handle exception
		}
        criandoComponentes();
        this.setVisible(true);
    }
    
    public void chamarLogin() {
        appLogin.setVisible(true);
    }

private void criandoComponentes() {
        /**
         * Inicializando as variavaeis utilizadas
         */
        jProgressBarSistema = new JProgressBar();
        jLabelSplashImage = new JLabel();
        jLabelTextoCarregamento = new JLabel();
        jLabelTextoDinamicoPlugins = new JLabel();
        /**
         * Carregando a imagem do Splash e adicionando a imagem ao componente
         * jLabelSplashImage
         */
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("imagens/finalSplash.png"));
        jLabelSplashImage.setIcon(imageIcon);
        /**
         * Definindo dinamicamente o tamando do container segundo o tamanho da imagem.
         */
        this.setMinimumSize(new java.awt.Dimension(imageIcon.getIconWidth(),imageIcon.getIconHeight()));
        jLabelSplashImage.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        /**
         * A definicao do layout=null e importante para possibilitar que os componentes
         * fiquem sobrescritros em tempo de execucao
         */
        getContentPane().setLayout(null);
        /**
         * Definindo a localizacao do splash no centro da tela
         */
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screen.width - this.getSize().width) / 2, (screen.height - this.getSize().height) / 2);

        /**
         * Setando parametros da variavel jProgressBarSistema
         */
        jProgressBarSistema.setForeground(new Color(0,0,204));
        jProgressBarSistema.setPreferredSize(new java.awt.Dimension(148, 5));
        jProgressBarSistema.setBounds(0, 266, imageIcon.getIconWidth(), 5);
        jProgressBarSistema.setBorderPainted(false);
        jProgressBarSistema.setIndeterminate(true);
        /**
         * Adicionando o jProgressBarSistema a classe SplashJProgressBar
         */
        getContentPane().add(jProgressBarSistema);
        
        /**
         * Setando parametros da variavel jProgressBarSistema
         */
        jLabelTextoCarregamento.setForeground(new java.awt.Color(0,0,0));
        jLabelTextoCarregamento.setFont(new java.awt.Font("Trebuchet MS", 0, 11));
        jLabelTextoCarregamento.setText("Carregar...");
        jLabelTextoCarregamento.setBounds(370, 300, 80, 20);
        /**
         * Adicionando o jProgressBarSistema a classe SplashJProgressBar
         */
        this.getContentPane().add(jLabelTextoCarregamento);
      
        /**
         * Setando parametros da variavel jProgressBarSistema
         */
        jLabelTextoDinamicoPlugins.setForeground(new java.awt.Color(0,0,0));
        jLabelTextoDinamicoPlugins.setFont(new java.awt.Font("Trebuchet MS", 0, 11));
        jLabelTextoDinamicoPlugins.setBounds(430, 300, 230, 20);
        /**
         * Adicionando o jProgressBarSistema a classe SplashJProgressBar
         */
        this.getContentPane().add(jLabelTextoDinamicoPlugins);
        
        /**
         * O Ultimo item adicionado no conteiner deve ser o componente que comtem 
         * a imagem do Splah
         */
        this.getContentPane().add(jLabelSplashImage);
        this.pack();
        
    }

    public static void main(String args[]) {
            SplashJProgressBar splashJProgressBar = new SplashJProgressBar();
            /**
             * Rotina para exibicao de um texto qualquer no carregamento do seu 
             * sistema
             */
            int i=10;
                for (int j = 1; j <= 1000; j++) {
                   
                         if(j==(1000/i)){
                             
                             jLabelTextoDinamicoPlugins.setText("Aguarde a Inicialização: " + i);
                             i--;
                              try{
                        Thread.sleep(1200);
                    }catch(Exception e){
                        
                    }        
                         }
                 }
            
           splashJProgressBar.chamarLogin();
           splashJProgressBar.hide();
           
           
    }  
}