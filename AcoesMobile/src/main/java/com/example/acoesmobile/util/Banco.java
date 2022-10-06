package com.example.acoesmobile.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Banco extends SQLiteOpenHelper {

    public Banco (Context context) {
        super(context, "banco.db", null, 1);

    }

    @Override
    public void onOpen(SQLiteDatabase db){

        super.onOpen(db);
        db.execSQL("PRAGMA foreign_keys=ON");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.i("SQLITE", "CREATED!");

        db.execSQL("create table if not exists usuarios (_id INTEGER PRIMARY KEY AUTOINCREMENT,login VARCHAR(255) not null unique ,senha VARCHAR(255), cpf VARCHAR(255), nome VARCHAR(255), sobrenome VARCHAR(255));");

        db.execSQL("create table if not exists acoes (_id INTEGER PRIMARY KEY AUTOINCREMENT,ticker VARCHAR(255) not null unique ,empresa VARCHAR(255),cotacao DOUBLE);");

        db.execSQL("create table if not exists transacoes ( _id INTEGER PRIMARY KEY AUTOINCREMENT, id_usuario INTEGER, id_acao INTEGER, papel VARCHAR(255), data varchar(255), tipo VARCHAR(255), quantidade INT, preco DOUBLE, taxas DOUBLE, valorOperacao DOUBLE, valorLiquido DOUBLE, lucro DOUBLE, corretora VARCHAR(255), foreign key (id_usuario) references usuarios (_id), foreign key (id_acao) references acoes (_id))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.i("SQLITE", "UPGRADED!");
        db.execSQL("DROP TABLE IF EXISTS `acoes`");
        db.execSQL("DROP TABLE IF EXISTS `transacoes`");
        db.execSQL("DROP TABLE IF EXISTS `usuarios`");
        onCreate(db);

    }
}
