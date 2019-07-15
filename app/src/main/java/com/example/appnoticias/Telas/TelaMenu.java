package com.example.appnoticias.Telas;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import com.example.appnoticias.R;

public class TelaMenu extends AppCompatActivity {
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
}
