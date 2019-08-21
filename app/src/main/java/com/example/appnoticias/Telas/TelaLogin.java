package com.example.appnoticias.Telas;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appnoticias.Componentes.Botao;
import com.example.appnoticias.Componentes.Input;
import com.example.appnoticias.Database.UsuarioDao;
import com.example.appnoticias.Model.Usuario;
import com.example.appnoticias.R;
import com.example.appnoticias.rss.GetRss;

public class TelaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        TITULO DA PAGINA

        TextView titulo = new TextView(this);
        titulo.setPadding(0,80,0,0);
        titulo.setText("LOGIN\n\n");
        titulo.setTextSize(20f);
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

        getWindow().getDecorView().setBackgroundColor(Color.WHITE);



//        MUDANDO TITULO DA PAGINA
        setTitle("Login");


//      INPUTS DA PAGINA

        final Input email = new Input(this,"Email", InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS, 500);
        layoutInputs.addView(email);

        final Input senha = new Input(this,"Senha", InputType.TYPE_TEXT_VARIATION_PASSWORD, 500);
        layoutInputs.addView(senha);


//        SETANDO BOTOES

        Botao botaoEntrar = new Botao(this, "Entrar", Color.rgb(255,69,0));
        botaoEntrar.setColorTextButton();

        botaoEntrar.setOnClickAction(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioDao usuarioDao = new UsuarioDao(TelaLogin.this);
                Usuario usuario = usuarioDao.buscarUsuario(email.getValue());
                usuarioDao.usuarioAutenticar(usuario.getEmail(),usuario.getSenha());
                if (email.getValue().equals(usuario.getEmail())&& senha.getValue().equals(usuario.getSenha())){
                    SharedPreferences.Editor editor = getSharedPreferences("authenticatedUser",MODE_PRIVATE).edit();
                    editor.putBoolean("logado",true);
                    editor.putInt("codigo",usuario.getCodigo());
                    editor.putString("nome",usuario.getNome());
                    editor.putString("email",usuario.getEmail());
                    editor.putString("senha",usuario.getSenha());
                    editor.apply();
                    Intent mudaIntent = new Intent(getApplicationContext(), GetRss.class);
                    startActivity((mudaIntent));
                    Log.d("RAULT","FOI AUTENTICADO");
                    finish();
                }else {
                    Toast.makeText(TelaLogin.this,"Email ou senha inválidos!",Toast.LENGTH_LONG).show();
                }

            }
        });
        layoutBotoes.addView(botaoEntrar);

        Botao botaoCriarConta = new Botao(this, "Criar Contar", Color.rgb(255,69,0));
        botaoCriarConta.setColorTextButton();
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
