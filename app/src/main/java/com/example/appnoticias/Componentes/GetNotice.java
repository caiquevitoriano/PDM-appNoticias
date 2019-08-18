package com.example.appnoticias.Componentes;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.appnoticias.Model.Noticia;

import java.util.List;

public class GetNotice extends BaseAdapter {

    private final List<Noticia> noticias;
    private final Activity activity;

    public GetNotice(Activity activity, List<Noticia> noticias) {
        Log.i("APP_INFO","Adapter para noticia criado com "+noticias.size()+" noticias!");
        this.noticias = noticias;
        this.activity = activity;
    }


    @Override
    public int getCount() {
        return noticias.size();
    }

    @Override
    public Object getItem(int i) {
        return noticias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Noticia noticia = noticias.get(i);

        return new CardViewNoticia(activity,noticia.getTitulo(),noticia.getDescricao(),noticia.getData());
    }
}
