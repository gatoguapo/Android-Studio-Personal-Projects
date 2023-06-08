package com.example.proyectodispositivosmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityOrdenes extends AppCompatActivity implements View.OnClickListener{
    BaseDeDatos Conexion;
    SQLiteDatabase BD;
    Button btnRecuperar, btnLimpiar, btnGrabar, btnBorrar, btnActualizar, btnConsultar;
    EditText txtFolio, txtIdPlatillo, txtIdCliente, txtNoPlatillos, txtVigencia;
    AlertDialog alertDialog;
    Toast msg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordenes);
        Conexion = new BaseDeDatos(this, BaseDeDatos.databaseNombre, null, BaseDeDatos.version);
        BD = Conexion.getWritableDatabase();
        alertDialog = new AlertDialog.Builder(this).create();

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

        txtFolio = findViewById(R.id.idTextFolio);
        txtIdPlatillo = findViewById(R.id.idTextPlatillo);
        txtIdCliente = findViewById(R.id.idTextCliente);
        txtNoPlatillos = findViewById(R.id.idTextNoPlatillos);
        txtVigencia = findViewById(R.id.idTextVigenciaOrdenes);

        btnRecuperar = findViewById(R.id.idBtnRecuperar);
        btnLimpiar = findViewById(R.id.idBtnLimpiar);
        btnGrabar = findViewById(R.id.idBtnGrabar);
        btnBorrar = findViewById(R.id.idBtnBorrar);
        btnActualizar = findViewById(R.id.idBtnActualizar);
        btnConsultar = findViewById(R.id.idBtnConsultar);

        HazEscuchas();
    }

    public void HazEscuchas() {
        btnRecuperar.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);
        btnGrabar.setOnClickListener(this);
        btnBorrar.setOnClickListener(this);
        btnActualizar.setOnClickListener(this);
        btnConsultar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnRecuperar) {
            String sql = "Select * from Ordenes where Folio='" + txtFolio.getText().toString() + "'";
            Cursor c = BD.rawQuery(sql, null);
            if (c.getCount() == 0) {
                alertDialog.setTitle(" Error ");
                alertDialog.setMessage("El Folio no ha sido encontrado!!");
                alertDialog.show();
                return;
            }
            c.moveToLast();
            txtIdPlatillo.setText(c.getInt(1)+ "");
            txtIdCliente.setText(c.getInt(2) + "");
            txtNoPlatillos.setText(c.getInt(3) + "");
            txtVigencia.setText(c.getString(4));
        }

        if (view == btnLimpiar) {
            msg = Toast.makeText(this, "Ah limpiado las cajas de texto", Toast.LENGTH_LONG);
            msg.show();
            Limpiar();
        }

        if (view == btnGrabar) {

            if (txtFolio.length() == 0 || txtIdPlatillo.length() == 0 || txtIdCliente.length() == 0 || txtNoPlatillos.length() == 0 || txtVigencia.length() == 0) {
                alertDialog.setTitle(" Error ");
                alertDialog.setMessage("Debe proporcionar los valores faltantes");
                alertDialog.show();
                txtFolio.requestFocus();
                return;
            }
            String cadena = "INSERT INTO Ordenes(Folio,IdPlatillo,IdCliente,NoPlatillos,Vig) VALUES ('" + Integer.parseInt(txtFolio.getText().toString()) + "','"
                    + Integer.parseInt(txtIdPlatillo.getText().toString()) + "','" + Integer.parseInt(txtIdCliente.getText().toString()) + "','"
                    + Integer.parseInt(txtNoPlatillos.getText().toString()) + "','" + txtVigencia.getText().toString() + "')";
            try {
                BD.execSQL(cadena);
            } catch (SQLException e) {
                alertDialog.setTitle(" Error ");
                alertDialog.setMessage("Se ha intentado duplicar información");
                alertDialog.show();
                return;
            }
            msg = Toast.makeText(this, "Grabado exitoso!", Toast.LENGTH_LONG);
            msg.show();
        }

        if (view == btnBorrar) {
            if (txtFolio.getText().toString().length() == 0) {
                alertDialog.setTitle(" Error ");
                alertDialog.setMessage("Debe de proporcionar un folio valido");
                alertDialog.show();
                txtIdPlatillo.requestFocus();
                return;
            }
            String cadena = "DELETE FROM Ordenes WHERE Folio= '" + txtFolio.getText().toString() + "'";
            BD.execSQL(cadena);
            msg = Toast.makeText(this, "Borrado exitoso!", Toast.LENGTH_LONG);
            msg.show();
            Limpiar();
            return;
        }

        if (view == btnActualizar) {
            String cadena = "UPDATE Ordenes SET IdPlatillo='" + Integer.parseInt(txtIdPlatillo.getText().toString())
                    + "',IdCliente='" + Integer.parseInt(txtIdCliente.getText().toString()) + "',NoPlatillos='" + Integer.parseInt(txtNoPlatillos.getText().toString())
                    + "',Vig='" + txtVigencia.getText().toString() + "' WHERE Folio='" + txtFolio.getText().toString() + "'";
            try {
                BD.execSQL(cadena);
            } catch(SQLException e){
                alertDialog.setTitle(" Error ");
                alertDialog.setMessage("No puede actualizar el platillo con un id regsitrado previamente");
                alertDialog.show();
                return;
            }
            msg = Toast.makeText(this, "Actualizacion exitosa!", Toast.LENGTH_LONG);
            msg.show();
        }

        if (view == btnConsultar) {
            Intent intent=new Intent(this,ActivityConsultaOrdenes.class);
            startActivity(intent);
        }

    }

    private void Limpiar(){
        txtFolio.setText("");
        txtIdPlatillo.setText("");
        txtIdCliente.setText("");
        txtNoPlatillos.setText("");
        txtVigencia.setText("");

        txtFolio.requestFocus();
    }
}