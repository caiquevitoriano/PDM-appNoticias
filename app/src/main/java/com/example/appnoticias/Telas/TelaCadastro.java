package com.example.appnoticias.Telas;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
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
    private UsuarioDao usuarioDao;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usuarioDao = new UsuarioDao(getBaseContext());
        System.out.println(usuarioDao.listar());

//        TITULO DA PAGINA

        TextView titulo = new TextView(this);
        titulo.setPadding(0,80,0,0);
        titulo.setText("CADASTRO\n\n");
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

        Botao botaoCadastro = new Botao(this, "Cadastrar", Color.rgb(255,69,0));
        botaoCadastro.setColorTextButton();
        botaoCadastro.setOnClickAction(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("RAULT","FOI CADASTRADO");


                if(validaCampos()==true){

                    if (usuarioDao.salvar(edtEmail,edtNome,edtSenha)){
                        Toast.makeText(TelaCadastro.this,"Usuário Cadastrado!",Toast.LENGTH_SHORT).show();
                        System.out.println(usuarioDao.listar());
                        Intent mudarTelaCadastro = new Intent(getApplicationContext(), TelaLogin.class);
                        startActivity(mudarTelaCadastro);

                    }else {
                        Toast.makeText(TelaCadastro.this,"Email ja existe!",Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });

        layoutBotoes.addView(botaoCadastro);

        Botao botaoCancelar = new Botao(this, "Cancelar", Color.rgb(255,69,0));
        botaoCancelar.setColorTextButton();
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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Aviso");
        builder.setMessage("Há campos inválidos ou em branco!");
        builder.setNeutralButton("OK", null);

        if (res = isCampoVazio(edtNome)){
            nome.requestFocus();
            builder.show();
            return false;
        }else if (res = isCampoVazio(edtEmail)){
            email.requestFocus();
            builder.show();
            return false;
        }else if (res = !Patterns.EMAIL_ADDRESS.matcher(edtEmail).matches()){
            email.requestFocus();
            builder.show();
            return false;
        } else if (res = isCampoVazio(edtSenha)||(edtSenha.length()<4)){
            senha.requestFocus();
            builder.show();
            return false;
        }

        else return true;
    }


    public boolean isCampoVazio(String valor) {

        return (TextUtils.isEmpty(valor) || valor.trim().isEmpty());
    }







}
