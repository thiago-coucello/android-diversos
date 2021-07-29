package com.example.blackjack;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aviso();
    }

    public void start(View view){
        Intent intent = new Intent(this,BlackJack.class);
        startActivity(intent);
    }

    public void aviso(){
        AlertDialog.Builder instrucao = new AlertDialog.Builder(this);
        instrucao.setTitle("INSTRUÇÃO");
        instrucao.setMessage("Para jogar BlackJack, você deve puxar cartas até a soma de seus valores " +
                "chegar o mais próximo possivel de 21. Ao clicar em 'próxima carta' a próxima carta já é" +
                " puxada automaticamente, só restando clicar nela para ver seu valor.");
        instrucao.setNeutralButton("Entendido", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        instrucao.show();
    }
}
