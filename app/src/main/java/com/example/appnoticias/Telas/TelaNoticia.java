package com.example.appnoticias.Telas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appnoticias.Model.Noticia;

public class TelaNoticia extends AppCompatActivity {
//    private Noticia noticia = new Noticia("Noticia", "subtitulo", "Lorem ipsum dolor sit " +
//            "amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
//            " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo" +
//            " consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat" +
//            " nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt" +
//            " mollit anim id est laborum");
//
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuItem item1 = menu.add ("Dados");
//        MenuItem item2 = menu.add ("Sair");
//
//        item1.setOnMenuItemClickListener (new MenuItem.OnMenuItemClickListener(){
//            @Override
//            public boolean onMenuItemClick (MenuItem item){
//                Log.d("RAULT","Editar dados");
//                Intent Editar = new Intent(getApplicationContext(), TelaEditar.class);
//                startActivity((Editar));
//                return true;
//            }
//        });
//
//        item2.setOnMenuItemClickListener (new MenuItem.OnMenuItemClickListener(){
//            @Override
//            public boolean onMenuItemClick (MenuItem item){
//                Log.d("RAULT","Voltar pra login");
//                Intent Sair = new Intent(getApplicationContext(), TelaLogin.class);
//                startActivity((Sair));
//                return true;
//            }
//        });
//        return true;
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        //        TITULO DA PAGINA
//
//        TextView titulo = new TextView(this);
//        titulo.setPadding(0,80,0,0);
//        titulo.setText(noticia.getTitulo() + "");
//        titulo.setTextSize(25f);
//        titulo.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
//
//        //        SUBTITULO DA NOTICIA
//
//        TextView subtitulo = new TextView(this);
//        subtitulo.setPadding(0,80,0,0);
//        subtitulo.setText(noticia.getLink() + "");
//        subtitulo.setTextSize(25f);
//        subtitulo.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
//
////        CONTEUDO DA NOTICIA
//
//        TextView conteudo = new TextView(this);
//        conteudo.setPadding(0,80,0,0);
//        conteudo.setText(noticia.getData() + "");
//        conteudo.setTextSize(25f);
//        conteudo.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
//
//
//        //        LAYOUT DOS LAYOUTS
//
//        LinearLayout linearLayout= new LinearLayout(this);
//        linearLayout.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//        linearLayout.setOrientation(LinearLayout.VERTICAL);
//        linearLayout.setPadding(9,9,9,9);
//        linearLayout.setGravity(Gravity.CENTER_VERTICAL);
//        setContentView(linearLayout);
//
//
//        //        SETANTO TODAS AS VIEWS TANTO DOS INPUTS QUANTO DOS BOTOES
//
//        linearLayout.addView(titulo);
//        linearLayout.addView(subtitulo);
//        linearLayout.addView(conteudo);
//
//
//
//
//    }

}
