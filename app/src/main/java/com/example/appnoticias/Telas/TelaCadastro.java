package com.example.appnoticias.Telas;

import android.content.Intent;
import android.graphics.Point;
import android.text.InputType;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.appnoticias.Componentes.Botao;
import com.example.appnoticias.Componentes.Input;
import com.example.appnoticias.MainActivity;

public class TelaCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        TITULO DA PAGINA

        TextView titulo = new TextView(this);
        titulo.setPadding(0,80,0,0);
        titulo.setText("CADASTRO\n\n");
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

//        MUDANDO TITULO DA TELA

        setTitle("Cadastro de Usuário");


//      INPUTS DA PAGINA

        Input nome = new Input(this,"Nome", InputType.TYPE_CLASS_TEXT, 500);
        layoutInputs.addView(nome);

        Input email = new Input(this,"Email", InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS, 500);
        layoutInputs.addView(email);

        Input senha = new Input(this,"Senha", InputType.TYPE_TEXT_VARIATION_PASSWORD, 500);
        layoutInputs.addView(senha);



//        SETANDO BOTOES

        Botao botaoCadastro = new Botao(this, "Cadastrar");
        botaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("RAULT","FOI CADASTRADO");
            }
        });
        layoutBotoes.addView(botaoCadastro);

        Botao botaoCancelar = new Botao(this, "Cancelar");
        botaoCancelar.setOnClickAction(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("RAULT","FOI CANCELADO");
                Intent mudarTelaCadastro = new Intent(getApplicationContext(), TelaListar.class);
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
