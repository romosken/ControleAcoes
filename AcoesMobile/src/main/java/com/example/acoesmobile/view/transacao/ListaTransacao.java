package com.example.acoesmobile.view.transacao;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.acoesmobile.R;
import com.example.acoesmobile.bean.Transacao;
import com.example.acoesmobile.controller.ControleTransacao;


public class ListaTransacao extends AppCompatActivity {

    ListView lista;
    Transacao bean;
    ControleTransacao controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_transacao);
        lista = (ListView) findViewById(R.id.listViewTransacao);
        this.carregarDados();
    }

    protected void carregarDados() {
        try {
            bean = new Transacao();
            controller = new ControleTransacao(this);
            final Cursor cursor = controller.listar();
            String[] nomeCampos = {"_id", "id_usuario", "id_acao", "papel","data","tipo","quantidade","preco","taxas","valorOperacao","valorLiquido","lucro","corretora"};
            int[] idViewLayout = {R.id.idTransacaoLayout, R.id.usuarioTransacaoLayout, R.id.acaoTransacaoLayout, R.id.papelTransacaoLayout,R.id.dataTransacaoLayout,R.id.tipoTransacaoLayout,R.id.qtdTransacaoLayout,R.id.precoTransacaoLayout,R.id.taxasTransacaoLayout,R.id.valorOpTransacaoLayout,R.id.valorLiTransacaoLayout,R.id.lucroTransacaoLayout,R.id.corretoraTransacaoLayout};
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(), R.layout.transacao_layout, cursor, nomeCampos, idViewLayout, 0);
            lista.setAdapter(adapter);

            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long idx) {
                    int codigo;
                    cursor.moveToPosition(posicao);
                    codigo = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                    Intent tela = new Intent(ListaTransacao.this, VerTransacao.class);
                    tela.putExtra("_id", codigo);
                    startActivity(tela);
                }
            });
        }
        catch(Exception e) {
            System.out.println("ERRO => " + e.getMessage());
        }
    }
}