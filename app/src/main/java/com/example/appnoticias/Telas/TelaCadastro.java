package com.example.appnoticias.Telas;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.appnoticias.Componentes.Botao;
import com.example.appnoticias.Componentes.Input;
import com.example.appnoticias.Database.DadosOpenHelper;
import com.example.appnoticias.Database.UsuarioDao;
import com.example.appnoticias.Model.Usuario;


public class TelaCadastro extends AppCompatActivity {
    private String edtNome;
    private String edtEmail;
    private String edtSenha;
    private Input nome;
    private Input email;
    private Input senha;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        UsuarioDao usuarioDao = new UsuarioDao(getBaseContext()); testando metodo

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

        nome = new Input(this,"Nome", InputType.TYPE_CLASS_TEXT, 500);
        layoutInputs.addView(nome);


        email = new Input(this,"Email", InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS, 500);
        layoutInputs.addView(email);


        senha = new Input(this,"Senha", InputType.TYPE_TEXT_VARIATION_PASSWORD, 500);
        layoutInputs.addView(senha);



//        SETANDO BOTOES

        Botao botaoCadastro = new Botao(this, "Cadastrar");
        botaoCadastro.setOnClickAction(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("RAULT","FOI CADASTRADO");
                validaCampos();
            }
        });
        layoutBotoes.addView(botaoCadastro);

        Botao botaoCancelar = new Botao(this, "Cancelar");
        botaoCadastro.setStateListAnimator(null);
        botaoCadastro.setElevation(200);
        botaoCadastro.setTranslationZ(200);
        botaoCancelar.setOnClickAction(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("RAULT","FOI CANCELADO");
                Intent mudarTelaCadastro = new Intent(getApplicationContext(), TelaLogin.class);
                startActivity(mudarTelaCadastro);
            }
        });
        layoutBotoes.addView(botaoCancelar);


//        SETANTO TODAS AS VIEWS TANTO DOS INPUTS QUANTO DOS BOTOES

        linearLayout.addView(titulo);
        linearLayout.addView(layoutInputs);
        linearLayout.addView(layoutBotoes);

    }


    public boolean validaCampos(){
        boolean res = false;
        edtNome = nome.getValue();
        edtEmail = email.getValue();
        edtSenha = senha.getValue();

        if (res = isCampoVazio(edtNome)){
            nome.requestFocus();
        }else if (res = isCampoVazio(edtEmail)){
            email.requestFocus();
        }else if (res = !isEmailValido(edtEmail)){
            email.requestFocus();
        } else if (res = isCampoVazio(edtSenha)||(edtSenha.length()<4)){
            senha.requestFocus();
        }
        if (res) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Aviso");
            builder.setMessage("Há campos inválidos ou em branco!");
            builder.setNeutralButton("OK", null);
            builder.show();
        }

        return res;
    }


    public boolean isCampoVazio(String valor) {

        return (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
    }

    public boolean isEmailValido(String email) {
        return (!isCampoVazio(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }






}
