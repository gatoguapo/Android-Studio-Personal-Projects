package com.example.appsem109;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnGenerar, btnLimpiar, btnActividad;
    EditText  txtNombre, txtNoControl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGenerar= findViewById(R.id.btnGenerar);
        btnLimpiar=findViewById(R.id.btnLimpiar);
        btnActividad=findViewById(R.id.btnActividad);
        txtNombre = findViewById(R.id.txtNombre);
        txtNoControl = findViewById(R.id.txtNoControl);
        int l=txtNombre.getText().toString().length();
        HazEscuchas();

    }
    private void HazEscuchas(){
        btnLimpiar.setOnClickListener(this);
        btnGenerar.setOnClickListener(this);
        btnActividad.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if( v==btnGenerar){

            txtNoControl.setText("2017"+Rutinas.nextInt(1000,9999));
            txtNombre.setText(Rutinas.nextNombre(1));
    /*
           AlertDialog alertDialog = new AlertDialog.Builder(this).create();
           alertDialog.setTitle(" Mensaje ");
           alertDialog.setMessage("Se han generado datos alesastorios");alertDialog.show();
*/

        Rutinas.mensajeDialog("Se ha generado aleatoriamente los datos ",this);

            return;
        }
        if( v==btnLimpiar){
          //  Toast msg = Toast.makeText(getBaseContext(), "*** Limpieza realizada ***",Toast.LENGTH_LONG);msg.show();
            Rutinas.mensajeToast("Limpieza realizada exitosamente !!!!", this);
            txtNombre.setText("");
            txtNoControl.setText("");
            return;
        }
        if( v == btnActividad){
            if( txtNombre.getText().toString().trim().length()==0){
                Rutinas.mensajeDialog("El nombre es obligatorio !!!!",this);
                txtNombre.requestFocus();
                return;
            }
            if( txtNoControl.getText().toString().trim().length()==0){
                Rutinas.mensajeDialog("El no CONTROL es obligatorio !!!!",this);
                txtNombre.requestFocus();
                return;
            }


            Intent actividad = new Intent(this, MainActivity2.class);
            actividad.putExtra("noControl",txtNoControl.getText().toString());
            actividad.putExtra("cotizacion",20.22f);
            actividad.putExtra("nombre",txtNombre.getText().toString());
            actividad.putExtra("edad",28);
            actividad.putExtra("hijos",10l);

            startActivity(actividad);
            return;
        }


    }
}