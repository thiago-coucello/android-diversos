package com.example.numberguessinggame;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Sound_Painel extends AppCompatActivity {

    private MediaPlayer mediaPlayer = new MediaPlayer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound__painel);

    }

    public void tocarMusica1 (View view) {
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.coracao_de_estudante);
        mediaPlayer.start();
        Toast.makeText(this, "coração de estudante", Toast.LENGTH_SHORT).show();

    }
    public void tocarMusica2 (View view){
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.aquarela);
        mediaPlayer.start();
        Toast.makeText(this, "Aquarela", Toast.LENGTH_SHORT).show();

    }
    public void tocarMusica3 (View view){
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.catedral);
        mediaPlayer.start();
        Toast.makeText(this, "Catedral", Toast.LENGTH_SHORT).show();

    }
    public void tocarMusica4 (View view){
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.como_eu_quero);
        mediaPlayer.start();
        Toast.makeText(this, "Como eu Quero", Toast.LENGTH_SHORT).show();

    }
    public void tocarMusica5 (View view){
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.de_volta_pro_aconchego);
        mediaPlayer.start();
        Toast.makeText(this, "De Volta pro Aconchego", Toast.LENGTH_SHORT).show();

    }
    public void tocarMusica6 (View view){
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.o_bebado_e_a_equilibrista);
        mediaPlayer.start();
        Toast.makeText(this, "O Bêbado e a Equilibrista", Toast.LENGTH_SHORT).show();

    }
    public void tocarMusica7 (View view){
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.saigon);
        mediaPlayer.start();
        Toast.makeText(this, "Saigon", Toast.LENGTH_SHORT).show();

    }
    public void tocarMusica8 (View view){
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.quem_eh_esse_pokemon );
        mediaPlayer.start();
        Toast.makeText(this, "It's a Secret", Toast.LENGTH_SHORT).show();

    }

    public void buttonR (View view){
        Toast.makeText(this, "Não consegui fazer essa merda funcionar ainda, calma o coração", Toast.LENGTH_SHORT).show();
    }

    public void parar(View view){
        mediaPlayer.stop();
        Toast.makeText(this, "Parando...", Toast.LENGTH_SHORT).show();
    }

    public void pausar(View view){
        mediaPlayer.pause();
        Toast.makeText(this, "Pausando...", Toast.LENGTH_SHORT).show();
    }

    public void play(View view){
        mediaPlayer.start();
        if(mediaPlayer.isPlaying()){
            Toast.makeText(this, "Voltando a reproduzir...", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Sem música para reproduzir...", Toast.LENGTH_SHORT).show();
        }
    }
}
