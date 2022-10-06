package com.example.acoesmobile.view.transacao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.acoesmobile.R;
import com.example.acoesmobile.bean.Transacao;
import com.example.acoesmobile.controller.ControleTransacao;
import com.example.acoesmobile.view.Menu;

public class CriaTransacao extends AppCompatActivity {

    EditText usu, ac, data, tipo, qtd, preco, taxas, corretora;

    Transacao bean;
    ControleTransacao controller;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cria_transacao);

        usu = (EditText) findViewById(R.id.usuTxt);
        ac = (EditText) findViewById(R.id.acTxt);
        data = (EditText) findViewById(R.id.dataTxt);
        tipo= (EditText) findViewById(R.id.tipoTxt);
        qtd= (EditText) findViewById(R.id.qtdTxt);
        preco= (EditText) findViewById(R.id.precoTxt);
        taxas= (EditText) findViewById(R.id.taxasTxt);
        corretora= (EditText) findViewById(R.id.corretoraTxt);

    }

    public void cadastrarTransacao(View v) {
        try {
            bean = new Transacao();

            bean.setIdU(Integer.valueOf(usu.getText().toString()));
            bean.setIdA(Integer.valueOf(ac.getText().toString()));

            bean.setData(data.getText().toString());
            bean.setTipo(tipo.getText().toString());
            bean.setQtd(Integer.parseInt(qtd.getText().toString()));
            bean.setPreco(Double.parseDouble(preco.getText().toString()));
            bean.setTaxas(Double.parseDouble(taxas.getText().toString()));

            bean.setCorretora(corretora.getText().toString());


            controller = new ControleTransacao(this);
            String resultado = controller.inserir(bean);


            Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
            intent = new Intent(CriaTransacao.this, Menu.class);
            this.startActivity(intent);
        }
        catch(Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public void cancelarCadastroTransacao(View v) {
        super.onBackPressed();
        finish();
    }
}