package com.example.quemessepokemon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Quem_Eh_Esse_Pokemon extends AppCompatActivity {

    private MediaPlayer mediaPlayer = new MediaPlayer();
    private String[] pokemons = {
            "pikachu",
            "bunnelby",
            "bulbasaur",
            "caterpie",
            "charmander",
            "squirtle",
            "weedle",
            "pidgey",
            "rattata",
            "jigglypuff",
            "spearow",
            "ekans",
            "sandshrew",
            "clefairy"
    };
    public int resposta;
    public int acertos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quem__eh__esse__pokemon);
        novoJogo();
        tocarMusica();
    }

    public void adivinharPokemon (View view) {
        String r;
        ImageView imagem = findViewById(R.id.pokemon);
        TextView resp = findViewById(R.id.resposta);
        r = resp.getText().toString().toLowerCase();
        if (r.equals(pokemons[resposta])) {
            acertos++;
            switch (resposta) {
                case 0: {
                    Toast.makeText(this, "Parabéns você acertou", Toast.LENGTH_SHORT).show();
                    imagem.setImageResource(R.drawable.pikachu);
                    break;
                }
                case 1: {
                    Toast.makeText(this, "Parabéns você acertou", Toast.LENGTH_SHORT).show();
                    imagem.setImageResource(R.drawable.bunnelby);
                    break;
                }
                case 2: {
                    Toast.makeText(this, "Parabéns você acertou", Toast.LENGTH_SHORT).show();
                    imagem.setImageResource(R.drawable.bulbasaur);
                    break;
                }
                case 3: {
                    Toast.makeText(this, "Parabéns você acertou", Toast.LENGTH_SHORT).show();
                    imagem.setImageResource(R.drawable.caterpie);
                    break;
                }
                case 4: {
                    Toast.makeText(this, "Parabéns você acertou", Toast.LENGTH_SHORT).show();
                    imagem.setImageResource(R.drawable.charmander);
                    break;
                }
                case 5: {
                    Toast.makeText(this, "Parabéns você acertou", Toast.LENGTH_SHORT).show();
                    imagem.setImageResource(R.drawable.squirtle);
                    break;
                }
                case 6: {
                    Toast.makeText(this, "Parabéns você acertou", Toast.LENGTH_SHORT).show();
                    imagem.setImageResource(R.drawable.weedle);
                    break;
                }
                case 7: {
                    Toast.makeText(this, "Parabéns você acertou", Toast.LENGTH_SHORT).show();
                    imagem.setImageResource(R.drawable.pidgey);
                    break;
                }
                case 8: {
                    Toast.makeText(this, "Parabéns você acertou", Toast.LENGTH_SHORT).show();
                    imagem.setImageResource(R.drawable.rattata);
                    break;
                }
                case 9:{
                    Toast.makeText(this, "Parabéns você acertou", Toast.LENGTH_SHORT).show();
                    imagem.setImageResource(R.drawable.jigglypuff);
                    break;
                }
                case 10:{
                    Toast.makeText(this, "Parabéns você acertou", Toast.LENGTH_SHORT).show();
                    imagem.setImageResource(R.drawable.spearow);
                    break;
                }
                case 11:{
                    Toast.makeText(this, "Parabéns você acertou", Toast.LENGTH_SHORT).show();
                    imagem.setImageResource(R.drawable.ekans);
                    break;
                }
                case 12:{
                    Toast.makeText(this, "Parabéns você acertou", Toast.LENGTH_SHORT).show();
                    imagem.setImageResource(R.drawable.sandshrew);
                    break;
                }
                case 13:{
                    Toast.makeText(this, "Parabéns você acertou", Toast.LENGTH_SHORT).show();
                    imagem.setImageResource(R.drawable.clefairy);
                    break;
                }
            }
            new CountDownTimer(2000,1000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    randomizar();
                    tocarMusica();
                }
            }.start();
        }
        else{
            perdeu();
        }
    }

    public void randomizar(){
        resposta = new Random().nextInt(pokemons.length);
        ImageView imagem = findViewById(R.id.pokemon);
        TextView text = findViewById(R.id.resposta);
        text.setText(R.string.blank);

        switch(resposta){
            case 0:{
                imagem.setImageResource(R.drawable.pikachu_negro);
                break;
            }
            case 1:{
                imagem.setImageResource(R.drawable.bunnelby_negro);
                break;
            }
            case 2: {
                imagem.setImageResource(R.drawable.bulbasaur_negro);
                break;
            }
            case 3:{
                imagem.setImageResource(R.drawable.caterpie_negro);
                break;
            }
            case 4:{
                imagem.setImageResource(R.drawable.charmander_negro);
                break;
            }
            case 5:{
                imagem.setImageResource(R.drawable.squirtle_negro);
                break;
            }
            case 6:{
                imagem.setImageResource(R.drawable.weedle_negro);
                break;
            }
            case 7:{
                imagem.setImageResource(R.drawable.pidgey_negro);
                break;
            }
            case 8:{
                imagem.setImageResource(R.drawable.rattata_negro);
                break;
            }
            case 9:{
                imagem.setImageResource(R.drawable.jigglypuff_negro);
                break;
            }
            case 10:{
                imagem.setImageResource(R.drawable.spearow_negro);
                break;
            }
            case 11: {
                imagem.setImageResource(R.drawable.ekans_negro);
                break;
            }
            case 12:{
                imagem.setImageResource(R.drawable.sandshrew_negro);
                break;
            }
            case 13:{
                imagem.setImageResource(R.drawable.clefairy_negro);
                break;
            }
        }
    }

    public void novoJogo(){
        resposta = new Random().nextInt(pokemons.length);
        ImageView imagem = findViewById(R.id.pokemon);
        TextView text = findViewById(R.id.resposta);
        text.setText(R.string.blank);
        acertos = 0;

        switch(resposta){
            case 0:{
                imagem.setImageResource(R.drawable.pikachu_negro);
                break;
            }
            case 1:{
                imagem.setImageResource(R.drawable.bunnelby_negro);
                break;
            }
            case 2: {
                imagem.setImageResource(R.drawable.bulbasaur_negro);
                break;
            }
            case 3:{
                imagem.setImageResource(R.drawable.caterpie_negro);
                break;
            }
            case 4:{
                imagem.setImageResource(R.drawable.charmander_negro);
                break;
            }
            case 5:{
                imagem.setImageResource(R.drawable.squirtle_negro);
                break;
            }
            case 6:{
                imagem.setImageResource(R.drawable.weedle_negro);
                break;
            }
            case 7:{
                imagem.setImageResource(R.drawable.pidgey_negro);
                break;
            }
            case 8: {
                imagem.setImageResource(R.drawable.rattata_negro);
                break;
            }
            case 9:{
                imagem.setImageResource(R.drawable.jigglypuff_negro);
                break;
            }
            case 10:{
                imagem.setImageResource(R.drawable.spearow_negro);
                break;
            }
            case 11:{
                imagem.setImageResource(R.drawable.ekans_negro);
                break;
            }
            case 12:{
                imagem.setImageResource(R.drawable.sandshrew_negro);
                break;
            }
            case 13:{
                imagem.setImageResource(R.drawable.clefairy_negro);
                break;
            }
        }
    }

    public void novoJogoConfirmacao (View view){
        android.app.AlertDialog.Builder builderNovoJogo = new AlertDialog.Builder(this);
        builderNovoJogo.setTitle(R.string.NovoJogoTitle);
        builderNovoJogo.setMessage(R.string.NovoJogoDescription);
        builderNovoJogo.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                novoJogo();
                tocarMusica();
                Toast.makeText(Quem_Eh_Esse_Pokemon.this, "Novo Jogo criado", Toast.LENGTH_SHORT).show();
            }
        });
        builderNovoJogo.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Quem_Eh_Esse_Pokemon.this, "Você desistiu de criar um novo jogo", Toast.LENGTH_SHORT).show();
            }
        });
        builderNovoJogo.show();
    }

    public void tocarMusica (){
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.quem_eh_esse_pokemon );
        mediaPlayer.start();

    }

    public void perdeu(){
        android.app.AlertDialog.Builder builderPerdeu = new AlertDialog.Builder(this);
        builderPerdeu.setTitle("Você Perdeu");
        builderPerdeu.setMessage("Sinto muito, a resposta era: "+pokemons[resposta] +
                " você acertou " + acertos + " vezes consecutivas. Deseja começar um novo jogo?");
        builderPerdeu.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                novoJogo();
                tocarMusica();
                Toast.makeText(Quem_Eh_Esse_Pokemon.this, "Novo Jogo criado", Toast.LENGTH_SHORT).show();
            }
        });
        builderPerdeu.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Quem_Eh_Esse_Pokemon.this, "Você desistiu de criar um novo jogo", Toast.LENGTH_SHORT).show();
            }
        });
        builderPerdeu.show();
    }
}