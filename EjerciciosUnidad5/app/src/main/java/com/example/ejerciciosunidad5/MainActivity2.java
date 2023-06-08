package com.example.appsem109;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private Button btnConsulta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnConsulta = findViewById(R.id.btnConsulta);
        btnConsulta.setOnClickListener(this);

        int edad=getIntent().getIntExtra("edad",0);
        String nombre=getIntent().getStringExtra("nombre");
        String noControl=getIntent().getStringExtra("noControl");
        float cotizacion=getIntent().getFloatExtra("Cotizacion",0);
        long hijos= getIntent().getLongExtra("hijos",-1);

        System.out.println("_______________________________________");
        System.out.println("No Control "+noControl);
        System.out.println("Nombre     "+nombre);
        System.out.println("Edad        "+edad);
        System.out.println("Cotización "+cotizacion);
        System.out.println("Hijos       "+hijos);

        System.out.println("_______________________________________");


    }

    @Override
    public void onClick(View v) {
        if( v == btnConsulta){
            String [] nombres={"Alicia","JUan","Pedro","Sofia","Zoila","Alicia","JUan","Pedro","Sofia","Zoila",
                    "Alicia","JUan","Pedro","Sofia","Zoila","Alicia","JUan","Pedro","Sofia","Zoila"};
            int [] edades={18,22,33,19,54,18,22,33,19,54,18,22,33,19,54,18,22,33,19,54};

            Bundle bundle=new Bundle();
            bundle.putStringArray("nombres", nombres);
            bundle.putIntArray("edades",edades);

            Intent actividad = new Intent(this, MainActivity3.class);
            actividad.putExtras(bundle);
            startActivity(actividad);
        }

    }
}