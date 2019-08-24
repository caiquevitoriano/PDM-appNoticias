package com.example.appnoticias.Telas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appnoticias.Componentes.Botao;
import com.example.appnoticias.Componentes.Input;
import com.example.appnoticias.Database.AccessDTO;
import com.example.appnoticias.Database.AccessManager;
import com.example.appnoticias.Database.UsuarioDao;
import com.example.appnoticias.Model.Usuario;
import com.example.appnoticias.R;
import com.example.appnoticias.rss.GetRss;

public class TelaEditar extends SideBar {
    private String edtNome;
    private String edtEmail;
    private String edtSenha;
    private Input nome;
    private Input email;
    private Input senha;
    private UsuarioDao usuarioDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usuarioDao = new UsuarioDao(getBaseContext());

        //        TITULO DA PAGINA

        TextView titulo = new TextView(this);
        titulo.setPadding(0,80,0,0);
        titulo.setText("EDITE OS SEUS DADOS\n\n");
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
        setDynamicContent(linearLayout);

//        MUDANDO TITULO DA PAGINA

        setTitle("Editar Informações");

//      INPUTS DA PAGINA



        nome = new Input(this,"Novo usuário", InputType.TYPE_CLASS_TEXT, 500);
        layoutInputs.addView(nome);


        senha = new Input(this,"Nova senha", InputType.TYPE_TEXT_VARIATION_PASSWORD, 500);
        layoutInputs.addView(senha);



//        SETANDO BOTOES

        Botao botaoCadastro = new Botao(this, "Editar", Color.rgb(255,69,0));
        botaoCadastro.setColorTextButton();
        botaoCadastro.setOnClickAction(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario = new Usuario();
                System.out.println(usuarioDao.listar());

                SharedPreferences sharedPreferences = getSharedPreferences("authenticatedUser", MODE_PRIVATE);
                int idUsuario = sharedPreferences.getInt("codigo",usuario.getCodigo());
                String emailUsuario = sharedPreferences.getString("email",usuario.getEmail());
                usuario.setCodigo(idUsuario);
                usuario.setNome(nome.getValue());
                usuario.setEmail(emailUsuario);
                usuario.setSenha(senha.getValue());

                if(validaCampos()==true){

                    usuarioDao.alterar(usuario);
                    Toast.makeText(TelaEditar.this,"Usuário Editado!",Toast.LENGTH_SHORT).show();
                    System.out.println(usuarioDao.listar());
                    Log.d("RAULT","FOI EDITADO");

                    AccessManager am = new AccessManager(TelaEditar.this);
                    am.remove();
                    TelaEditar.this.finish();
                    Intent loginIntent = new Intent(getApplicationContext(), TelaLogin.class);
                    startActivity(loginIntent);


                }
            }

        });
        layoutBotoes.addView(botaoCadastro);


        Botao botaoCancelar = new Botao(this, "Cancelar", Color.rgb(255,69,0));
        botaoCancelar.setColorTextButton();
        botaoCancelar.setOnClickAction(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("RAULT","FOI CANCELADO");
                Intent mudarTelaCadastro = new Intent(getApplicationContext(), GetRss.class);
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
        edtSenha = senha.getValue();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Aviso");
        builder.setMessage("Há campos inválidos ou em branco!");
        builder.setNeutralButton("OK", null);

        if (res = isCampoVazio(edtNome)){
            nome.requestFocus();
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
