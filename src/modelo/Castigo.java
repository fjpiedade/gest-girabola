/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando João
 */
public class Castigo {
    private long idCastigo;
    private long numHistorialJogador;
    private String motivoCastigo;
    private String inicioCastigo;
    private String fimCastigo;

    public Castigo(long idCastigo, long numHistorialJogador, String motivoCastigo, String inicioCastigo, String fimCastigo) {
        this.idCastigo = idCastigo;
        this.numHistorialJogador = numHistorialJogador;
        this.motivoCastigo = motivoCastigo;
        this.inicioCastigo = inicioCastigo;
        this.fimCastigo = fimCastigo;
    }

    public Castigo() {
    }

    public String getFimCastigo() {
        return fimCastigo;
    }

    public void setFimCastigo(String fimCastigo) {
        this.fimCastigo = fimCastigo;
    }

    public long getIdCastigo() {
        return idCastigo;
    }

    public void setIdCastigo(long idCastigo) {
        this.idCastigo = idCastigo;
    }

    public String getInicioCastigo() {
        return inicioCastigo;
    }

    public void setInicioCastigo(String inicioCastigo) {
        this.inicioCastigo = inicioCastigo;
    }

    public String getMotivoCastigo() {
        return motivoCastigo;
    }

    public void setMotivoCastigo(String motivoCastigo) {
        this.motivoCastigo = motivoCastigo;
    }

    public long getNumHistorialJogador() {
        return numHistorialJogador;
    }

    public void setNumHistorialJogador(long numHistorialJogador) {
        this.numHistorialJogador = numHistorialJogador;
    }
    
    
}
