/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando João
 */
public class Arbitro {
    
    private long idArbitro;
    private String Tipo;
    private String Classifcacao;
    private String bi;

    public Arbitro(long idArbitro, String Tipo, String Classifcacao, String bi) {
        this.idArbitro = idArbitro;
        this.Tipo = Tipo;
        this.Classifcacao = Classifcacao;
        this.bi = bi;
    }
    
    public Arbitro() {
    }

    public String getClassifcacao() {
        return Classifcacao;
    }

    public void setClassifcacao(String Classifcacao) {
        this.Classifcacao = Classifcacao;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public long getIdArbitro() {
        return idArbitro;
    }

    public void setIdArbitro(long idArbitro) {
        this.idArbitro = idArbitro;
    }
    
    
}
