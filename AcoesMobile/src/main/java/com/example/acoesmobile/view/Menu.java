package com.example.acoesmobile.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.acoesmobile.R;
import com.example.acoesmobile.view.acao.CriaAcao;
import com.example.acoesmobile.view.acao.ListaAcao;
import com.example.acoesmobile.view.transacao.CriaTransacao;
import com.example.acoesmobile.view.transacao.ListaTransacao;
import com.example.acoesmobile.view.usuario.ListaUsuario;

public class Menu extends AppCompatActivity {

    Intent tela;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //this.setTitle("Menu de acesso");
       // intent = getIntent();
    }

    public void listarUsuarios(View v) {
        tela = new Intent(Menu.this, ListaUsuario.class);
        this.startActivity(tela);
    }

    public void listarAcoes(View v) {
        tela = new Intent(Menu.this, ListaAcao.class);
        this.startActivity(tela);
    }

    public void novaAcao(View v) {
        tela = new Intent(Menu.this, CriaAcao.class);
        this.startActivity(tela);
    }

    public void listarTransacoes(View v) {
        tela = new Intent(Menu.this, ListaTransacao.class);
        this.startActivity(tela);
    }

    public void novaTransacoes(View v) {
        tela = new Intent(Menu.this, CriaTransacao.class);
        this.startActivity(tela);
    }

    public void logout(View v) {
        tela = new Intent(Menu.this, Login.class);
        this.startActivity(tela);
    }
}