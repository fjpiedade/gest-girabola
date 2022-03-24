/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando João
 */
public class Campeonato {
    
    private long idCampeonato;
    private String Descricao;
    private long Ano;
    private long numEquipa;

    public Campeonato() {
    }

    public Campeonato(long idCampeonato, String Descricao, long Ano, long numEquipa) {
        this.idCampeonato = idCampeonato;
        this.Descricao = Descricao;
        this.Ano = Ano;
        this.numEquipa=numEquipa;
    }

    public long getAno() {
        return Ano;
    }

    public void setAno(long Ano) {
        this.Ano = Ano;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public long getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(long idCampeonato) {
        this.idCampeonato = idCampeonato;
    }
    
    public long getNumEquipas() {
        return numEquipa;
    }

    public void setNumEquipas(long numEquipa) {
        this.numEquipa = numEquipa;
    }
    
}
