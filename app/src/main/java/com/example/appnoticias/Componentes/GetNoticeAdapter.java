package com.example.appnoticias.Componentes;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.appnoticias.Model.Noticia;

import java.util.List;

public class GetNoticeAdapter extends BaseAdapter {

    private final List<Noticia> noticias;
    private final Activity activity;

    public GetNoticeAdapter(Activity activity, List<Noticia> noticias) {
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

        return new Noticias(activity,noticia.getTitulo(),noticia.getDescricao(),noticia.getData());
    }
}
