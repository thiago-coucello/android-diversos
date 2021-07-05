package com.teste.gridview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DiffUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gvTeste;
    AdapterGrid adapter;
    ArrayList<Botao> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentes();
        preencherLista();

        adapter = new AdapterGrid(lista, getApplicationContext());

        gvTeste.setAdapter(adapter);
        gvTeste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Botao botao = lista.get(position);
                Toast.makeText(MainActivity.this, "x = " + botao.getX() + " y = " + botao.getY(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void preencherLista() {
        Botao botao = new Botao(R.drawable.ic_baseline_add_24, 0, 0);
        lista.add(botao);
        botao = new Botao(R.drawable.ic_baseline_add_24, 0, 1);
        lista.add(botao);
        botao = new Botao(R.drawable.ic_baseline_add_24, 0, 2);
        lista.add(botao);
        
    }

    private void inicializarComponentes() {
        gvTeste = findViewById(R.id.gvTeste);
    }
}