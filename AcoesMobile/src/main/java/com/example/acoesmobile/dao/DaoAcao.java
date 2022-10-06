package com.example.acoesmobile.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.acoesmobile.bean.Acao;
import com.example.acoesmobile.util.Banco;

public class DaoAcao {

    private SQLiteDatabase db;
    private Banco banco;

    public DaoAcao(Context context ){
        super();
        this.banco = new Banco(context);
        this.db = banco.getWritableDatabase();

    }

    public String inserir(Acao acao) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("ticker", acao.getTicker());
        valores.put("empresa", acao.getEmpresa());
        valores.put("cotacao", acao.getCotacao());


        resultado = db.insert("acoes", null, valores);
        db.close();

        if (resultado == -1) return "Erro ao inserir registro";
        else return "Registro Inserido com sucesso";
    }

    public String alterar(Acao acao) {
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = "_id = " + acao.getId();

        valores = new ContentValues();
        valores.put("ticker", acao.getTicker());
        valores.put("empresa", acao.getEmpresa());
        valores.put("cotacao", acao.getCotacao());

        long resultado = db.update("acoes",valores,where,null);
        db.close();

        if (resultado == -1) return "Erro ao alterar registro";
        else return "Registro alterado com sucesso";
    }

    public String remover(Acao acao) {
        String where = "_id = " + acao.getId();

        db = banco.getReadableDatabase();
        long resultado = db.delete("acoes",where,null);
        db.close();

        if (resultado == -1) return "Erro ao remover registro";
        else return "Registro removido com sucesso";
    }

    public Cursor listar(Acao acao) {
        Cursor cursor;
        String[] campos = {"_id", "ticker", "empresa", "cotacao"};
        db = banco.getReadableDatabase();
        cursor = db.query("acoes", campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor buscar(Acao acao) {
        Cursor cursor;
        String[] campos = {"_id", "ticker", "empresa", "cotacao"};
        String where = "_id = " + acao.getId();
        db = banco.getReadableDatabase();
        cursor = db.query("acoes", campos, where, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

}
