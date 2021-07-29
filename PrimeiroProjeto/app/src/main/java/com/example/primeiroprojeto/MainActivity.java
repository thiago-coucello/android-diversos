package com.example.primeiroprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alterarTexto (View view){
        int numero = new Random().nextInt(11);
        TextView texto = findViewById(R.id.resultadoJogo);
        texto.setText("Número selecionado: " + numero);
    }

}
