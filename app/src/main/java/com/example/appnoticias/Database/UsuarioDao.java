package com.example.appnoticias.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.appnoticias.Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    private final String TABLE_USUARIOS = "USUARIOS";
    private DbGateway gw;

    public UsuarioDao(Context ctx){
        gw = DbGateway.getInstance(ctx);
    }


    public boolean salvar(int codigo,String email,String nome, String senha){
        ContentValues contentValues = new ContentValues();
        contentValues.put("EMAIL",email);
        contentValues.put("NOME",nome);
        contentValues.put("SENHA",senha);
        if(codigo > 0)
            return gw.getDatabase().update(TABLE_USUARIOS, contentValues, "CODIGO=?", new String[]{ codigo + "" }) > 0;
        else
        return gw.getDatabase().insert(TABLE_USUARIOS, null, contentValues) > 0;


    }

    public boolean excluir(int codigo){
        return gw.getDatabase().delete(TABLE_USUARIOS, "CODIGO=?", new String[]{ codigo + "" }) > 0;
    }



    public List<Usuario>listar(){
        List<Usuario> usuarios = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM USUARIOS", null);
        while(cursor.moveToNext()){
            Usuario usuario = new Usuario();
            usuario.setCodigo(cursor.getInt(0));
            usuario.setEmail(cursor.getString(1));
            usuario.setNome(cursor.getString(2));
            usuario.setSenha(cursor.getString(3));

            usuarios.add(usuario);
        }
        cursor.close();
        return usuarios;
    }

    public List<Usuario>buscarUsuario(int codigo) {
        List<Usuario> usuarios = new ArrayList<>();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM USUARIOS WHERE CODIGO = '"+ codigo +"'", null);
        while(cursor.moveToNext()){
            Usuario usuario = new Usuario();
            usuario.setCodigo(cursor.getInt(0));
            usuario.setEmail(cursor.getString(1));
            usuario.setNome(cursor.getString(2));
            usuario.setSenha(cursor.getString(3));

            usuarios.add(usuario);
        }
        cursor.close();
        return usuarios;
    }




}
