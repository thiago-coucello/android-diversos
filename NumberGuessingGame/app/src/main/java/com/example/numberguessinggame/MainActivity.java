package com.example.numberguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void guessTheNumber(View view){
        Intent intent = new Intent(this, GuesTheNumber.class);
        startActivity(intent);
    }
    public void soundPainel(View view){
        Intent painel_sons = new Intent(this, Sound_Painel.class);
        startActivity(painel_sons);
    }
}
