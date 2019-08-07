package com.example.appnoticias.Database;

public class ScriptDDL {
    public static String getCreateTableUsuario(){
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS USUARIO ( ");
        sql.append("EMAIL VARCHAR(200) PRIMARY KEY NOT NULL DEFAULT (''), ");
        sql.append("NOME VARCHAR (200) NOT NULL DEFAULT (''), ");
        sql.append("SENHA VARCHAR (20) NOT NULL DEFAULT ('') ");
        sql.append(") ");
        return sql.toString();

    }
}

//nome,email,senha