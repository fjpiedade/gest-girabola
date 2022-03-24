/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando João
 */
public class Cartao {
    private String Instante;
    private String cor;
    private String Motivo;
    private long numCartao;
    private long Idjogo;
    private long numfaf;
    private long idequipa;

    public Cartao(String Instante, String cor, String Motivo, long numCartao, long Idjogo, long numfaf, long idequipa) {
        this.Instante = Instante;
        this.cor = cor;
        this.Motivo = Motivo;
        this.numCartao = numCartao;
        this.Idjogo = Idjogo;
        this.numfaf = numfaf;
        this.idequipa = idequipa;
    }

    public Cartao() {
    }

    public long getIdjogo() {
        return Idjogo;
    }

    public void setIdjogo(long Idjogo) {
        this.Idjogo = Idjogo;
    }

    public String getInstante() {
        return Instante;
    }

    public void setInstante(String Instante) {
        this.Instante = Instante;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public long getIdequipa() {
        return idequipa;
    }

    public void setIdequipa(long idequipa) {
        this.idequipa = idequipa;
    }

    public long getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(long numCartao) {
        this.numCartao = numCartao;
    }

    public long getNumfaf() {
        return numfaf;
    }

    public void setNumfaf(long numfaf) {
        this.numfaf = numfaf;
    }
    
    
}
