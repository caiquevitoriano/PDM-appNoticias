package com.example.appnoticias.Telas;

import android.app.Activity;
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

        TextView textView = new TextView(this);
        textView.setPadding(0,80,0,0);
        textView.setText("AAAAAAAAAAAAA\n\n");
        textView.setTextSize(25f);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);


        LinearLayout layoutTitulo= new LinearLayout(this);
        layoutTitulo.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        layoutTitulo.setOrientation(LinearLayout.VERTICAL);
        layoutTitulo.setPadding(9,9,9,9);
        layoutTitulo.setGravity(Gravity.CENTER_VERTICAL);
        layoutTitulo.addView(textView);


        LinearLayout layoutTexto= new LinearLayout(this);
        layoutTexto.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        layoutTexto.setOrientation(LinearLayout.VERTICAL);
        layoutTexto.setGravity(Gravity.CENTER_VERTICAL);
        layoutTexto.addView(textView);


        LinearLayout layoutData= new LinearLayout(this);
        layoutData.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        layoutData.setOrientation(LinearLayout.VERTICAL);
        layoutData.setGravity(Gravity.CENTER_VERTICAL);


        LinearLayout linearLayout= new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER_VERTICAL);
        linearLayout.addView(layoutTitulo);
        linearLayout.addView(layoutTexto);
        linearLayout.addView(layoutData);
        setDynamicContent(linearLayout);

    }


}
