package com.example.cristian.mytoolbox.Base_De_Datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by machi on 17/11/2017.
 */

public class Conexion extends SQLiteOpenHelper {
    public Conexion(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Consultas.CREAR_TABLA_NOTAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS nota");
        onCreate(db);
    }
}
