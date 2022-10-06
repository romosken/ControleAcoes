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

public class EditaTransacao extends AppCompatActivity {

    Bundle bundle;
    Intent intent;
    EditText usuT, acT, dataT, tipoT, qtdT, precoT, taxasT, corretoraT;


    Transacao bean;
    ControleTransacao controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita_transacao);

        bundle = getIntent().getExtras();


        usuT = (EditText) findViewById(R.id.usuTxt2);
        acT = (EditText) findViewById(R.id.acTxt2);
        dataT = (EditText) findViewById(R.id.dataTxt2);
        tipoT= (EditText) findViewById(R.id.tipoTxt2);
        qtdT= (EditText) findViewById(R.id.qtdTxt2);
        precoT= (EditText) findViewById(R.id.precoTxt2);
        taxasT= (EditText) findViewById(R.id.taxasTxt2);
        corretoraT= (EditText) findViewById(R.id.corretoraTxt2);


        usuT.setText(String.valueOf(bundle.getInt("id_usuario")));
        acT.setText(String.valueOf(bundle.getInt("id_acao")));
        dataT.setText(bundle.getString("data"));
        tipoT.setText(bundle.getString("tipo"));
        qtdT.setText(String.valueOf(bundle.getInt("quantidade")));
        precoT.setText(String.valueOf(bundle.getDouble("preco")));
        taxasT.setText(String.valueOf(bundle.getDouble("taxas")));
        corretoraT.setText(bundle.getString("corretora"));



    }

    public void alterarTransacao(View v){
        try {
            bean = new Transacao();

            bean.setId(bundle.getInt("_id"));

            bean.setIdU(Integer.valueOf(usuT.getText().toString()));
            bean.setIdA(Integer.valueOf(acT.getText().toString()));

            bean.setData(dataT.getText().toString());
            bean.setTipo(tipoT.getText().toString());
            bean.setQtd(Integer.parseInt(qtdT.getText().toString()));
            bean.setPreco(Double.parseDouble(precoT.getText().toString()));
            bean.setTaxas(Double.parseDouble(taxasT.getText().toString()));

            bean.setCorretora(corretoraT.getText().toString());


            controller = new ControleTransacao(this);
            String resposta = controller.alterar(bean);
            Toast.makeText(this, resposta, Toast.LENGTH_SHORT).show();
            intent = new Intent(EditaTransacao.this, Menu.class);
            this.startActivity(intent);
            finish();
        }
        catch(Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public void cancelarAlteracaoTransacao(View v) {
        intent = new Intent(EditaTransacao.this, Menu.class);
        this.startActivity(intent);
        finish();
    }
}