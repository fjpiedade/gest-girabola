/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando João
 */
public class Socio {
    private long numSocio;
    private String Bi;
    private String obs;

    public Socio(long numSocio, String Bi, String obs) {
        this.numSocio = numSocio;
        this.Bi = Bi;
        this.obs = obs;
    }
    
    public Socio() {
        
    }

    public String getBi() {
        return Bi;
    }

    public void setBi(String Bi) {
        this.Bi = Bi;
    }

    public long getNumSocio() {
        return numSocio;
    }

    public void setNumSocio(long numSocio) {
        this.numSocio = numSocio;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    
}
