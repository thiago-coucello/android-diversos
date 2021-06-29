package com.teste.swipeviwer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;

    private ViewPager viewPager;

    private ArrayList<MyModel> modelArrayList;

    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getSupportActionBar();

        View view = getLayoutInflater().inflate(R.layout.dialog_customizado, null);
        viewPager = view.findViewById(R.id.viewPager);
        loadCards();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                actionBar.setTitle(modelArrayList.get(position).getTitle());
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("Escolha um produto: ")
                .setView(view)
                .create();

        dialog.show();
    }

    public void loadCards(){
        modelArrayList = new ArrayList<>();

        modelArrayList.add(new MyModel("Titulo 1", "Descricao 1", new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date()), R.drawable.ic_baseline_anchor_24));

        modelArrayList.add(new MyModel("Titulo 2", "Descricao 2", new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date()), R.drawable.ic_time));

        modelArrayList.add(new MyModel("Titulo 3", "Descricao 3", new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date()), R.drawable.ic_baseline_amp_stories_24));

        modelArrayList.add(new MyModel("Titulo 4", "Descricao 4", new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date()), R.drawable.ic_baseline_airplay_24));

        myAdapter = new MyAdapter(this, modelArrayList);

        viewPager.setAdapter(myAdapter);

        viewPager.setPadding(100, 0, 100 , 0);
    }
}