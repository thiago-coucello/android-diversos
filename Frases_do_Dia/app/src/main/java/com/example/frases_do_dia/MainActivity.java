package com.example.frases_do_dia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Bundle parametros = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parametros.putInt("chave_emily", 0);
        parametros.putInt("opcao", 0);

    }

    public void ValidarSenha(View view){
        TextView senha = findViewById(R.id.password);
        TextView status = findViewById(R.id.status);

        String password = senha.getText().toString().toLowerCase();

        if(password.equals("21/08/2019") || password.equals("emily luana vieira da silva") || password.equals("emily")){
            status.setText(R.string.branco);

            Intent intent = new Intent(this, JogoNormal.class);

            parametros.putInt("chave_emily",1);

            intent.putExtras(parametros);

            startActivity(intent);
        }
        else{
            senha.setText(R.string.branco);
            status.setText(R.string.incorreta);
        }
    }

    public void ChamarNormal(View view){
        Intent intent = new Intent(this, JogoNormal.class);

        intent.putExtras(parametros);

        startActivity(intent);
    }

}
