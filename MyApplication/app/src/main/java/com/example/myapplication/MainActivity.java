package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnGenerar, btnEnviar;
    private TextView cajaAlumno, cajaNControl, cajaContraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGenerar =findViewById(R.id.btnGenerar);
        btnEnviar =findViewById(R.id.btnEnviar);

        cajaAlumno = findViewById(R.id.cajaAlumno);
        cajaNControl = findViewById(R.id.cajaNControl);
        cajaContraseña = findViewById(R.id.cajaContraseña);

        HazEscuchas();
    }

    public void HazEscuchas() {
        btnGenerar.setOnClickListener(this);
        btnEnviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==btnGenerar) {
            GeneraDatos();
        }
        if (v==btnEnviar) {
            CompruebaDatos();
        }
    }

    public void GeneraDatos() {
        String [] alumnos = {"Ramirez" , "Gastelum Chaparro", "Mokina Angulo", "Javi", "gatoguapo", "Kenyi Shigeru", "Juan Manuel", "Oscar Beltran", "Clemente Garcia"};
        cajaAlumno.setText(alumnos[(int)(Math.random()*9)]);
        cajaNControl.setText("2017"+(int)(Math.random()*(9999-1000+1)+1000));
    }

    public void CompruebaDatos() {
        if (cajaAlumno.getText().toString().trim().length()==0) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle(" Mensaje ");
            alertDialog.setMessage("Ingrese el nombre del Alumno!!");alertDialog.show();
            return;
        }
        if (cajaNControl.getText().toString().trim().length()==0) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle(" Mensaje ");
            alertDialog.setMessage("Ingrese el número de control!!");alertDialog.show();
            return;
        }
        if (cajaContraseña.getText().toString().trim().length()==0) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle(" Mensaje ");
            alertDialog.setMessage("Ingrese la contraseña!!");alertDialog.show();
            return;
        }
        else {
            Toast msg = Toast.makeText(this, "Felicidades "+ cajaAlumno.getText().toString() +" todo correcto :)",Toast.LENGTH_LONG);
            msg.show();
        }
    }
}