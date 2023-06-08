package com.example.proyectodispositivosmoviles;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDeDatos extends SQLiteOpenHelper {
    static int version = 2;
    static String databaseNombre = "RESTAURANTE";
    private String tablaPlatillos = "create table Platillos(IdPlatillo integer primary key, Nombre TEXT, Precio integer, Vig text)";
    private String tablaClientes = "create table Clientes(IdCliente integer primary key, Nombre TEXT, Vig text)";
    private String tablaOrdenes = "create table Ordenes(Folio integer,IdPlatillo integer,IdCliente integer, NoPlatillos integer, Vig text, PRIMARY KEY(Folio, IdPlatillo))";

    public BaseDeDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(tablaPlatillos);
        bd.execSQL(tablaClientes);
        bd.execSQL(tablaOrdenes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Platillos");
        db.execSQL("DROP TABLE IF EXISTS Clientes");
        db.execSQL("DROP TABLE IF EXISTS Ordenes");
        db.execSQL(tablaPlatillos);
        db.execSQL(tablaClientes);
        db.execSQL(tablaOrdenes);
    }
}
