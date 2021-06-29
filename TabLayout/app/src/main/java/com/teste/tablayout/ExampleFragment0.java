package com.teste.tablayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ExampleFragment0 extends Fragment {
    private ImageButton btnIncrement;
    private TextView txtTab0;
    private int contador;

    public ExampleFragment0(){ super(R.layout.tab0); }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        contador = 0;

        btnIncrement = view.findViewById(R.id.btnIncrement);
        txtTab0 = view.findViewById(R.id.txtTab0);

        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador++;
                txtTab0.setText("Tab " + contador);
            }
        });
    }
}
