/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando João
 */
public class HistorialJogador {
    private long numhistorialjogador;
    private long numfaf;
    private long idEquipa;
    private String datainicio;
    private String datafim;

    public HistorialJogador(long numhistorialjogador, long numfaf, long idEquipa, String datainicio, String datafim) {
        this.numhistorialjogador = numhistorialjogador;
        this.numfaf = numfaf;
        this.idEquipa = idEquipa;
        this.datainicio = datainicio;
        this.datafim = datafim;
    }

    public HistorialJogador() {
    }

    public String getDatafim() {
        return datafim;
    }

    public void setDatafim(String datafim) {
        this.datafim = datafim;
    }

    public String getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(String datainicio) {
        this.datainicio = datainicio;
    }

    public long getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(long idEquipa) {
        this.idEquipa = idEquipa;
    }

    public long getNumfaf() {
        return numfaf;
    }

    public void setNumfaf(long numfaf) {
        this.numfaf = numfaf;
    }

    public long getNumhistorialjogador() {
        return numhistorialjogador;
    }

    public void setNumhistorialjogador(long numhistorialjogador) {
        this.numhistorialjogador = numhistorialjogador;
    }
    
    
}
