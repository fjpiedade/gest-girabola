/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando João
 */
public class Jogador {
    private long numFAF;
    private String Posicao;
    private String Bi;
    private long idEquipa;

    public Jogador(long numFAF, String Posicao, String Bi, long idEquipa) {
        this.numFAF = numFAF;
        this.Posicao = Posicao;
        this.Bi = Bi;
        this.idEquipa = idEquipa;
    }

    public Jogador() {
    }

    public String getBi() {
        return Bi;
    }

    public void setBi(String Bi) {
        this.Bi = Bi;
    }

    public String getPosicao() {
        return Posicao;
    }

    public void setPosicao(String Posicao) {
        this.Posicao = Posicao;
    }

    public long getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(long idEquipa) {
        this.idEquipa = idEquipa;
    }

    public long getNumFAF() {
        return numFAF;
    }

    public void setNumFAF(long numFAF) {
        this.numFAF = numFAF;
    }
    
    
}
