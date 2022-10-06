package com.example.acoesmobile.view.transacao;

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
import com.example.acoesmobile.bean.Transacao;
import com.example.acoesmobile.controller.ControleAcao;
import com.example.acoesmobile.controller.ControleTransacao;
import com.example.acoesmobile.view.Menu;

import java.sql.SQLException;

public class VerTransacao extends AppCompatActivity {

    Intent intent;
    Transacao bean;
    ControleTransacao controller;
    TextView verId,usu, ac,papel, data, tipo, qtd, preco, taxas, vOp,vLi,lucro,corretora;
    int codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_transacao);

        this.carregarDados();
    }

    public void carregarDados() {
        try {

            intent = getIntent();
            codigo = intent.getExtras().getInt("_id");

            verId = findViewById(R.id.verIdTransacao);
            usu = findViewById(R.id.verUsuarioTransacao);
            ac = findViewById(R.id.verAcaoTransacao);
            papel = findViewById(R.id.verPapelTransacao);
            data = findViewById(R.id.verDataTransacao);
            tipo = findViewById(R.id.verTipoTransacao);
            qtd = findViewById(R.id.verQtdTransacao);
            preco = findViewById(R.id.verPrecoTransacao);
            taxas = findViewById(R.id.verTaxasTransacao);
            vOp = findViewById(R.id.verValorOpTransacao);
            vLi = findViewById(R.id.verValorLiTransacao);
            lucro = findViewById(R.id.verLucroTransacao);
            corretora = findViewById(R.id.verCorretoraTransacao);



            bean = new Transacao();
            bean.setId(codigo);
            controller = new ControleTransacao(getBaseContext());
            Cursor cursor = controller.buscar(bean);

            bean.setId(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
            verId.setText(verId.getText().toString() + bean.getId());
            bean.setIdU(cursor.getInt(cursor.getColumnIndexOrThrow("id_usuario")));
            usu.setText(usu.getText().toString() + bean.getIdU());
            bean.setIdA(cursor.getInt(cursor.getColumnIndexOrThrow("id_acao")));
            ac.setText(ac.getText().toString() + bean.getIdA());

            bean.setPapel(cursor.getString(cursor.getColumnIndexOrThrow("papel")));
            papel.setText(papel.getText().toString() + bean.getPapel());

            bean.setData(cursor.getString(cursor.getColumnIndexOrThrow("data")));
            data.setText(data.getText().toString() + bean.getData());

            bean.setTipo(cursor.getString(cursor.getColumnIndexOrThrow("tipo")));
            tipo.setText(tipo.getText().toString() + bean.getTipo());

            bean.setQtd(cursor.getInt(cursor.getColumnIndexOrThrow("quantidade")));
            qtd.setText(qtd.getText().toString() + bean.getQtd());

            bean.setPreco(cursor.getDouble(cursor.getColumnIndexOrThrow("preco")));
            preco.setText(preco.getText().toString() + bean.getPreco());

            bean.setTaxas(cursor.getDouble(cursor.getColumnIndexOrThrow("taxas")));
            taxas.setText(taxas.getText().toString() + bean.getTaxas());


            vOp.setText(vOp.getText().toString() + bean.getValorOpe());

            vLi.setText(vLi.getText().toString() + bean.getValorLiq());


            lucro.setText(lucro.getText().toString() + bean.getLucro());

            bean.setCorretora(cursor.getString(cursor.getColumnIndexOrThrow("corretora")));
            corretora.setText(corretora.getText().toString() + bean.getCorretora());

        }
        catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void editarTransacao(View v) throws Exception {
        intent = new Intent(VerTransacao.this, EditaTransacao.class);

        intent.putExtra("_id", bean.getId());
        intent.putExtra("id_usuario", bean.getIdU());
        intent.putExtra("id_acao", bean.getIdA());
        intent.putExtra("data", bean.getData());
        intent.putExtra("tipo", bean.getTipo());
        intent.putExtra("quantidade", bean.getQtd());
        intent.putExtra("preco", bean.getPreco());
        intent.putExtra("taxas", bean.getTaxas());
        intent.putExtra("corretora", bean.getCorretora());

        this.startActivity(intent);
    }

    public void removerTransacao(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja remover essa transação?")
                .setPositiveButton("SIM!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        try {
                            bean = new Transacao();
                            bean.setId(codigo);
                            controller = new ControleTransacao(getBaseContext());
                            String resultado = controller.remover(bean);
                            Toast.makeText(getBaseContext(), resultado, Toast.LENGTH_SHORT).show();
                            intent = new Intent(VerTransacao.this, Menu.class);
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

    public void novaTransacao(View v) {
        intent = new Intent(VerTransacao.this, CriaTransacao.class);
        this.startActivity(intent);
    }
}