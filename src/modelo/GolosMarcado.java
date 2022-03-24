/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando João
 */
public class GolosMarcado {
    private long instante;
    private long idjogo;
    private long numfaf;
    private long idequipa;
    private String localgolo;
    private String formagolo;

    public GolosMarcado() {
    }

    public GolosMarcado(long instante, long idjogo, long numfaf, long idequipa, String localgolo, String formagolo) {
        this.instante = instante;
        this.idjogo = idjogo;
        this.numfaf = numfaf;
        this.idequipa = idequipa;
        this.localgolo = localgolo;
        this.formagolo = formagolo;
    }

    public String getFormagolo() {
        return formagolo;
    }

    public void setFormagolo(String formagolo) {
        this.formagolo = formagolo;
    }

    public long getIdequipa() {
        return idequipa;
    }

    public void setIdequipa(long idequipa) {
        this.idequipa = idequipa;
    }

    public long getIdjogo() {
        return idjogo;
    }

    public void setIdjogo(long idjogo) {
        this.idjogo = idjogo;
    }

    public long getInstante() {
        return instante;
    }

    public void setInstante(long instante) {
        this.instante = instante;
    }

    public String getLocalgolo() {
        return localgolo;
    }

    public void setLocalgolo(String localgolo) {
        this.localgolo = localgolo;
    }

    public long getNumfaf() {
        return numfaf;
    }

    public void setNumfaf(long numfaf) {
        this.numfaf = numfaf;
    }
    
    
}
