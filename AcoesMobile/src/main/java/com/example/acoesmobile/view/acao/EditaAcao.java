package com.example.acoesmobile.view.acao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.acoesmobile.bean.Acao;
import com.example.acoesmobile.controller.ControleAcao;
import com.example.acoesmobile.R;

import com.example.acoesmobile.view.Menu;

import java.util.Date;

public class EditaAcao extends AppCompatActivity {

    Bundle bundle;
    Intent intent;
    EditText editaTicker, editaEmpresa, editaCotacao;

    Acao bean;
    ControleAcao controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita_acao);

        bundle = getIntent().getExtras();

        editaTicker = (EditText) findViewById(R.id.tickerTxt2);
        editaEmpresa = (EditText) findViewById(R.id.empresaTxt2);
        editaCotacao = (EditText) findViewById(R.id.cotacaoTxt2);


        editaTicker.setText(bundle.getString("ticker"));
        editaEmpresa.setText(bundle.getString("empresa"));
        editaCotacao.setText(String.valueOf(bundle.getDouble("cotacao")));

    }

    public void alterarAcao(View v){
        try {
            bean = new Acao();
            bean.setId(bundle.getInt("_id"));
            bean.setTicker(editaTicker.getText().toString());
            bean.setEmpresa(editaEmpresa.getText().toString());
            bean.setCotacao(Double.parseDouble(editaCotacao.getText().toString()));


            controller = new ControleAcao(this);
            String resposta = controller.alterar(bean);
            Toast.makeText(this, resposta, Toast.LENGTH_SHORT).show();
            intent = new Intent(EditaAcao.this, Menu.class);
            this.startActivity(intent);
            finish();
        }
        catch(Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public void cancelarAlteracaoAcao(View v) {
        intent = new Intent(EditaAcao.this, Menu.class);
        this.startActivity(intent);
        finish();
    }
}