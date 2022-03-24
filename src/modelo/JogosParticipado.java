/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando João
 */
public class JogosParticipado {
    
    private long numFAF;
    private long idJogo; 
    private long idEquipa;
    private long numCamisa; 
    private String nomeCamisa;
    private String horaEntrar;
    private String horaSaida;
    private String motivoSaida;

    public JogosParticipado() {
    }

    public JogosParticipado(long numFAF, long idJogo, long idEquipa, long numCamisa, String nomeCamisa, String horaEntrar, String horaSaida, String motivoSaida) {
        this.numFAF = numFAF;
        this.idJogo = idJogo;
        this.idEquipa = idEquipa;
        this.numCamisa = numCamisa;
        this.nomeCamisa = nomeCamisa;
        this.horaEntrar = horaEntrar;
        this.horaSaida = horaSaida;
        this.motivoSaida = motivoSaida;
    }

    public String getHoraEntrar() {
        return horaEntrar;
    }

    public void setHoraEntrar(String horaEntrar) {
        this.horaEntrar = horaEntrar;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public long getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(long idEquipa) {
        this.idEquipa = idEquipa;
    }

    public long getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(long idJogo) {
        this.idJogo = idJogo;
    }

    public String getMotivoSaida() {
        return motivoSaida;
    }

    public void setMotivoSaida(String motivoSaida) {
        this.motivoSaida = motivoSaida;
    }

    public String getNomeCamisa() {
        return nomeCamisa;
    }

    public void setNomeCamisa(String nomeCamisa) {
        this.nomeCamisa = nomeCamisa;
    }

    public long getNumCamisa() {
        return numCamisa;
    }

    public void setNumCamisa(long numCamisa) {
        this.numCamisa = numCamisa;
    }

    public long getNumFAF() {
        return numFAF;
    }

    public void setNumFAF(long numFAF) {
        this.numFAF = numFAF;
    }
        
    
}
