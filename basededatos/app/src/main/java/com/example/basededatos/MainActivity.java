package com.example.basededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    BaseDeDatos Conexion;
    SQLiteDatabase BD;

    private EditText txtPlaca, txtMarca, txtYear;
    private Button btnRecuperar, btnLimpiar, btnGrabar, btnBorrar, btnActualziar, btnConsultar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        txtPlaca = findViewById(R.id.txtPlaca);
        txtMarca=findViewById(R.id.txtMarca);
        txtYear=findViewById(R.id.txtYear);
        btnRecuperar=findViewById(R.id.btnRecuperar);
        btnLimpiar=findViewById(R.id.btnLimpiar);
        btnGrabar=findViewById(R.id.btnGrabar);
        btnBorrar=findViewById(R.id.btnBorrar);
        btnConsultar=findViewById(R.id.btnConsultar);
        btnActualziar=findViewById(R.id.btnActualizar);

        btnGrabar.setOnClickListener(this);
        btnConsultar.setOnClickListener(this);
        btnRecuperar.setOnClickListener(this);
        btnBorrar.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);
        btnActualziar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if( v == btnGrabar){
            String placa=txtPlaca.getText().toString();
            String marca=txtMarca.getText().toString();
            if(txtYear.getText().toString().length()==0){
                Rutinas.mensajeDialog("Debe proporcionar el año del auto",this);
                txtYear.requestFocus();
                return;
            }
            int año=Integer.parseInt(txtYear.getText().toString());
            if(placa.length()==0 || marca.length()==0){
                Rutinas.mensajeDialog("Debe proporcionar placa y modelo",this);
                txtYear.requestFocus();

            }
            String cadena="INSERT INTO AUTos (PLACA,MARCA,YEAR) VALUES ('"+placa+"','"+marca+"',"+año+")";
            try {
                BD.execSQL(cadena);
            } catch (SQLException e){
                Rutinas.mensajeDialog("Se ha intentado duplicar información",this);
                return;
            }
            Rutinas.mensajeToast("Registro exitoso !!!!!",this);
            Limpiar();
            return;
        }
        if( v==btnLimpiar){
            Limpiar();
        }
        if( v == btnRecuperar){
            String sql="Select * from AUTOS where PLACA='"+txtPlaca.getText().toString()+"'";
            Cursor c =BD.rawQuery(sql,null);
            if( c.getCount()==0){
                Rutinas.mensajeDialog("La placa no ha sido encontrada",this);
                return;
            }
            c.moveToLast();
            txtMarca.setText(c.getString(1));
            txtYear.setText(c.getInt(2)+"");
        }
        if( v== btnBorrar){
            if ( txtPlaca.getText().toString().length()==0 || txtMarca.getText().toString().length()==0){
                Rutinas.mensajeDialog("Debe de proporcionar placa valida",this);
                return;
            }
            String cadena="DELETE FROM AUTOS WHERE PLACA= '"+txtPlaca.getText().toString()+"'";
            BD.execSQL(cadena);
            Rutinas.mensajeToast("Borrado exitoso !!!!!!",this);
            Limpiar();
            return;
        }
        if( v== btnActualziar){

            String cadena="UPDATE AUTOS SET MARCA='"+txtMarca.getText().toString()+"'," +
                    "YEAR="+txtYear.getText().toString()+" WHERE PLACA='"+txtPlaca.getText().toString()+"'";
           try {
               BD.execSQL(cadena);
           } catch(SQLException e){
               Rutinas.mensajeDialog("No puede actualziar la placa con una placa regsitrada ´reviamente",this);
               return;
           }
           Limpiar();
        }
        if( v == btnConsultar){
            Intent intent=new Intent(this,MainActivity2.class);
            startActivity(intent);

        }
    }
    private void Limpiar(){
        txtPlaca.setText("");
        txtMarca.setText("");
        txtYear.setText("");
        txtPlaca.requestFocus();
    }
}