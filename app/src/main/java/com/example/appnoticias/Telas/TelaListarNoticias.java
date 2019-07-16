package com.example.appnoticias.Telas;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TelaListarNoticias extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //        TITULO DA PAGINA

        TextView titulo = new TextView(this);
        titulo.setPadding(0,80,0,0);
        titulo.setText("NOTÍCIAS\n\n");
        titulo.setTextSize(25f);
        titulo.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);


        //      LAYOUT LISTA

        LinearLayout layoutLista = new LinearLayout(this);
        layoutLista.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        layoutLista.setOrientation(LinearLayout.HORIZONTAL);
        layoutLista.setPadding(9,9,9,9);
        layoutLista.setGravity(Gravity.CENTER_HORIZONTAL);

        //        LAYOUT DOS LAYOUTS

        LinearLayout linearLayout= new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(9,9,9,9);
        linearLayout.setGravity(Gravity.CENTER_VERTICAL);
        setContentView(linearLayout);

//        NOTICIAS

        setTitle("Noticias");

        //      LISTA DE NOTICIAS
        List<String> lista =  new ArrayList<>();
        lista.add("noticia1");
        lista.add("noticia2");
        lista.add("noticia3");
        lista.add("noticia4");
        ListView listNoticia =  new ListView(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, lista
        );
        listNoticia.setAdapter(adapter);
        layoutLista.addView(listNoticia);

        //        SETANTO TODAS AS VIEWS TANTO DOS INPUTS QUANTO DOS BOTOES

        linearLayout.addView(titulo);
        linearLayout.addView(layoutLista);

            


    }

}
