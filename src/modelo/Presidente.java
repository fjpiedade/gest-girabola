/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando João
 */
public class Presidente {
    private long idPresidente;
    private String bi;

    public Presidente(long idPresidente, String bi) {
        this.idPresidente = idPresidente;
        this.bi = bi;
    }

    public Presidente() {
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public long getIdPresidente() {
        return idPresidente;
    }

    public void setIdPresidente(long idPresidente) {
        this.idPresidente = idPresidente;
    }
    
    
    
}
