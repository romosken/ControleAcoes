package com.example.acoesmobile.view.acao;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.acoesmobile.bean.Acao;
import com.example.acoesmobile.controller.ControleAcao;
import com.example.acoesmobile.R;


public class ListaAcao extends AppCompatActivity {

    ListView lista;
    Acao bean;
    ControleAcao controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_acao);
        lista = (ListView) findViewById(R.id.listViewAcao);
        this.carregarDados();
    }

    protected void carregarDados() {
        try {
            bean = new Acao();
            controller = new ControleAcao(this);
            final Cursor cursor = controller.listar(bean);
            String[] nomeCampos = {"_id", "ticker", "empresa", "cotacao"};
            int[] idViewLayout = {R.id.idAcaoLayout, R.id.tickerAcaoLayout, R.id.empresaAcaoLayout, R.id.cotacaoAcaoLayout};
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(), R.layout.acao_layout, cursor, nomeCampos, idViewLayout, 0);
            lista.setAdapter(adapter);

            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long idx) {
                    int codigo;
                    cursor.moveToPosition(posicao);
                    codigo = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                    Intent tela = new Intent(ListaAcao.this, VerAcao.class);
                    tela.putExtra("_id", codigo);
                    startActivity(tela);
                }
            });
        }
        catch(Exception e) {
            System.out.println("ERRO ---> " + e.getMessage());
        }
    }
}