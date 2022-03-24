/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando João
 */
public class Utilizador {
    
    private long idUtilizador;
    private String nomeUtilizador;
    private String senhaUtilizador;
    private String dataCriado;
    private String bi;

    public Utilizador(long idUtilizador, String nomeUtilizador, String senhaUtilizador, String dataCriado, String bi) {
        this.idUtilizador = idUtilizador;
        this.nomeUtilizador = nomeUtilizador;
        this.senhaUtilizador = senhaUtilizador;
        this.dataCriado = dataCriado;
        this.bi = bi;
    }
    
    public Utilizador(){
    
    }
    
    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getDataCriado() {
        return dataCriado;
    }

    public void setDataCriado(String dataCriado) {
        this.dataCriado = dataCriado;
    }

    public long getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(long idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public String getNomeUtilizador() {
        return nomeUtilizador;
    }

    public void setNomeUtilizador(String nomeUtilizador) {
        this.nomeUtilizador = nomeUtilizador;
    }

    public String getSenhaUtilizador() {
        return senhaUtilizador;
    }

    public void setSenhaUtilizador(String senhaUtilizador) {
        this.senhaUtilizador = senhaUtilizador;
    }
    
    
}
