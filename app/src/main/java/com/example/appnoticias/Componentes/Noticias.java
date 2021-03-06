package com.example.appnoticias.Componentes;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Noticias extends LinearLayout {

    private TextView titulo;
    private TextView descricao;
    private TextView data;
    private LinearLayout layoutInformacoes;


    public Noticias(Activity tela, String titulo, String descricao, String data) {
        super(tela);
        this.init(tela, titulo, descricao, data);
        this.noticeWithoutLayoutImage(tela);
    }

    private void init(Activity activity, String titulo, String descricao, String data) {
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        setOrientation(VERTICAL);


        this.titulo = new TextView(activity);
        this.titulo.setText(titulo);
        this.titulo.setTextSize(20);
        this.titulo.setTextColor(Color.BLACK);
        this.titulo.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        this.titulo.setWidth(10);
        this.titulo.setPadding(30,20,30,0);


        this.descricao = new TextView(activity);
        this.descricao.setText(descricao);
        this.descricao.setTextSize(10);
        this.descricao.setTextColor(Color.BLACK);
        this.descricao.setPadding(20,10,20,0);
        this.descricao.setWidth(10);
        this.descricao.setPadding(20,20,20,0);


        this.data = new TextView(activity);
        this.data.setText(data);
        this.data.setTextSize(10);
        this.data.setTextColor(Color.BLACK);
        this.data.setPadding(0,10,0,0);
        this.data.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        this.data.setWidth(10);
        this.data.setPadding(0,20,0,10);

    }

    private void noticeWithoutLayoutImage(Context context){
        this.layoutInformacoes = new LinearLayout(context);
        this.layoutInformacoes.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        this.layoutInformacoes.setOrientation(VERTICAL);
        addView(this.layoutInformacoes);
        this.layoutInformacoes.addView(this.titulo);
        this.layoutInformacoes.addView(this.descricao);
        this.layoutInformacoes.addView(this.data);
    }

}
