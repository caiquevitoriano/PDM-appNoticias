package com.example.appnoticias.Componentes;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.widget.LinearLayout;

public class Botao extends LinearLayout {

    private Button botao;
    private String label;
    private Integer largura;


    public Botao(Context context, String label) {
        super(context);
        this.label = label;
        init();
    }


    public Botao(Context context, String label, Integer largura){
        super(context);
        this.label = label;
        this.largura = largura;
        init();
    }

    private void init() {
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
        setOrientation(VERTICAL);

        botao = new Button(getContext());
        botao.setText(label);
        addView(botao);

    }

    public void setOnClickAction(OnClickListener onClickListener){
        botao.setOnClickListener(onClickListener);
    }

}
