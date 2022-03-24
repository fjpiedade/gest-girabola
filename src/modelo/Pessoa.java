/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando João
 */
public class Pessoa {
    private String bi;
    private String nome;
    private String sexo;
    private String dataNasc;
    private String telefone;
    private String Morada;
    private String email;
    private String foto;

    public Pessoa(String bi, String nome, String sexo, String dataNasc, String telefone, String Morada, String email, String foto) {
        this.bi = bi;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
        this.telefone = telefone;
        this.Morada = Morada;
        this.email = email;
        this.foto = foto;
    }
    
    public Pessoa() {
        
    }

    public String getMorada() {
        return Morada;
    }

    public void setMorada(String Morada) {
        this.Morada = Morada;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
           
}
