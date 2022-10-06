package com.example.acoesmobile.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.acoesmobile.bean.Transacao;
import com.example.acoesmobile.util.Banco;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoTransacao {
    private SQLiteDatabase db;
    private Banco banco;


    public DaoTransacao(Context context){
        super();
        this.banco = new Banco(context);

        this.db = banco.getWritableDatabase();

    }

    public String inserir(Transacao tr) throws Exception {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put("id_usuario", tr.getIdU());
        valores.put("id_acao", tr.getIdA());
        valores.put("papel", this.buscarPapel(tr));
        valores.put("data", tr.getData());
        valores.put("tipo", tr.getTipo());
        valores.put("quantidade", tr.getQtd());
        valores.put("preco", tr.getPreco());
        valores.put("taxas", tr.getTaxas());
        valores.put("valorOperacao", tr.getValorOpe());
        valores.put("valorLiquido", tr.getValorLiq());
        valores.put("lucro", tr.getLucro());
        valores.put("corretora", tr.getCorretora());


        resultado = db.insert("transacoes", null, valores);
        db.close();

        if (resultado == -1) return "Erro ao inserir registro";
        else return "Registro Inserido com sucesso";
    }

    public String alterar(Transacao tr) throws Exception {
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = "_id = " + tr.getId();

        valores = new ContentValues();
        valores.put("id_usuario", tr.getIdU());
        valores.put("id_acao", tr.getIdA());
        valores.put("papel", this.buscarPapel(tr));
        valores.put("data", tr.getData());
        valores.put("tipo", tr.getTipo());
        valores.put("quantidade", tr.getQtd());
        valores.put("preco", tr.getPreco());
        valores.put("taxas", tr.getTaxas());
        valores.put("valorOperacao", tr.getValorOpe());
        valores.put("valorLiquido", tr.getValorLiq());
        valores.put("lucro", tr.getLucro());
        valores.put("corretora", tr.getCorretora());

        long resultado = db.update("transacoes",valores,where,null);
        db.close();

        if (resultado == -1) return "Erro ao alterar registro";
        else return "Registro alterado com sucesso";
    }

    public String remover(Transacao tr) {
        String where = "_id = " + tr.getId();

        db = banco.getReadableDatabase();
        long resultado = db.delete("transacoes",where,null);
        db.close();

        if (resultado == -1) return "Erro ao remover registro";
        else return "Registro removido com sucesso";
    }

    public Cursor listar() {
        Cursor cursor;
        String[] campos = {"_id", "id_usuario", "id_acao", "papel","data","tipo","quantidade","preco","taxas","valorOperacao","valorLiquido","lucro","corretora"};
        db = banco.getReadableDatabase();
        cursor = db.query("transacoes", campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor buscar(Transacao tr) {
        Cursor cursor;
        String[] campos = {"_id", "id_usuario", "id_acao", "papel","data","tipo","quantidade","preco","taxas","valorOperacao","valorLiquido","lucro","corretora"};
        String where = "_id = " + tr.getId();
        db = banco.getReadableDatabase();
        cursor = db.query("transacoes", campos, where, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public String buscarPapel(Transacao tr) {
        Cursor cursor;
        String[] campos = {"ticker"};
        String where = "_id = " + tr.getIdA();

        cursor = db.query("acoes", campos, where, null, null, null, null, null);
        String name = null;
        List<String> stringList = new ArrayList<String>();
        if (cursor != null) {
            cursor.moveToFirst();
            while (cursor.isAfterLast() == false) {
                name = (cursor.getString(cursor.getColumnIndex("ticker")));

                stringList.add(name);
                cursor.moveToNext();
            }
        }

            return stringList.get(0);

    }
}
