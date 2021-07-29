package com.example.quemessepokemon.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quemessepokemon.Classes.Pokemon;
import com.example.quemessepokemon.R;

import java.util.Random;

import dmax.dialog.SpotsDialog;

public class Quem_Eh_Esse_Pokemon extends AppCompatActivity {

    private MediaPlayer mediaPlayer = new MediaPlayer();
    private int acertos;
    private Pokemon pokemon;
    private ImageView imagem;
    private TextView txtAcertos;
    private EditText txtResposta;
    private Button btnEnviarResposta, btnNewGame, btnExit;
    private int idColorida, idSombra;
    private AlertDialog dialog;
    private Activity activity = this;

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quem__eh__esse__pokemon);

        inicializarComponentes();
        novoJogo();
        tocarMusica();

        btnEnviarResposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resposta = txtResposta.getText().toString().toLowerCase();
                if(resposta.equals(pokemon.getNome())) {
                    acertos++;
                    imagem.setImageResource(idColorida);
                    btnEnviarResposta.setClickable(false);
                    Toast.makeText(Quem_Eh_Esse_Pokemon.this, "Parabens, você acertou! N° " + pokemon.getNumero(), Toast.LENGTH_SHORT).show();

                    new CountDownTimer(2000, 1000) {
                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            novoJogo();
                        }
                    }.start();
                }
                else{
                    perdeu();
                }
            }
        });

        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novoJogoConfirmacao();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();

    }
  //*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_quem__eh__esse__pokemon);

        dialog = new SpotsDialog.Builder()
                .setContext(this)
                .setMessage("Criando novo jogo")
                .build();
        dialog.show();

        new CountDownTimer(1500, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                dialog.dismiss();
            }
        }.start();

        inicializarComponentes();
        novoJogo();
        tocarMusica();

        btnEnviarResposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resposta = txtResposta.getText().toString().toLowerCase();
                if(resposta.equals(pokemon.getNome())) {
                    acertos++;
                    imagem.setImageResource(idColorida);
                    btnEnviarResposta.setClickable(false);
                    Toast.makeText(Quem_Eh_Esse_Pokemon.this, "Parabens, você acertou! N° " + pokemon.getNumero(), Toast.LENGTH_SHORT).show();

                    new CountDownTimer(2000, 1000) {
                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            novoJogo();
                        }
                    }.start();
                }
                else{
                    perdeu();
                }
            }
        });

        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novoJogoConfirmacao();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        txtResposta.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                btnEnviarResposta.performClick();
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);

                View view = activity.getCurrentFocus();

                if(view == null){
                    view = new View(activity);
                }

                assert imm != null;
                imm.hideSoftInputFromWindow(view.getWindowToken(),0);

                return true;
            }
        });
    }

    public void novoJogo(){
        btnEnviarResposta.setClickable(true);
        txtAcertos.setText("Acertos: " + String.format("%d",acertos));
        txtResposta.setText(R.string.blank);

        int numero = new Random().nextInt(115);
        pokemon = new Pokemon(numero);

        idColorida = getResources().getIdentifier(pokemon.getNomeImagem(), "drawable", getPackageName());
        idSombra = getResources().getIdentifier(pokemon.getNomeImagem() + "_negro", "drawable", getPackageName());

        imagem.setImageResource(idSombra);
    }

    public void novoJogoConfirmacao (){
        android.app.AlertDialog.Builder builderNovoJogo = new AlertDialog.Builder(this);
        builderNovoJogo.setTitle(R.string.NovoJogoTitle);
        builderNovoJogo.setMessage(R.string.NovoJogoDescription);
        builderNovoJogo.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                acertos = 0;
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

    public void perdeu(){
        android.app.AlertDialog.Builder builderPerdeu = new AlertDialog.Builder(this);
        builderPerdeu.setTitle("Você Perdeu");
        builderPerdeu.setMessage("Sinto muito, a resposta era: "+pokemon.getNome() + ", N° " + pokemon.getNumero() + ". Você acertou " + String.format("%d",acertos) +
               ". Deseja começar um novo jogo?");
        builderPerdeu.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                acertos = 0;
                novoJogo();
                tocarMusica();
                Toast.makeText(Quem_Eh_Esse_Pokemon.this, "Novo Jogo criado", Toast.LENGTH_SHORT).show();
            }
        });
        builderPerdeu.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Quem_Eh_Esse_Pokemon.this, "Você desistiu de criar um novo jogo", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        builderPerdeu.show();
    }

    public void tocarMusica (){
        float volume = (float) 0.15;
        mediaPlayer.setVolume(volume,volume);
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.quem_eh_esse_pokemon );
        mediaPlayer.start();

    }

    public void inicializarComponentes(){
        imagem = findViewById(R.id.pokemon);

        txtResposta = findViewById(R.id.resposta);
        txtAcertos = findViewById(R.id.edtCronometro);

        btnNewGame = findViewById(R.id.btnNewGame);
        btnExit = findViewById(R.id.btnExit);
        btnEnviarResposta = findViewById(R.id.btnEnviarResposta);

        acertos = 0;
    }

}