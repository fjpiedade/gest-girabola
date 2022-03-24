/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando João
 */
public class jornadasEscolhidos {
    private String nomeClube;
    private String iniciasClube;
    private long idEquipa;

    public jornadasEscolhidos() {
    }

    public jornadasEscolhidos(String nomeClube, String iniciasClube, long idEquipa) {
        this.nomeClube = nomeClube;
        this.iniciasClube = iniciasClube;
        this.idEquipa = idEquipa;
    }

    public long getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(long idEquipa) {
        this.idEquipa = idEquipa;
    }

    public String getIniciasClube() {
        return iniciasClube;
    }

    public void setIniciasClube(String iniciasClube) {
        this.iniciasClube = iniciasClube;
    }

    public String getNomeClube() {
        return nomeClube;
    }

    public void setNomeClube(String nomeClube) {
        this.nomeClube = nomeClube;
    }
    
    
}
