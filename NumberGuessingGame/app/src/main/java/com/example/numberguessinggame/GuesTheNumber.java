package com.example.numberguessinggame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GuesTheNumber extends AppCompatActivity {

    private int secret_number;
    private int attempts_number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gues_the_number);
        secret_number = (int) (Math.random() * 100);

    }

    public void processingGuess(View view){
        EditText editText = findViewById(R.id.inputGuess);
        TextView gameResult1 = findViewById(R.id.gameResult1);
        TextView gameAttempts = findViewById(R.id.number_of_attempts);
        TextView textAttempts = findViewById(R.id.attempts);

        gameResult1.setText(R.string.blank_space);
        textAttempts.setText(R.string.blank_space);
        gameAttempts.setText(R.string.blank_space);

        String str_numberAttempts;
        String str_guessed = editText.getText().toString();
        int number_guessed = Integer.valueOf(str_guessed);
        if(editText.getText().toString() != null) {

            if (number_guessed > secret_number) {
                gameResult1.setText(R.string.too_high);
                editText.setText(R.string.blank_space);
                attempts_number++;

            } else if (number_guessed < secret_number) {
                gameResult1.setText(R.string.too_low);
                editText.setText(R.string.blank_space);
                attempts_number++;

            } else {
                attempts_number++;
                gameResult1.setText(R.string.you_win);
                str_numberAttempts = String.valueOf(attempts_number);
                gameAttempts.setText(str_numberAttempts);
                textAttempts.setText(R.string.attempts);
            }
        }
        else{
            Toast.makeText(this, "Você não vai tentar adivinhar?", Toast.LENGTH_SHORT).show();
        }
    }

    public void newGame() {
        secret_number = (int) (Math.random()*100);
        EditText editText = findViewById(R.id.inputGuess);
        TextView gameResult1 = findViewById(R.id.gameResult1);
        editText.setText(R.string.blank_space);
        gameResult1.setText(R.string.blank_space);
        attempts_number = 0;
        TextView gameAttempts = findViewById(R.id.number_of_attempts);
        TextView textAttempts = findViewById(R.id.attempts);
        gameAttempts.setText(R.string.blank_space);
        textAttempts.setText(R.string.blank_space);

    }

    public void newGameConfirm(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.alert_title);
        builder.setMessage(R.string.alert_description);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                newGame();
                Toast.makeText(GuesTheNumber.this, "Você criou um novo jogo", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(GuesTheNumber.this, "Você desistiu de criar um novo jogo", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

}
