package com.example.acoesmobile.view.acao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.acoesmobile.R;
import com.example.acoesmobile.bean.Acao;
import com.example.acoesmobile.controller.ControleAcao;
import com.example.acoesmobile.view.Menu;

public class CriaAcao extends AppCompatActivity {

    EditText txtTicker, txtEmpresa, txtCotacao;

    Acao bean;
    ControleAcao controller;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cria_acao);

        txtTicker = (EditText) findViewById(R.id.tickerTxt);
        txtEmpresa = (EditText) findViewById(R.id.empresaTxt);
        txtCotacao = (EditText) findViewById(R.id.cotacaoTxt);

    }

    public void cadastrarAcao(View v) {
        try {
            bean = new Acao();
            bean.setTicker(txtTicker.getText().toString());
            bean.setEmpresa(txtEmpresa.getText().toString());
            bean.setCotacao(Double.parseDouble(txtCotacao.getText().toString()));


            controller = new ControleAcao(this);
            String resultado = controller.inserir(bean);


            Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
            intent = new Intent(CriaAcao.this, Menu.class);
            this.startActivity(intent);
        }
        catch(Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public void cancelarCadastroAcao(View v) {
        super.onBackPressed();
        finish();
    }
}