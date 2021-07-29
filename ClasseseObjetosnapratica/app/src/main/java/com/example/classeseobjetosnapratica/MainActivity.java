package com.example.classeseobjetosnapratica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Passaro passaro = new Passaro();
        Cao cao = new Cao();
        Animal animal = new Animal();

        

    }
}
