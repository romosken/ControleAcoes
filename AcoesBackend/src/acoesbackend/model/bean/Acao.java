/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesbackend.model.bean;

/**
 *
 * @author RODRIGORICCIDEPAULAM
 */
public class Acao {
    
    private int id;
    private String ticker;
    private String empresa;
    private double cotacao;

    public Acao(int id) {
        this.id = id;
    }

    public Acao(String ticker) {
        this.ticker = ticker;
    }

    public Acao(int id, String ticker, String empresa, double cotacao) {
        this.id = id;
        this.ticker = ticker;
        this.empresa = empresa;
        this.cotacao = cotacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }

    @Override
    public String toString() {
        return "Acao{" + "id=" + id + ", ticker=" + ticker + ", empresa=" + empresa + ", cotacao=" + cotacao + '}';
    }
    
    
    
}
