package com.example.appnoticias.Componentes;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class CardViewNoticia extends LinearLayout {

    private TextView titulo;
    private TextView descricao;
    private TextView data;
    private ImageView capaNoticia;
    private LinearLayout layoutInformacoes;
    private LinearLayout layoutImagem;


    public CardViewNoticia(Activity tela, String titulo, String descricao, String data) {
        super(tela);
        this.init(tela, titulo, descricao, data);
        //definindo layout
        this.noticeWithoutLayoutImage(tela);
    }

    private void init(Activity activity, String titulo, String descricao, String data) {
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        setOrientation(VERTICAL);

//        Integer halfWidth = DeviceProperties.getDeviceWidth(activity.getWindowManager())/2;

        this.titulo = new TextView(activity);
        this.titulo.setText(titulo);
        this.titulo.setTextSize(20);
        this.titulo.setWidth(50);

        this.descricao = new TextView(activity);
        this.descricao.setText(descricao);
        this.descricao.setTextSize(14);
        this.descricao.setPadding(0,10,0,0);
        this.descricao.setWidth(50);

        this.data = new TextView(activity);
        this.data.setText(data);
        this.data.setTextSize(16);
        this.data.setPadding(0,10,0,0);
        this.data.setWidth(50);
    }

    private void noticeWithoutLayoutImage(Context context){
        this.layoutInformacoes = new LinearLayout(context);
        this.layoutInformacoes.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        this.layoutInformacoes.setOrientation(VERTICAL);
        this.layoutImagem.setPadding(10,10,10,10);
        addView(this.layoutInformacoes);
        this.layoutInformacoes.addView(this.titulo);
        this.layoutInformacoes.addView(this.descricao);
        this.layoutInformacoes.addView(this.data);
    }


    private void noticeWithLayoutImage(Context context, ImageView capaNoticia){
        this.layoutImagem = new LinearLayout(context);
        this.layoutImagem.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        this.layoutImagem.setOrientation(HORIZONTAL);
        this.layoutImagem.setPadding(20,20,20,20);
        addView(this.layoutImagem);

        LinearLayout columInfo = new LinearLayout(this.layoutImagem.getContext());
        columInfo.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        columInfo.setOrientation(VERTICAL);

        columInfo.addView(this.titulo);
        columInfo.addView(this.descricao);
        columInfo.addView(this.data);

        LinearLayout columImg = new LinearLayout(this.layoutImagem.getContext());
        columImg.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        columImg.setOrientation(VERTICAL);
        columImg.setGravity(Gravity.CENTER_VERTICAL);

        //permite definir dimensoes da img
        capaNoticia.setAdjustViewBounds(true);
        capaNoticia.setMaxWidth(300);
        capaNoticia.setMaxHeight(300);

        columImg.addView(capaNoticia);

        this.layoutImagem.addView(columInfo);
        this.layoutImagem.addView(columImg);
    }
}
