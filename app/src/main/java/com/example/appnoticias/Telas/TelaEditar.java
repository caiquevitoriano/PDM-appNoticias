package com.example.appnoticias.Telas;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appnoticias.Componentes.Botao;
import com.example.appnoticias.Componentes.Input;
import com.example.appnoticias.R;

public class TelaEditar extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item1 = menu.add ("Dados");
        MenuItem item2 = menu.add ("Sair");

        item1.setOnMenuItemClickListener (new MenuItem.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick (MenuItem item){
                return true;
            }
        });

        item2.setOnMenuItemClickListener (new MenuItem.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick (MenuItem item){
                return true;
            }
        });
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //        TITULO DA PAGINA

        TextView titulo = new TextView(this);
        titulo.setPadding(0,80,0,0);
        titulo.setText("DADOS\n\n");
        titulo.setTextSize(25f);
        titulo.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);


        //        LAYOUT DOS BOTOES

        LinearLayout layoutBotoes= new LinearLayout(this);
        layoutBotoes.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        layoutBotoes.setOrientation(LinearLayout.VERTICAL);
        layoutBotoes.setPadding(9,9,9,9);
        layoutBotoes.setGravity(Gravity.CENTER_HORIZONTAL);

//        LAYOUT DOS INPUTS
        LinearLayout layoutInputs= new LinearLayout(this);
        layoutInputs.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        layoutInputs.setOrientation(LinearLayout.VERTICAL);
        layoutInputs.setPadding(9,5,9,9);
        layoutInputs.setGravity(Gravity.CENTER_HORIZONTAL);

//        LAYOUT DOS LAYOUTS

        LinearLayout linearLayout= new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(9,9,9,9);
        linearLayout.setGravity(Gravity.CENTER_VERTICAL);
        setContentView(linearLayout);

//        MUDANDO TITULO DA PAGINA

        setTitle("Editar Informações");

//      INPUTS DA PAGINA

        Input nome = new Input(this,"Nome", InputType.TYPE_CLASS_TEXT, 500);
        layoutInputs.addView(nome);

        Input email = new Input(this,"Email", InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS, 500);
        layoutInputs.addView(email);

        Input senhaAtual = new Input(this,"Senha atual", InputType.TYPE_TEXT_VARIATION_PASSWORD, 500);
        layoutInputs.addView(senhaAtual);

        Input senhaNova = new Input(this,"Confirme a Senha", InputType.TYPE_TEXT_VARIATION_PASSWORD, 500);
        layoutInputs.addView(senhaNova);




//        SETANDO BOTOES

        Botao botaoCadastro = new Botao(this, "Editar");
        botaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("RAULT","FOI EDITADO");
            }
        });
        layoutBotoes.addView(botaoCadastro);


        Botao botaoCancelar = new Botao(this, "Cancelar");
        botaoCancelar.setOnClickAction(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("RAULT","FOI CANCELADO");
                Intent mudarTelaCadastro = new Intent(getApplicationContext(), TelaListarNoticias.class);
                startActivity(mudarTelaCadastro);
            }
        });
        layoutBotoes.addView(botaoCancelar);



//        SETANTO TODAS AS VIEWS TANTO DOS INPUTS QUANTO DOS BOTOES

        linearLayout.addView(titulo);
        linearLayout.addView(layoutInputs);
        linearLayout.addView(layoutBotoes);
    }
}
