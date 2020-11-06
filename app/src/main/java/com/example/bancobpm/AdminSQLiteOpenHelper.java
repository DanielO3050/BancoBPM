package com.example.bancobpm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    // constructor de la base de datos.
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // OnCreate: donde se define la configuracion inicial de la base de datos.
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Clientes (codigo int primary key, nombre text, salario int)");

    }

    // OnUpgrade: metodo donde se implementan los cambios esquematicos de mi base de datos.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}