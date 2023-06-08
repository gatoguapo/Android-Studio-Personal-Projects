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

public class ActivityReporte3 extends AppCompatActivity {
    BaseDeDatos Conexion;
    SQLiteDatabase BD;
    TableLayout tablaIdReporte3;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte3);

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

        tablaIdReporte3 = findViewById(R.id.idReporte3);
        Procesar();
    }

    private void Procesar() {

        String cadena = "SELECT c.IdCliente, c.Nombre, p.Nombre, o.NoPlatillos "
                + "FROM Ordenes o INNER JOIN Platillos p ON o.IdPlatillo = p.IdPlatillo "
                + "INNER JOIN Clientes c ON o.IdCliente = c.IdCliente WHERE (o.NoPlatillos<=5) GROUP BY o.Folio";

        Cursor c = BD.rawQuery(cadena, null);
        if (c.getCount() == 0) {
            alertDialog.setTitle("Error");
            alertDialog.setMessage("No se encontró el reporte!");
            alertDialog.show();
            return;
        }
        TextView linea = new TextView(this);
        linea.setGravity(Gravity.CENTER);
        linea.setTextColor(Color.BLUE);
        linea.setTextSize(20);
        linea.setText("*** CONSULTA DE REPORTE 3***");
        tablaIdReporte3.addView(linea);
        while (c.moveToNext()) {
            linea = new TextView(this);
            linea.setTextSize(20);
            linea.setText("Id Cliente : " + c.getInt(0) + "\nNombre: " + c.getString(1) + "\nPlatillo: " + c.getString(2) + "\nVeces Comprado: " + c.getInt(3)
                    + "\n____________________________________");
            tablaIdReporte3.addView(linea);
        }
    }
}