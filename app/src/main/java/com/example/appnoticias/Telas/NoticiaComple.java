package com.example.appnoticias.Telas;

import android.view.Gravity;
import android.widget.LinearLayout;
import android.os.Bundle;
import android.widget.ScrollView;
import com.example.appnoticias.Componentes.NoticiaUnica;
import com.example.appnoticias.Model.Noticia;

public class NoticiaComple extends SideBar{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout= new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER_VERTICAL);

        // Recebendo noticia unica

        Noticia unica = (Noticia) getIntent().getSerializableExtra("noticiaUnica");

        //Criando noticia no objeto

        NoticiaUnica noticiaUnica = new NoticiaUnica(this,unica.getTitulo(),unica.getConteudo(),unica.getData());



        linearLayout.addView(noticiaUnica);
        setDynamicContent(linearLayout);







    }


}
