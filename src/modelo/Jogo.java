/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Fernando João
 */
public class Jogo {
    private long Idjogo;
    private String Datajogo;
    private String Horainicio;
    private long idEstadio;
    private String Inicioprimeiraparte;
    private String Iniciosegundaparte;
    private String Prolongamento;
    private String Inicioprolongamento;
    private long Resultadovisitado;
    private long Resultadovisitante;
    private long Numbilhete;
    private double Receitabilhete;
    private String Cadeiatelevisiva;
    private double Receitacadeiatelevisiva;
    private long numjornada;
    private long idcampeonato;
    private long Idobservador;

    public Jogo() {
    }

    public Jogo(long Idjogo, String Datajogo, String Horainicio, long idEstadio, String Inicioprimeiraparte, String Iniciosegundaparte, String Prolongamento, String Inicioprolongamento, long Resultadovisitado, long Resultadovisitante, long Numbilhete, double Receitabilhete, String Cadeiatelevisiva, double Receitacadeiatelevisiva, long numjornada, long idcampeonato, long Idobservador) {
        this.Idjogo = Idjogo;
        this.Datajogo = Datajogo;
        this.Horainicio = Horainicio;
        this.idEstadio = idEstadio;
        this.Inicioprimeiraparte = Inicioprimeiraparte;
        this.Iniciosegundaparte = Iniciosegundaparte;
        this.Prolongamento = Prolongamento;
        this.Inicioprolongamento = Inicioprolongamento;
        this.Resultadovisitado = Resultadovisitado;
        this.Resultadovisitante = Resultadovisitante;
        this.Numbilhete = Numbilhete;
        this.Receitabilhete = Receitabilhete;
        this.Cadeiatelevisiva = Cadeiatelevisiva;
        this.Receitacadeiatelevisiva = Receitacadeiatelevisiva;
        this.numjornada = numjornada;
        this.idcampeonato = idcampeonato;
        this.Idobservador = Idobservador;
    }

    public String getCadeiatelevisiva() {
        return Cadeiatelevisiva;
    }

    public void setCadeiatelevisiva(String Cadeiatelevisiva) {
        this.Cadeiatelevisiva = Cadeiatelevisiva;
    }

    public String getDatajogo() {
        return Datajogo;
    }

    public void setDatajogo(String Datajogo) {
        this.Datajogo = Datajogo;
    }

    public String getHorainicio() {
        return Horainicio;
    }

    public void setHorainicio(String Horainicio) {
        this.Horainicio = Horainicio;
    }

    public long getIdjogo() {
        return Idjogo;
    }

    public void setIdjogo(long Idjogo) {
        this.Idjogo = Idjogo;
    }

    public long getIdobservador() {
        return Idobservador;
    }

    public void setIdobservador(long Idobservador) {
        this.Idobservador = Idobservador;
    }

    public String getInicioprimeiraparte() {
        return Inicioprimeiraparte;
    }

    public void setInicioprimeiraparte(String Inicioprimeiraparte) {
        this.Inicioprimeiraparte = Inicioprimeiraparte;
    }

    public String getInicioprolongamento() {
        return Inicioprolongamento;
    }

    public void setInicioprolongamento(String Inicioprolongamento) {
        this.Inicioprolongamento = Inicioprolongamento;
    }

    public String getIniciosegundaparte() {
        return Iniciosegundaparte;
    }

    public void setIniciosegundaparte(String Iniciosegundaparte) {
        this.Iniciosegundaparte = Iniciosegundaparte;
    }

    public long getNumbilhete() {
        return Numbilhete;
    }

    public void setNumbilhete(long Numbilhete) {
        this.Numbilhete = Numbilhete;
    }

    public String getProlongamento() {
        return Prolongamento;
    }

    public void setProlongamento(String Prolongamento) {
        this.Prolongamento = Prolongamento;
    }

    public double getReceitabilhete() {
        return Receitabilhete;
    }

    public void setReceitabilhete(double Receitabilhete) {
        this.Receitabilhete = Receitabilhete;
    }

    public double getReceitacadeiatelevisiva() {
        return Receitacadeiatelevisiva;
    }

    public void setReceitacadeiatelevisiva(double Receitacadeiatelevisiva) {
        this.Receitacadeiatelevisiva = Receitacadeiatelevisiva;
    }

    public long getResultadovisitado() {
        return Resultadovisitado;
    }

    public void setResultadovisitado(long Resultadovisitado) {
        this.Resultadovisitado = Resultadovisitado;
    }

    public long getResultadovisitante() {
        return Resultadovisitante;
    }

    public void setResultadovisitante(long Resultadovisitante) {
        this.Resultadovisitante = Resultadovisitante;
    }

    public long getIdEstadio() {
        return idEstadio;
    }

    public void setIdEstadio(long idEstadio) {
        this.idEstadio = idEstadio;
    }

    public long getIdcampeonato() {
        return idcampeonato;
    }

    public void setIdcampeonato(long idcampeonato) {
        this.idcampeonato = idcampeonato;
    }

    public long getNumjornada() {
        return numjornada;
    }

    public void setNumjornada(long numjornada) {
        this.numjornada = numjornada;
    }
    
    
}
