package com.example.testes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.Testes.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void sendMessage() {

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    public void exemplo_simples(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Titulo");
        builder.setMessage("Qualifique este software");
        builder.setPositiveButton("Positivo", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                sendMessage();
            }
        });
        builder.setNegativeButton("Negativo", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        builder.show();
    }
}
