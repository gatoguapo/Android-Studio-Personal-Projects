package com.example.appsem109;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TableLayout tabla ;
    Drawable fondo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        // Layot asociado a Java
        tabla= findViewById(R.id.tabla);
        fondo=getDrawable(R.drawable.fondo);
   //     tabla.setPadding(20,20,20,20);
        // Recupero arrewglos
        Bundle bundle = getIntent().getExtras();

        String [] nombres = bundle.getStringArray("nombres");
        int [] edades = bundle.getIntArray("edades");

        Mostrar(nombres, edades);

    }
    private void Mostrar(String [] nombres, int [] edades){
        TextView linea=new TextView(this);
        linea.setGravity(Gravity.CENTER);
        linea.setTextColor(Color.BLUE);
        linea.setTextSize(20);
        linea.setText(" *** CONSULTA DE EMPLEADOs ***");
        tabla.addView(linea);

        for(int i=0 ; i<nombres.length ; i++){
            linea=new TextView(this);
            linea.setTextSize(20);
           linea.setBackground(fondo);

            linea.setText("Nombre : "+ nombres[i]+" \nEdad:   "+edades[i]+"\n");
            tabla.addView(linea);



        }





    }
}