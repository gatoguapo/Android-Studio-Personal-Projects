package com.example.proyectodispositivosmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.idItemPlatillos) {
            Intent intent=new Intent(this, ActivityPlatillos.class);
            startActivity(intent);
        } else if (id == R.id.idItemClientes) {
            Intent intent=new Intent(this, ActivityClientes.class);
            startActivity(intent);
        } else if (id == R.id.idItemOrdenes) {
            Intent intent=new Intent(this, ActivityOrdenes.class);
            startActivity(intent);
        } else if (id == R.id.idItemReporte1) {
            Intent intent=new Intent(this, ActivityReporte1.class);
            startActivity(intent);
        } else if (id == R.id.idItemReporte2) {
            Intent intent=new Intent(this, ActivityReporte2.class);
            startActivity(intent);
        } else if (id == R.id.idItemReporte3) {
            Intent intent=new Intent(this, ActivityReporte3.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}