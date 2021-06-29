package com.teste.drive;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGImageView;
import com.caverock.androidsvg.SVGParseException;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private String ip = "http://192.168.100.254:3333/imagem/";
    //private SubsamplingScaleImageView imageView;
    private ImageView imageView;
    private Button btnNovaImagem;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        btnNovaImagem = findViewById(R.id.btnNovaImagem);
        
        btnNovaImagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirEscolhaImagem();
            }
        });
    }
    
    private void abrirEscolhaImagem(){
        View view = getLayoutInflater().inflate(R.layout.dialog_url, null);
        
        Button btnConfirmar, btnCancelar;
        EditText edtArquivo;
        
        btnConfirmar = view.findViewById(R.id.btnConfirmar);
        btnCancelar = view.findViewById(R.id.btnCancelar);
        edtArquivo = view.findViewById(R.id.edtArquivo);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(view)
                .create();

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = edtArquivo.getText().toString();
                
                if(!texto.isEmpty()){
                    requisicao(texto);
                    dialog.dismiss();
                }
                else{
                    Toast.makeText(MainActivity.this, "Insira o nome do arquivo!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
    
    private void requisicao(String imagem){
        RequestQueue fila = Volley.newRequestQueue(MainActivity.this);

        String url = ip + imagem;

        ImageRequest requisicao = new ImageRequest(url,
                imageView::setImageBitmap,
                1920,
                1920,
                ImageView.ScaleType.CENTER_INSIDE,
                Bitmap.Config.RGB_565,
                error -> {
                    // Do something with error response
                    error.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
        );

        fila.add(requisicao);
    }
}