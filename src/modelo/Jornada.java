/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando João
 */
public class Jornada {
    private long numJornada;
    private long idEquipaVisitada;
    private long idEquipaVisitante;
    private String estadoJogo;
    private long idCampeonato;

    public Jornada() {
    }

    public Jornada(long numJornada, long idEquipaVisitada, long idEquipaVisitante, String estadoJogo, long idCampeonato) {
        this.numJornada = numJornada;
        this.idEquipaVisitada = idEquipaVisitada;
        this.idEquipaVisitante = idEquipaVisitante;
        this.estadoJogo = estadoJogo;
        this.idCampeonato = idCampeonato;
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

    public long getIdEquipaVisitada() {
        return idEquipaVisitada;
    }

    public void setIdEquipaVisitada(long idEquipaVisitada) {
        this.idEquipaVisitada = idEquipaVisitada;
    }

    public long getIdEquipaVisitante() {
        return idEquipaVisitante;
    }

    public void setIdEquipaVisitante(long idEquipaVisitante) {
        this.idEquipaVisitante = idEquipaVisitante;
    }

    public long getNumJornada() {
        return numJornada;
    }

    public void setNumJornada(long numJornada) {
        this.numJornada = numJornada;
    }
    
    
}
