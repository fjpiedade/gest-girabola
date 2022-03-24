/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando João
 */
public class Membro {
    private long idMembro;
    private String Tipo;
    private String Obs;
    private String Bi;
    private long idEquipa;
    
    public Membro(long idMembro, String Tipo, String Obs, String Bi, long idEquipa) {
        this.idMembro = idMembro;
        this.Tipo = Tipo;
        this.Obs = Obs;
        this.Bi = Bi;
        this.idEquipa = idEquipa;
    }

    public Membro() {
    }

    public String getBi() {
        return Bi;
    }

    public void setBi(String Bi) {
        this.Bi = Bi;
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String Obs) {
        this.Obs = Obs;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public long getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(long idEquipa) {
        this.idEquipa = idEquipa;
    }

    public long getIdMembro() {
        return idMembro;
    }

    public void setIdMembro(long idMembro) {
        this.idMembro = idMembro;
    }
}
