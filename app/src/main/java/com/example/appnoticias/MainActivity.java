package com.example.appnoticias;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appnoticias.Componentes.Botao;
import com.example.appnoticias.Componentes.Input;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);

        linearLayout.setBackgroundColor(Color.WHITE);

        Input input = new Input(this,"Nome",InputType.TYPE_CLASS_TEXT, 100);
        linearLayout.addView(input);


        final Botao botaoCadastro = new Botao(this, "Cadastrar");
        botaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Usuario Cadastrado!", Toast.LENGTH_SHORT).show();
            }
        });
        linearLayout.addView(botaoCadastro);


    }
}
