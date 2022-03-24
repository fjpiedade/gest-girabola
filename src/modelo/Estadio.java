/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando João
 */
public class Estadio {
    private long idEstadio;
    private long lotacao;
    private String local;
    private String nome;

    public Estadio(long idEstadio, long lotacao, String local, String nome) {
        this.idEstadio = idEstadio;
        this.lotacao = lotacao;
        this.local = local;
        this.nome = nome;
    }

    public Estadio() {
    }

    public long getIdEstadio() {
        return idEstadio;
    }

    public void setIdEstadio(long idEstadio) {
        this.idEstadio = idEstadio;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public long getLotacao() {
        return lotacao;
    }

    public void setLotacao(long lotacao) {
        this.lotacao = lotacao;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
        
}
