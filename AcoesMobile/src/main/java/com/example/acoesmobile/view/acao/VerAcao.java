package com.example.acoesmobile.view.acao;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.acoesmobile.R;
import com.example.acoesmobile.bean.Acao;
import com.example.acoesmobile.controller.ControleAcao;
import com.example.acoesmobile.view.Menu;

public class VerAcao extends AppCompatActivity {

    Intent intent;
    Acao bean;
    ControleAcao controller;
    TextView verId, verTicker, verEmpresa, verCotacao;
    int codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_acao);

        this.carregarDados();
    }

    public void carregarDados() {
        try {

            intent = getIntent();
            codigo = intent.getExtras().getInt("_id");

            verId = findViewById(R.id.verIdAcao);
            verTicker = findViewById(R.id.verTickerAcao);
            verEmpresa = findViewById(R.id.verEmpresaAcao);
            verCotacao = findViewById(R.id.verCotacaoAcao);


            bean = new Acao();
            bean.setId(codigo);
            controller = new ControleAcao(getBaseContext());
            Cursor cursor = controller.buscar(bean);

            bean.setId(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
            verId.setText(verId.getText().toString() + bean.getId());
            bean.setTicker(cursor.getString(cursor.getColumnIndexOrThrow("ticker")));
            verTicker.setText(verTicker.getText().toString() + bean.getTicker());
            bean.setEmpresa(cursor.getString(cursor.getColumnIndexOrThrow("empresa")));

            verEmpresa.setText(verEmpresa.getText().toString() + bean.getEmpresa());
            bean.setCotacao(cursor.getDouble(cursor.getColumnIndexOrThrow("cotacao")));
            verCotacao.setText(verCotacao.getText().toString() + bean.getCotacao());

        }
        catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void editarAcao(View v) {
        intent = new Intent(VerAcao.this, EditaAcao.class);
        intent.putExtra("_id", bean.getId());
        intent.putExtra("ticker", bean.getTicker());
        intent.putExtra("empresa",bean.getEmpresa());
        intent.putExtra("cotacao", bean.getCotacao());

        this.startActivity(intent);
    }

    public void removerAcao(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja remover esse evento?")
                .setPositiveButton("SIM!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        try {
                            bean = new Acao();
                            bean.setId(codigo);
                            controller = new ControleAcao(getBaseContext());
                            String resultado = controller.remover(bean);
                            Toast.makeText(getBaseContext(), resultado, Toast.LENGTH_SHORT).show();
                            intent = new Intent(VerAcao.this, Menu.class);
                            startActivity(intent);
                        }
                        catch (Exception e) {
                            System.out.println("ERRO: " + e.getMessage());
                        }
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getBaseContext(), "Ação cancelada com sucesso!", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void novaAcao(View v) {
        intent = new Intent(VerAcao.this, CriaAcao.class);
        this.startActivity(intent);
    }
}