package com.teste.gridview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AdapterGrid extends BaseAdapter {
    private List<Botao> listaBotoes;
    private Context contexto;

    @Override
    public int getCount() {
        return listaBotoes.size();
    }

    @Override
    public Object getItem(int position) {
        return listaBotoes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Botao botao = listaBotoes.get(position);
        LayoutInflater inflater = LayoutInflater.from(contexto);
        convertView = inflater.inflate(R.layout.adapter_grid, null);
        ImageView btnTeste = convertView.findViewById(R.id.imgTeste);
        btnTeste.setImageResource(botao.getDrawable());

        return convertView;
    }
}
