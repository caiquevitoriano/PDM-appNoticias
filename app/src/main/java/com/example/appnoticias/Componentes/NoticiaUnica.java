package com.example.appnoticias.Componentes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.Serializable;

public class NoticiaUnica extends LinearLayout{

    private TextView titulo;
    private TextView conteudo;
    private TextView data;
    private LinearLayout layoutInformacoes;
    private ScrollView scroller ;


    public NoticiaUnica(Activity tela, String titulo, String descricao, String data) {
        super(tela);
        this.init(tela, titulo, descricao, data);
        this.noticeWithoutLayoutImage(tela);
    }


    private void init(Activity activity, String titulo, String descricao, String data) {
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        setOrientation(VERTICAL);

        scroller = new ScrollView(getContext());


        this.titulo = new TextView(activity);
        this.titulo.setText(titulo);
        this.titulo.setTextSize(20);
        this.titulo.setWidth(10);
        this.titulo.setTextColor(Color.BLACK);
        this.titulo.setPadding(50,30,50,0);
        this.titulo.setTextAlignment(TEXT_ALIGNMENT_CENTER);

        this.conteudo = new TextView(activity);
        this.conteudo.setText(descricao);
        this.conteudo.setTextSize(15);
        this.conteudo.setTextColor(Color.BLACK);
        this.conteudo.setPadding(50,50,50,0);
        this.conteudo.setWidth(10);
        this.scroller.addView(this.conteudo);

        this.data = new TextView(activity);
        this.data.setText(data);
        this.data.setTextSize(14);
        this.data.setTextAlignment(TEXT_ALIGNMENT_VIEW_END);
        this.data.setPadding(0,30,50,30);
        this.data.setTextColor(Color.BLACK);
        this.data.setWidth(10);
    }

    private void noticeWithoutLayoutImage(Context context){
        this.layoutInformacoes = new LinearLayout(context);
        this.layoutInformacoes.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        this.layoutInformacoes.setOrientation(VERTICAL);
        addView(this.layoutInformacoes);
        //
        LayoutParams layoutScroller = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        layoutScroller.weight = 1;
        //
        this.layoutInformacoes.addView(this.titulo, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        this.layoutInformacoes.addView(this.scroller, layoutScroller);
        this.layoutInformacoes.addView(this.data, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
    }


}
