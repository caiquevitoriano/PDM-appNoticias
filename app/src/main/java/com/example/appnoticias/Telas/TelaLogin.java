package com.example.appnoticias.Telas;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appnoticias.Componentes.Botao;
import com.example.appnoticias.Componentes.Input;
import com.example.appnoticias.R;

public class TelaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        TITULO DA PAGINA

        TextView titulo = new TextView(this);
        titulo.setPadding(0,80,0,0);
        titulo.setText("LOGIN\n\n");
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
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        setContentView(linearLayout);

        // LAYOUT TEXTVIEW

        LinearLayout imagemL= new LinearLayout(this);
        imagemL.setLayoutParams(new LinearLayout.LayoutParams( 300,400));
        imagemL.setOrientation(LinearLayout.VERTICAL);
        imagemL.setPadding(0,10,0,0);
        imagemL.setGravity(Gravity.CENTER_HORIZONTAL);

        ImageView imagem = new ImageView(this);
        imagem.setImageResource(R.drawable.logo);
        imagemL.addView(imagem);



//        MUDANDO TITULO DA PAGINA
        setTitle("Login");


//      INPUTS DA PAGINA

        Input email = new Input(this,"Email", InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS, 500);
        layoutInputs.addView(email);

        Input senha = new Input(this,"Senha", InputType.TYPE_TEXT_VARIATION_PASSWORD, 500);
        layoutInputs.addView(senha);


//        SETANDO BOTOES

        Botao botaoEntrar = new Botao(this, "Entrar");
        botaoEntrar.setOnClickAction(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("RAULT","FOI AUTENTICADO");
                Intent mudaIntent = new Intent(getApplicationContext(), TelaListar.class);
                startActivity((mudaIntent));
            }
        });
        layoutBotoes.addView(botaoEntrar);

        Botao botaoCriarConta = new Botao(this, "Criar Contar");
        botaoCriarConta.setOnClickAction(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("RAULT","FOI PRO CADASTRO");
                Intent mudarTelaCadastro = new Intent(getApplicationContext(), TelaCadastro.class);
                startActivity(mudarTelaCadastro);
            }
        });
        layoutBotoes.addView(botaoCriarConta);





//        SETANTO TODAS AS VIEWS TANTO DOS INPUTS QUANTO DOS BOTOES

        linearLayout.addView(imagemL);
        linearLayout.addView(layoutInputs);
        linearLayout.addView(layoutBotoes);




    }
}
