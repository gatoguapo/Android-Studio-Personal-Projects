package com.example.proyectodispositivosmoviles;

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

import androidx.appcompat.app.AppCompatActivity;


public class ActivityPlatillos extends AppCompatActivity implements View.OnClickListener {

    BaseDeDatos Conexion;
    SQLiteDatabase BD;
    Button btnRecuperar, btnLimpiar, btnGrabar, btnBorrar, btnActualizar, btnConsultar;
    EditText txtIdPlatillo, txtNombre, txtPrecio, txtVigencia;
    AlertDialog alertDialog;
    Toast msg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platillos);
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

        txtIdPlatillo = findViewById(R.id.idTextPlatillo);
        txtNombre = findViewById(R.id.idTextNombrePlatillo);
        txtPrecio = findViewById(R.id.idTextPrecio);
        txtVigencia = findViewById(R.id.idTextVigenciaPlatillos);

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
            String sql = "Select * from Platillos where IdPlatillo='" + txtIdPlatillo.getText().toString() + "'";
            Cursor c = BD.rawQuery(sql, null);
            if (c.getCount() == 0) {
                alertDialog.setTitle(" Error ");
                alertDialog.setMessage("El idPlatillo no ha sido encontrado!!");
                alertDialog.show();
                return;
            }
            c.moveToLast();
            txtNombre.setText(c.getString(1));
            txtPrecio.setText(c.getInt(2) + "");
            txtVigencia.setText(c.getString(3));
        }

        if (view == btnLimpiar) {
            msg = Toast.makeText(this, "Ah limpiado las cajas de texto", Toast.LENGTH_LONG);
            msg.show();
            Limpiar();
        }

        if (view == btnGrabar) {

            if (txtIdPlatillo.length() == 0 || txtNombre.length() == 0 || txtPrecio.length() == 0 || txtVigencia.length() == 0) {
                alertDialog.setTitle(" Error ");
                alertDialog.setMessage("Debe proporcionar los valores faltantes");
                alertDialog.show();
                txtIdPlatillo.requestFocus();
                return;
            }
            String cadena = "INSERT INTO Platillos(IdPlatillo,Nombre,Precio,Vig) VALUES ('" + Integer.parseInt(txtIdPlatillo.getText().toString()) + "','"
                    + txtNombre.getText().toString() + "','" + Integer.parseInt(txtPrecio.getText().toString())
                    + "','" + txtVigencia.getText().toString() + "')";
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
            if (txtIdPlatillo.getText().toString().length() == 0 || txtNombre.getText().toString().length() == 0) {
                alertDialog.setTitle(" Error ");
                alertDialog.setMessage("Debe de proporcionar un platillo valido");
                alertDialog.show();
                txtIdPlatillo.requestFocus();
                return;
            }
            String cadena = "DELETE FROM Platillos WHERE IdPlatillo= '" + txtIdPlatillo.getText().toString() + "'";
            BD.execSQL(cadena);
            msg = Toast.makeText(this, "Borrado exitoso!", Toast.LENGTH_LONG);
            msg.show();
            Limpiar();
            return;
        }

        if (view == btnActualizar) {
            String cadena = "UPDATE Platillos SET Nombre='" + txtNombre.getText().toString() + "'," +
                    "Precio='" + Integer.parseInt(txtPrecio.getText().toString()) + "',Vig='" + txtVigencia.getText().toString() + "' WHERE IdPlatillo='" + txtIdPlatillo.getText().toString() + "'";
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
            Intent intent=new Intent(this,ActivityConsultaPlatillos.class);
            startActivity(intent);
        }

    }

    private void Limpiar(){
        txtIdPlatillo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtVigencia.setText("");
        txtIdPlatillo.requestFocus();
    }
}
