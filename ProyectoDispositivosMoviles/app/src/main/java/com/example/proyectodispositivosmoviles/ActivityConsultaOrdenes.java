package com.example.proyectodispositivosmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TextView;

public class ActivityConsultaOrdenes extends AppCompatActivity {
    BaseDeDatos Conexion;
    SQLiteDatabase BD;
    TableLayout tablaIdOrdenes;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta_ordenes);

        alertDialog = new AlertDialog.Builder(this).create();

        Conexion = new BaseDeDatos(this, BaseDeDatos.databaseNombre, null, BaseDeDatos.version);
        BD = Conexion.getWritableDatabase();
        if (Conexion == null) {
            alertDialog.setTitle(" Error ");
            alertDialog.setMessage("No se ha podido conectar a la Base de Datos");
            alertDialog.show();
            return;
        }
        if (BD == null) {
            alertDialog.setTitle(" Error ");
            alertDialog.setMessage("La Base de Datos no se ha establecido para lectura y escritura");
            alertDialog.show();
            return;
        }

        tablaIdOrdenes = findViewById(R.id.idConsultaOrdenes);
        Procesar();
    }

    private void Procesar() {
        String cadena = "SELECT * FROM Ordenes ORDER BY Folio";
        Cursor c = BD.rawQuery(cadena, null);
        if (c.getCount() == 0) {
            alertDialog.setTitle("Error");
            alertDialog.setMessage("No hay ordenes registradas!");
            alertDialog.show();
            return;
        }
        TextView linea = new TextView(this);
        linea.setGravity(Gravity.CENTER);
        linea.setTextColor(Color.BLUE);
        linea.setTextSize(20);
        linea.setText("*** CONSULTA DE ORDENES***");
        tablaIdOrdenes.addView(linea);
        while (c.moveToNext()) {
            linea = new TextView(this);
            linea.setTextSize(20);
            linea.setText("Folio : " + c.getInt(0) + "\nIdPlatillo: " + c.getInt(1) + "\nIdCliente : " + c.getInt(2)
                    + "\nNoPlatillos : " + c.getInt(3) + "\nVigencia : " + c.getString(4) + "\n____________________________________");
            tablaIdOrdenes.addView(linea);
        }
    }
}