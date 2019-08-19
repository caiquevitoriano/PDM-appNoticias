package com.example.appnoticias.Telas;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import com.example.appnoticias.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;


//public class MainActivity extends AppCompatActivity {
public class SideBar extends Activity implements NavigationView.OnNavigationItemSelectedListener {

    private ViewGroup header(){
        //
        TextView tv = new TextView(this);
        tv.setText("Cabeçalho");
        //
        LinearLayout l = new LinearLayout(this);
        l.addView(tv);
        //
        return l;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //criando o layout e vinculando ao activity
        DrawerLayout drawer = new DrawerLayout(this);
        setContentView(drawer);
        //criando o navbar
        AppBarLayout bar = new AppBarLayout(this);
        Toolbar toolbar = new Toolbar(this);
        toolbar.setBackgroundColor(Color.RED);
        toolbar.setElevation(10);
        //setSupportActionBar(toolbar); descomente se tiver usando AppCompatActivity
        bar.addView(toolbar);
        drawer.addView(bar, 0, new DrawerLayout.LayoutParams(
                DrawerLayout.LayoutParams.MATCH_PARENT,//comprimento
                DrawerLayout.LayoutParams.WRAP_CONTENT//altura
        ));
        //
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);//para sincronizar ao fechar
        toggle.syncState();
        //
        //criar os paramentros do layout para definir a gravidade
        DrawerLayout.LayoutParams params = new DrawerLayout.LayoutParams(
                DrawerLayout.LayoutParams.WRAP_CONTENT,//comprimento
                DrawerLayout.LayoutParams.MATCH_PARENT//altura
        );
        params.gravity = Gravity.LEFT;//informar de onde sai a bandeija
        //adicionar ao layout
        NavigationView navigationView = new NavigationView(this);
        drawer.addView(navigationView, 1, params);
        navigationView.getMenu().add(0, 0, 0, "menu #1");
        navigationView.getMenu().add(0, 1, 1, "menu #2");
        //
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.addHeaderView(header());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == 0){
            Toast.makeText(this, "Selecionou o menu 1", Toast.LENGTH_LONG).show();
        } else if (menuItem.getItemId() == 1){
            Toast.makeText(this, "Selecionou o menu 2", Toast.LENGTH_LONG).show();
        }
        return false;
    }
}
