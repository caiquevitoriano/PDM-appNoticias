package com.example.appnoticias;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);

        linearLayout.setBackgroundColor(Color.WHITE);

        TextView label = new TextView(this);
        label.setText("TESTE");
        linearLayout.addView(label);

        EditText input = new EditText(this);
        input.setHint("NOME");
        linearLayout.addV iew(input);

        EditText input2 = new EditText(this);
        input2.setHint("NOME");
        linearLayout.addView(input2);

    }
}
