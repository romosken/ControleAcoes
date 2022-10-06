package com.example.acoesmobile.bean;

import android.content.Context;

import com.example.acoesmobile.controller.ControleTransacao;
import com.example.acoesmobile.dao.DaoTransacao;

import java.sql.SQLException;

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



    public Transacao() {

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

    public String getPapel() throws Exception {
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

}
