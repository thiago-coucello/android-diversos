package com.example.frases_do_dia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class JogoNormal extends AppCompatActivity {

    public Bundle parametros_recebidos = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_normal);

        parametros_recebidos = getIntent().getExtras();

    }

    public void OpcaoTriste(View view){
        parametros_recebidos.putInt("opcao", 1);

        ChamarFrase();
    }

    public void OpcaoNervoso(View view){
        parametros_recebidos.putInt("opcao",2);

        ChamarFrase();
    }

    public void OpcaoFrase (View view){
        parametros_recebidos.putInt("opcao",3);

        ChamarFrase();
    }

    public void OpcaoSaudade (View view){
        parametros_recebidos.putInt("opcao",4);

        ChamarFrase();
    }

    public void OpcaoSozinho (View view){
        parametros_recebidos.putInt("opcao",5);

        ChamarFrase();
    }

    public void Retorno (View view){
        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtras(parametros_recebidos);

        startActivity(intent);

    }

    public void ChamarFrase (){
        Intent intent = new Intent(this,Frases.class);

        intent.putExtras(parametros_recebidos);

        startActivity(intent);
    }

}
