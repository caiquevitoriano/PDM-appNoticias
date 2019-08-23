package com.example.appnoticias.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
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


    public boolean salvar(String email,String nome, String senha){
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("EMAIL",email);
            contentValues.put("NOME",nome);
            contentValues.put("SENHA",senha);
            return gw.getDatabase().insertOrThrow(TABLE_USUARIOS, null, contentValues) > 0;
        }catch (SQLiteConstraintException ex){
            return false;
        }

    }

    public boolean excluir(int codigo){
        return gw.getDatabase().delete(TABLE_USUARIOS, "CODIGO=?", new String[]{ codigo + "" }) > 0;
    }

    public void alterar(Usuario usuario){
        ContentValues contentValues = new ContentValues();
        contentValues.put("EMAIL",usuario.getEmail());
        contentValues.put("NOME",usuario.getNome());
        contentValues.put("SENHA",usuario.getSenha());
        String[] parametros = new  String[1];
        parametros[0] = String.valueOf(usuario.getCodigo());

        gw.getDatabase().update(TABLE_USUARIOS,contentValues,"CODIGO = ?",parametros);

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

    public Usuario buscarUsuario(String email) {
        Usuario usuario = new Usuario();
        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM USUARIOS WHERE EMAIL = '"+ email +"'", null);
        while(cursor.moveToNext()){
            usuario.setCodigo(cursor.getInt(0));
            usuario.setEmail(cursor.getString(1));
            usuario.setNome(cursor.getString(2));
            usuario.setSenha(cursor.getString(3));
        }
        cursor.close();
        return usuario;
    }

    public Usuario usuarioAutenticar (String email,String senha) {
        Usuario usuario = new Usuario();

        Cursor cursor = gw.getDatabase().rawQuery("SELECT * FROM USUARIOS WHERE EMAIL = '"+ email +"' and senha = '"+senha+"'", null);
        while(cursor.moveToNext()){
            usuario.setCodigo(cursor.getInt(0));
            usuario.setEmail(cursor.getString(1));
            usuario.setNome(cursor.getString(2));
            usuario.setSenha(cursor.getString(3));
        }
        cursor.close();
        System.out.println("deu certo!");
        return usuario;
    }



}
