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

public class ActivityReporte1 extends AppCompatActivity {
    BaseDeDatos Conexion;
    SQLiteDatabase BD;
    TableLayout tablaIdReporte1;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte1);

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

        tablaIdReporte1 = findViewById(R.id.idReporte1);
        Procesar();
    }

    private void Procesar() {
        String cadena = "SELECT p.IdPlatillo, p.Nombre, o.NoPlatillos, (p.Precio * o.NoPlatillos) as Importe " +
                "FROM Platillos p INNER JOIN Ordenes o ON p.IdPlatillo = o.IdPlatillo WHERE (o.NoPlatillos >= 10) OR "
                + "(Importe >= 1000) GROUP BY p.IdPlatillo";
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
        linea.setText("*** CONSULTA DE REPORTE 1***");
        tablaIdReporte1.addView(linea);
        while (c.moveToNext()) {
            linea = new TextView(this);
            linea.setTextSize(20);
            linea.setText("Id Platillo : " + c.getInt(0) + "\nPlatillo: " + c.getString(1) + "\nNumero Platillos : " + c.getInt(2)
                    + "\nImporte : " + c.getInt(3) + "\n____________________________________");
            tablaIdReporte1.addView(linea);
        }
    }
}
