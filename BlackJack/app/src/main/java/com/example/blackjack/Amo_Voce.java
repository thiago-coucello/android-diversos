package com.example.blackjack;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Amo_Voce extends AppCompatActivity {

    public int amei = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amo__voce);
        Toast.makeText(this, "Foi o melhor mês da minha vida", Toast.LENGTH_SHORT).show();
        amar();
    }

    public void amar(){
        amei++;
        ConstraintLayout fundo = findViewById(R.id.Fundo);
        fundo.setVisibility(View.VISIBLE);
        switch(amei){
            case 1: {
                fundo.setBackgroundResource(R.drawable.amo_voce_1);
                break;
            }
            case 2: {
                fundo.setBackgroundResource(R.drawable.foto2);
                break;
            }
            case 3: {
                fundo.setBackgroundResource(R.drawable.foto3);
                break;
            }
            case 4:{
                fundo.setBackgroundResource(R.drawable.amo_voce_2);
                break;
            }
            case 5:{
                fundo.setBackgroundResource(R.drawable.foto4);
                break;
            }
            case 6:{
                fundo.setBackgroundResource(R.drawable.foto5);
                break;
            }
            case 7:{
                fundo.setBackgroundResource(R.drawable.amo_voce_3);
                break;
            }
            case 8:{
                fundo.setBackgroundResource(R.drawable.foto6);
                break;
            }
            case 9:{
                fundo.setBackgroundResource(R.drawable.foto7);
                break;
            }
            case 10:{
                fundo.setBackgroundResource(R.drawable.amo_voce_4);
                break;
            }
            case 11:{
                fundo.setBackgroundResource(R.drawable.foto8);
                break;
            }
            case 12:{
                fundo.setBackgroundResource(R.drawable.amo_voce_5);
                break;
            }
        }
        if(amei == 12){
            amei = 0;
            Toast.makeText(this, "Eu sou sua estrela do mar", Toast.LENGTH_SHORT).show();
        }
        CountDownTimer timer = new CountDownTimer(4000,1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                amar();
            }
        };
        timer.start();
    }
}
