package com.example.appsem109;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

import java.util.*;
public class Rutinas {
    static Random r=new Random();
    static String []VN ={"Zoila","Daniel","Yessenia","Luis","Anastacia","Plutarco","Alicia","Maria","Sofia","Antonio","Nereida","Carolina",
            "Rebeca","Javier","Luis"};
    static String [] VA={"Garcia","Lopez","Perez","Urias","Mendoza","Coppel","Diaz"};
    static boolean [] Sexo={false,true,false,true,false,true,false,false,false,true,false,false,false,true,true};
    public static String nextNombre(int Numero){
        String Nom="",NomTra="";
        int Pos;
        boolean Genero=true;

        for(int i=0;i<Numero;i++){
            Pos=nextInt(VN.length);

            NomTra=VN[Pos]+" ";

            if (i==0){
                Genero=Sexo[Pos];

            }

            if( Genero != Sexo[Pos]  || i>0 && Nom.indexOf(NomTra)>-1    ){
                i--;
                continue;
            }

            Nom+=NomTra;

        }
        for(byte i=0;i<2;i++){
            Nom+=VA[nextInt(VA.length)]+" ";
        }
        return Nom.trim();
    }
    public static int nextInt(int numero) {
        return r.nextInt(numero);
    }
    public static int nextInt(int numeroIni, int numeroFin) {
        return r.nextInt(numeroFin-numeroIni+1)+numeroIni;
    }
    public static String EditaComas(long cantidad) {
        // EEJMPLO RECIBE 123456789 DEBE REGRESA 123,456,789
        String texto=cantidad+"";
        char car;
        String edicion="";
        int cont=0;
        for(int i=texto.length()-1 ; i>=0 ; i--) {
            cont++;
            car=texto.charAt(i);
            if(cont ==4 ) {
                edicion=car+","+edicion;
                cont=1;
            }
            else
                edicion=car+edicion;
        }
        return edicion;
    }
    public static void mensajeToast(String mensaje, Context contexto ){

        Toast msg = Toast.makeText(contexto, mensaje,Toast.LENGTH_LONG);
        msg.show();
    }
    public static void mensajeDialog(String mensaje, Context contexto){
        AlertDialog alertDialog = new AlertDialog.Builder(contexto).create();
        alertDialog.setTitle(" Mensaje ");
        alertDialog.setMessage(mensaje);alertDialog.show();
    }
}

