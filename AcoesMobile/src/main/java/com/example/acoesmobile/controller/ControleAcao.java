package com.example.acoesmobile.controller;

import android.content.Context;
import android.database.Cursor;

import com.example.acoesmobile.bean.Acao;
import com.example.acoesmobile.dao.DaoAcao;

public class ControleAcao {

    private DaoAcao dao;
    private Context context;

    public ControleAcao(Context context) throws Exception, ClassNotFoundException {
        this.context = context;
        this.dao = new DaoAcao(this.context);
    }

    public String inserir(Acao acao) throws ClassNotFoundException, Exception {

        return this.dao.inserir(acao);
    }

    public String alterar(Acao acao) throws ClassNotFoundException, Exception {
        return this.dao.alterar(acao);
    }

    public Cursor buscar(Acao acao) throws ClassNotFoundException, Exception {
        return this.dao.buscar(acao);
    }

    public Cursor listar(Acao acao) throws ClassNotFoundException, Exception {
        return this.dao.listar(acao);
    }

    public String remover(Acao acao) throws ClassNotFoundException, Exception {
        return this.dao.remover(acao);
    }
}
