package com.example.appnoticias.Componentes;

import android.content.Context;
import android.text.InputType;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Input extends LinearLayout {


    private String label;
    private Integer largura;
    private TextView textView;
    private EditText editText;
    private int tipo;


    public Input(Context context, String label, int tipo) {
        super(context);
        this.label = label;
        this.tipo = tipo;
        init();
    }

    public Input(Context context, String label, int tipo, Integer largura) {
        super(context);
        this.label = label;
        this.tipo = tipo;
        this.largura = largura;
        init();
    }

    private void init() {

        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
        setOrientation(VERTICAL);
        textView = new TextView(getContext());
        textView.setText(label);
        addView(textView);

        editText = new EditText(getContext());

        editText.setSingleLine();
        editText.setInputType(InputType.TYPE_CLASS_TEXT | tipo);
        editText.setWidth(largura);
        addView(editText);
    }

    public String getValue(){
        return editText.getText().toString();
    }
}
