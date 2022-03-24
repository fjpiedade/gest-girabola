/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando João
 */
public class Equipa {
    private long idEquipa;
    private String descricao;
    private long numIdFiscal;

    public Equipa(long idEquipa, String descricao, long numIdFiscal) {
        this.idEquipa = idEquipa;
        this.descricao = descricao;
        this.numIdFiscal = numIdFiscal;
    }

    public Equipa() {
    }
    
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(long idEquipa) {
        this.idEquipa = idEquipa;
    }

    public long getNumIdFiscal() {
        return numIdFiscal;
    }

    public void setNumIdFiscal(long numIdFiscal) {
        this.numIdFiscal = numIdFiscal;
    }
    
    
    
}
