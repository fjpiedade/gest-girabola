/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando João
 */
public class jornadaJogos {
    private long numJornada;
    private String clubeCasa;
    private String clubeVisita;
    private String estadoJogo;
    private long idCampeonato;

    public jornadaJogos() {
    }

    public jornadaJogos(long numJornada, String clubeCasa, String clubeVisita, String estadoJogo, long idCampeonato) {
        this.numJornada = numJornada;
        this.clubeCasa = clubeCasa;
        this.clubeVisita = clubeVisita;
        this.estadoJogo = estadoJogo;
        this.idCampeonato = idCampeonato;
    }

    public String getClubeCasa() {
        return clubeCasa;
    }

    public void setClubeCasa(String clubeCasa) {
        this.clubeCasa = clubeCasa;
    }

    public String getClubeVisita() {
        return clubeVisita;
    }

    public void setClubeVisita(String clubeVisita) {
        this.clubeVisita = clubeVisita;
    }

    public String getEstadoJogo() {
        return estadoJogo;
    }

    public void setEstadoJogo(String estadoJogo) {
        this.estadoJogo = estadoJogo;
    }

    public long getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(long idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public long getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(long numJornada) {
        this.numJornada = numJornada;
    }
    
    
}
