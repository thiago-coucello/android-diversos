package com.example.quemessepokemon.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quemessepokemon.R;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void novaActivity (View view){
        Intent intent = new Intent(this, Quem_Eh_Esse_Pokemon.class);
        startActivity(intent);

    }
}
