/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando João
 */
public class Clube {
    private long numIdFiscal;
    private String nomeClube;
    private String Inicias;
    private double capitaSocial;
    private String situacaoFiscal;
    private String moradaSede;
    private String telefoneSede;
    private long idPresidente;
    private String bandeira;

    public Clube(long numIdFiscal, String nomeClube, String Inicias, double capitaSocial, String situacaoFiscal, String moradaSede, String telefoneSede, long idPresidente, String bandeira) {
        this.numIdFiscal = numIdFiscal;
        this.nomeClube = nomeClube;
        this.Inicias = Inicias;
        this.capitaSocial = capitaSocial;
        this.situacaoFiscal = situacaoFiscal;
        this.moradaSede = moradaSede;
        this.telefoneSede = telefoneSede;
        this.idPresidente = idPresidente;
        this.bandeira = bandeira;
    }

    public Clube() {
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String Bandeira) {
        this.bandeira = Bandeira;
    }
    
    public String getInicias() {
        return Inicias;
    }

    public void setInicias(String Inicias) {
        this.Inicias = Inicias;
    }

    public double getCapitaSocial() {
        return capitaSocial;
    }

    public void setCapitaSocial(double capitaSocial) {
        this.capitaSocial = capitaSocial;
    }

    public long getIdPresidente() {
        return idPresidente;
    }

    public void setIdPredinte(long idPresidente) {
        this.idPresidente = idPresidente;
    }

    public String getMoradaSede() {
        return moradaSede;
    }

    public void setMoradaSede(String moradaSede) {
        this.moradaSede = moradaSede;
    }

    public String getNomeClube() {
        return nomeClube;
    }

    public void setNomeClube(String nomeClube) {
        this.nomeClube = nomeClube;
    }

    public long getNumIdFiscal() {
        return numIdFiscal;
    }

    public void setNumIdFiscal(long numIdFiscal) {
        this.numIdFiscal = numIdFiscal;
    }

    public String getSituacaoFiscal() {
        return situacaoFiscal;
    }

    public void setSituacaoFiscal(String situacaoFiscal) {
        this.situacaoFiscal = situacaoFiscal;
    }

    public String getTelefoneSede() {
        return telefoneSede;
    }

    public void setTelefoneSede(String telefoneSede) {
        this.telefoneSede = telefoneSede;
    }
    
    
}
