/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoesbackend.model.bean;

import acoesbackend.model.dao.DaoTransacao;
import java.sql.SQLException;



/**
 *
 * @author RODRIGORICCIDEPAULAM
 */
public class Transacao {
    
    private int id;
    private int idU;
    private int idA;
    private String papel;
    private String data;
    private String tipo;
    private int qtd;
    private double preco;
    private double taxas;
    private double valorOpe;
    private double valorLiq;
    private double lucro;
    private String corretora;

    public Transacao(int id) {
        this.id = id;
    }

    public Transacao(int id, int idU, int idA, String data, String tipo, int qtd, double preco, double taxas, String corretora) {
        this.id = id;
        this.idU = idU;
        this.idA = idA;
        this.data = data;
        this.tipo = tipo;
        this.qtd = qtd;
        this.preco = preco;
        this.taxas = taxas;
        this.corretora = corretora;
       
    }

    public Transacao(int id, int idU, int idA, String papel, String data, String tipo, int qtd, double preco, double taxas, double valorOpe, double valorLiq, double lucro, String corretora) {
        
        this.id = id;
        this.idU = idU;
        this.idA = idA;
        this.papel = papel;
        this.data = data;
        this.tipo = tipo;
        this.qtd = qtd;
        this.preco = preco;
        this.taxas = taxas;
        this.valorOpe = valorOpe;
        this.valorLiq = valorLiq;
        this.lucro = lucro;
        this.corretora = corretora;
    }

    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public int getIdA() {
        return idA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public String getPapel() throws SQLException, ClassNotFoundException {
        DaoTransacao dao = new DaoTransacao();
        papel = dao.buscarPapel(this).getTicker();
        
        setPapel(papel);
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getTaxas() {
        return taxas;
    }

    public void setTaxas(double taxas) {
        this.taxas = taxas;
    }

    public double getValorOpe() {
       setValorOpe(valorOpe = this.getQtd()*this.getPreco());
        return valorOpe;
    }

    public void setValorOpe(double valorOpe) {
        this.valorOpe = valorOpe;
    }

    public double getValorLiq() {
        if(getTipo().equals("COMPRA"))
        {
         setValorLiq(valorLiq = (this.getValorOpe() + this.getTaxas())*(-1));
        }
        else if(getTipo().equals("VENDA"))
        {
          setValorLiq(valorLiq = this.getValorOpe() - this.getTaxas());
        }
        return valorLiq;
    }

    public void setValorLiq(double valorLiq) {
        this.valorLiq = valorLiq;
    }

    public double getLucro() {
        if(getTipo().equals("COMPRA"))
        {
          setLucro(lucro = 0);
        }
        else if(getTipo().equals("VENDA"))
        {
          setLucro(lucro = 0);
        }
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public String getCorretora() {
        return corretora;
    }

    public void setCorretora(String corretora) {
        this.corretora = corretora;
    }

    

    @Override
    public String toString() {
        return "Transacao{" + "id=" + id + ", idU=" + idU + ", idA=" + idA + ", papel=" + papel + ", data=" + data + ", tipo=" + tipo + ", qtd=" + qtd + ", preco=" + preco + ", taxas=" + taxas + ", valorOpe=" + valorOpe + ", valorLiq=" + valorLiq + ", lucro=" + lucro + ", corretora=" + corretora + '}';
    }
    
    
    
    
}
