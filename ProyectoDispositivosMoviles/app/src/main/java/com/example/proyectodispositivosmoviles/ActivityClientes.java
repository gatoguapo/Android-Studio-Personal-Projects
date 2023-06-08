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

public class ActivityClientes extends AppCompatActivity implements View.OnClickListener{
    BaseDeDatos Conexion;
    SQLiteDatabase BD;
    Button btnRecuperar, btnLimpiar, btnGrabar, btnBorrar, btnActualizar, btnConsultar;
    EditText txtIdClientes, txtNombre, txtVigencia;
    AlertDialog alertDialog;
    Toast msg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
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

        txtIdClientes = findViewById(R.id.idTextCliente);
        txtNombre = findViewById(R.id.idTextNombreCliente);
        txtVigencia = findViewById(R.id.idTextVigCliente);

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
            String sql = "Select * from Clientes where IdCliente='" + txtIdClientes.getText().toString() + "'";
            Cursor c = BD.rawQuery(sql, null);
            if (c.getCount() == 0) {
                alertDialog.setTitle(" Error ");
                alertDialog.setMessage("El idCliente no ha sido encontrado!!");
                alertDialog.show();
                return;
            }
            c.moveToLast();
            txtNombre.setText(c.getString(1));
            txtVigencia.setText(c.getString(2));
        }

        if (view == btnLimpiar) {
            msg = Toast.makeText(this, "Ah limpiado las cajas de texto", Toast.LENGTH_LONG);
            msg.show();
            Limpiar();
        }

        if (view == btnGrabar) {
            if (txtIdClientes.length() == 0 || txtNombre.length() == 0 || txtVigencia.length() == 0) {
                alertDialog.setTitle(" Error ");
                alertDialog.setMessage("Debe proporcionar los valores faltantes");
                alertDialog.show();
                txtIdClientes.requestFocus();
                return;
            }
            String cadena = "INSERT INTO Clientes(IdCliente,Nombre,Vig) VALUES ('" + Integer.parseInt(txtIdClientes.getText().toString()) + "','"
                    + txtNombre.getText().toString() + "','" + txtVigencia.getText().toString() + "')";
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
            if (txtIdClientes.getText().toString().length() == 0 || txtNombre.getText().toString().length() == 0) {
                alertDialog.setTitle(" Error ");
                alertDialog.setMessage("Debe de proporcionar un cliente valido");
                alertDialog.show();
                txtIdClientes.requestFocus();
                return;
            }
            String cadena = "DELETE FROM Clientes WHERE IdCliente= '" + txtIdClientes.getText().toString() + "'";
            BD.execSQL(cadena);
            msg = Toast.makeText(this, "Borrado exitoso!", Toast.LENGTH_LONG);
            msg.show();
            Limpiar();
            return;
        }

        if (view == btnActualizar) {
            String cadena = "UPDATE Clientes SET Nombre='" + txtNombre.getText().toString()
                    + "',Vig='" + txtVigencia.getText().toString() + "' WHERE IdCliente='" + txtIdClientes.getText().toString() + "'";
            try {
                BD.execSQL(cadena);
            } catch(SQLException e){
                alertDialog.setTitle(" Error ");
                alertDialog.setMessage("No puede actualizar el cliente con un id registrado previamente");
                alertDialog.show();
                return;
            }
            msg = Toast.makeText(this, "Actualizacion exitosa!", Toast.LENGTH_LONG);
            msg.show();
        }

        if (view == btnConsultar) {
            Intent intent=new Intent(this,ActivityConsultaClientes.class);
            startActivity(intent);
        }

    }

    private void Limpiar(){
        txtIdClientes.setText("");
        txtNombre.setText("");
        txtVigencia.setText("");
        txtIdClientes.requestFocus();
    }
}