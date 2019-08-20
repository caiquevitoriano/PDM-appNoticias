package com.example.appnoticias.Telas;

import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.appnoticias.R;

public class NoticiaComple extends SideBar {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia_comple);

        TextView textView = new TextView(this);
        textView.setPadding(0,80,0,0);
        textView.setText("AAAAAAAAAAAAA\n\n");
        textView.setTextSize(25f);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        LinearLayout linearLayout= new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(9,9,9,9);
        linearLayout.setGravity(Gravity.CENTER_VERTICAL);
        setContentView(linearLayout);

        LinearLayout layoutTitulo= new LinearLayout(this);
        layoutTitulo.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layoutTitulo.setOrientation(LinearLayout.VERTICAL);
        layoutTitulo.setPadding(9,9,9,9);
        layoutTitulo.setGravity(Gravity.CENTER_VERTICAL);
        layoutTitulo.addView(textView);
        setContentView(layoutTitulo);


        LinearLayout layoutTexto= new LinearLayout(this);
        layoutTexto.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layoutTexto.setOrientation(LinearLayout.VERTICAL);
        layoutTexto.setPadding(9,9,9,9);
        layoutTexto.setGravity(Gravity.CENTER_VERTICAL);
        layoutTexto.addView(textView);
        setContentView(layoutTexto);


        LinearLayout layoutData= new LinearLayout(this);
        layoutData.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layoutData.setOrientation(LinearLayout.VERTICAL);
        layoutData.setPadding(9,9,9,9);
        layoutData.setGravity(Gravity.CENTER_VERTICAL);
        layoutData.addView(textView);
        setContentView(layoutData);
    }


}
