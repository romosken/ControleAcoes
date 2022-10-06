package com.example.acoesmobile.controller;

import android.content.Context;
import android.database.Cursor;

import com.example.acoesmobile.bean.Transacao;
import com.example.acoesmobile.dao.DaoTransacao;

public class ControleTransacao {
    private DaoTransacao dao;
    private Context context;

    public ControleTransacao(Context context) throws Exception, ClassNotFoundException {
        this.context = context;
        this.dao = new DaoTransacao(this.context);
    }

    public String inserir(Transacao tr) throws ClassNotFoundException, Exception {

        return this.dao.inserir(tr);
    }

    public String alterar(Transacao tr) throws ClassNotFoundException, Exception {
        return this.dao.alterar(tr);
    }

    public Cursor buscar(Transacao tr) throws ClassNotFoundException, Exception {
        return this.dao.buscar(tr);
    }

    public Cursor listar() throws ClassNotFoundException, Exception {
        return this.dao.listar();
    }

    public String remover(Transacao tr) throws ClassNotFoundException, Exception {
        return this.dao.remover(tr);
    }
}
