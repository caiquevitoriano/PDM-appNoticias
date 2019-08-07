package com.example.appnoticias.Database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.example.appnoticias.Model.Usuario;

import java.util.List;

public class UsuarioRepositorio {
    private SQLiteDatabase conexao;

    public UsuarioRepositorio(SQLiteDatabase conexao){
        this.conexao = conexao;
    }

    public void inserir(Usuario usuario ){
        ContentValues contentValues = new ContentValues();
        contentValues.put("EMAIL",usuario.getEmail());
        contentValues.put("NOME",usuario.getNome());
        contentValues.put("SENHA",usuario.getSenha());
        conexao.insertOrThrow("USUARIO",null,contentValues);
    }

    public void excluir(int codigo){
        String[] parametros = new  String[1];
        parametros[0] = String.valueOf(codigo);

        conexao.delete("USUARIO","CODIGO = ?", parametros);
    }

    public void alterar(Usuario usuario){
        ContentValues contentValues = new ContentValues();
        contentValues.put("EMAIL",usuario.getEmail());
        contentValues.put("NOME",usuario.getNome());
        contentValues.put("SENHA",usuario.getSenha());
        String[] parametros = new  String[1];
        parametros[0] = String.valueOf(usuario.getCodigo());

        conexao.update("USUARIO",contentValues,"CODIGO = ?",parametros);
    }

    public List<Usuario>buscarTodos(){

        return null;
    }

    public Usuario buscarUsuario(int codigo){
        return null;
    }
}
