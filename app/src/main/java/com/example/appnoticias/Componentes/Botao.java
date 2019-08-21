package com.example.appnoticias.Componentes;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.widget.Button;
import android.widget.LinearLayout;

public class Botao extends LinearLayout {

    private Button botao;
    private String label;
    private Integer largura;
    private Integer cor;


    public Botao(Context context, String label) {
        super(context);
        this.label = label;
        init();
    }

    public Botao(Context context, String label, Integer cor) {
        super(context);
        this.cor = cor;
        this.label = label;
        init();
    }


    public Botao(Context context, String label, Integer largura,Integer cor){
        super(context);
        this.label = label;
        this.largura = largura;
        this.cor = cor;
        init();
    }

    private void init() {
        LayoutParams layoutParams = new LayoutParams(500, LayoutParams.MATCH_PARENT);
        setLayoutParams(layoutParams);
        setOrientation(VERTICAL);


        botao = new Button(getContext());
        botao.setText(label);
        if(this.cor!=null){
            botao.getBackground().setColorFilter(cor, PorterDuff.Mode.MULTIPLY);
        }

        addView(botao);

    }

    public void setColorTextButton (){
        botao.setTextColor(Color.WHITE);
    }

    public void setOnClickAction(OnClickListener onClickListener){
        botao.setOnClickListener(onClickListener);
    }



}
