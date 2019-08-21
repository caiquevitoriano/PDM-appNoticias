package com.example.appnoticias.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import com.example.appnoticias.Model.Noticia;

import java.util.ArrayList;
import java.util.List;

public class NoticiaDao {
    private final String TABLE_NOTICIA = "NOTICIA";
    private DbGateway gw;

    public NoticiaDao(Context ctx) {
        gw = DbGateway.getInstance(ctx);
    }

    public boolean salvar(String titulo, String link, String data, String descricao, String conteudo){
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("TITULO",titulo);
            contentValues.put("LINK",link);
            contentValues.put("DATA",data);
            contentValues.put("DESCRICAO",descricao);
            contentValues.put("CONTEUDO",conteudo);
            return gw.getDatabase().insertOrThrow(TABLE_NOTICIA, null, contentValues) > 0;
        }catch (SQLiteConstraintException ex){
            return false;
        }
    }

    public List<Noticia> listar(){
        List<Noticia> noticias = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM NOTICIA", null);
        while(cursor.moveToNext()){
            Noticia noticia = new Noticia();
            noticia.setCodigo(cursor.getInt(0));
            noticia.setTitulo(cursor.getString(1));
            noticia.setLink(cursor.getString(2));
            noticia.setData(cursor.getString(3));
            noticia.setDescricao(cursor.getString(4));
            noticia.setConteudo(cursor.getString(5));

            noticias.add(noticia);
        }
        cursor.close();
        return noticias;
    }


}
