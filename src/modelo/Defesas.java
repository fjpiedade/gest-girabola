/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando João
 */
public class Defesas {
    private String Horadefesa;
    private String Forma;
    private String Localremate;
    private long numFAF;
    private long Idjogo;
    private long idEquipa;

    public Defesas() {
    }

    public Defesas(String Horadefesa, String Forma, String Localremate, long numFAF, long Idjogo, long idEquipa) {
        this.Horadefesa = Horadefesa;
        this.Forma = Forma;
        this.Localremate = Localremate;
        this.numFAF = numFAF;
        this.Idjogo = Idjogo;
        this.idEquipa = idEquipa;
    }

        
    public String getForma() {
        return Forma;
    }

    public void setForma(String Forma) {
        this.Forma = Forma;
    }

    public String getHoradefesa() {
        return Horadefesa;
    }

    public void setHoradefesa(String Horadefesa) {
        this.Horadefesa = Horadefesa;
    }

    public long getIdjogo() {
        return Idjogo;
    }

    public void setIdjogo(long Idjogo) {
        this.Idjogo = Idjogo;
    }

    public String getLocalremate() {
        return Localremate;
    }

    public void setLocalremate(String Localremate) {
        this.Localremate = Localremate;
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
