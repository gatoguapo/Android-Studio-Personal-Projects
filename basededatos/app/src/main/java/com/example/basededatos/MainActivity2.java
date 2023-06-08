package com.example.basededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    BaseDeDatos Conexion;
    SQLiteDatabase BD;
    TableLayout tablaId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Conexion=new BaseDeDatos(this, "AGENCIAAUTOS", null, BaseDeDatos.version);

        if(Conexion==null){
            Rutinas.mensajeDialog("No se ha conectado a la BD",this);
            return;
        }
        BD = Conexion.getWritableDatabase();
        if( BD == null){
            Rutinas.mensajeDialog("La BD no se ha establecido para lectura y escritura",this);
            return;
        }
        tablaId = findViewById(R.id.tablaId);
        Procesar();
     }
     private void Procesar(){
        String cadena="SELECT * FROM AUTOS ORDER BY PLACA";
         Cursor c =BD.rawQuery(cadena,null);
         if( c.getCount()==0){
             Rutinas.mensajeDialog("no hay autos registrados !!!!!!!!",this);
             return;
         }
         TextView linea=new TextView(this);
         linea.setGravity(Gravity.CENTER);
         linea.setTextColor(Color.BLUE);
         linea.setTextSize(20);
         linea.setText(" *** CONSULTA DE AUTOS***");
         tablaId.addView(linea);
         while (c.moveToNext()){
             linea=new TextView(this);
             linea.setTextSize(20);
             linea.setText( "Placa ; "+c.getString(0) +"\nMarca: "+c.getString(1)+"\nAño : "+c.getInt(2) +"\n______________________");
             tablaId.addView(linea);
         }

     }
}