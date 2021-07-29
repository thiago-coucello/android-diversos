package com.example.quemessepokemon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.alert_title);
        builder.setMessage(R.string.alert_description);
        builder.setPositiveButton(R.string.entendido, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.show();

    }

    public void novaActivity (View view){
        Intent intent = new Intent(this, Quem_Eh_Esse_Pokemon.class);
        startActivity(intent);

    }
}
