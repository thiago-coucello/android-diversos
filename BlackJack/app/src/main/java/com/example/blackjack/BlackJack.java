package com.example.blackjack;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BlackJack extends AppCompatActivity {

    public int qntd_cartas = 0;
    public int soma = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_jack);
    }

    public void novaCarta(View view){
        Button button = findViewById(R.id.Nova_Carta);
        qntd_cartas++;
        ImageView carta = findViewById(R.id.Carta);
        carta.setVisibility(View.VISIBLE);
        button.setClickable(false);
    }

    public void outraCarta(){
        qntd_cartas++;
        ImageView carta = findViewById(R.id.Carta);
        carta.setImageResource(R.drawable.costa_baralho);
        carta.setVisibility(View.VISIBLE);
    }

    public void virarCarta(View view){
        AlertDialog.Builder carta_virada = new AlertDialog.Builder(this);
        switch (qntd_cartas){
            case 1:{
                carta_virada.setTitle("Você virou uma carta:");
                carta_virada.setMessage("Eu quero que você saiba, que é uma pessoa muito incrivel pra mim");
                carta_virada.setNeutralButton("Próxima carta", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        outraCarta();
                    }
                }); carta_virada.show();
                Toast.makeText(this, "Valor da carta = 2", Toast.LENGTH_SHORT).show();
                soma += 2;
                break;
            }
            case 2:{
                carta_virada.setTitle("Você virou uma carta:");
                carta_virada.setMessage("Eu quero que você saiba, que foi a primeira pessoa que " +
                        "realmente quis algo a mais comigo, e não teve medo de correr atrás de mim " +
                        "(mesmo eu enrolando você por um tempo, mas você sabe que foi pra deixar tudo certo)");
                carta_virada.setNeutralButton("Próxima carta", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        outraCarta();
                    }
                });carta_virada.show();
                Toast.makeText(this, "Valor da carta = 1", Toast.LENGTH_SHORT).show();
                soma += 1;
                break;
            }
            case 3:{
                carta_virada.setTitle("Você virou uma carta:");
                carta_virada.setMessage("Saiba que eu adoro cada momento ao seu lado, irritar você brincando com o Ludson, " +
                        "fazer você se arrepiar beijando seu pescoço, só ficar olhando pra você já é o suficiente pra deixar meu dia feliz. " +
                        "Eu realmente sinto sua falta quando você não vai para a faculdade (então evite fazer isso :P)");
                carta_virada.setNeutralButton("Próxima carta", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        outraCarta();
                    }
                });carta_virada.show();
                Toast.makeText(this, "Valor da carta = 08", Toast.LENGTH_SHORT).show();
                soma += 8;
                break;
            }
            case 4:{
                carta_virada.setTitle("Você virou uma carta:");
                carta_virada.setMessage("Pode não parecer mas eu realmente sou muito inseguro quanto as" +
                        " pessoas gostarem ou não de mim, mas pode ter certeza, várias coisas boas me aconteceram esse ano" +
                        " e eu afirmo sem dúvidas e sem arrependimento, que namorar você foi a melhor delas");
                carta_virada.setNeutralButton("Amo você", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        amo_voce();
                    }
                });carta_virada.show();
                Toast.makeText(this, "Valor da carta = 10 (Porque você é a minha 10/10)", Toast.LENGTH_SHORT).show();
                soma += 10;
                break;
            }
        }
        TextView resultado = findViewById(R.id.Soma);
        resultado.setText("Soma: "+ soma);
        if(qntd_cartas == 4){
            qntd_cartas = 0;
            soma = 0;
        }
    }

    private void amo_voce() {
        Intent intent = new Intent(this, Amo_Voce.class);
        startActivity(intent);
    }
}
