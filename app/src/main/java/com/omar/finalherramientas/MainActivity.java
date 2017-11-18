package com.omar.finalherramientas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.view.View.OnClickListener;

import com.example.cristian.mytoolbox.R;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    ImageButton contacto, calendario, moneda, unidades, traductor, calculadora, paint, reloj, notas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contacto = (ImageButton)findViewById(R.id.imageButton2);
        contacto.setOnClickListener(this);
        calendario = (ImageButton)findViewById(R.id.imageButton);
        calendario.setOnClickListener(this);
        moneda = (ImageButton)findViewById(R.id.imageButton3);
        moneda.setOnClickListener(this);
        unidades = (ImageButton)findViewById(R.id.imageButton4);
        unidades.setOnClickListener(this);
        traductor = (ImageButton)findViewById(R.id.imageButton5);
        traductor.setOnClickListener(this);
        calculadora = (ImageButton)findViewById(R.id.imageButton6);
        calculadora.setOnClickListener(this);
        paint = (ImageButton)findViewById(R.id.imageButton7);
        paint.setOnClickListener(this);
        reloj = (ImageButton)findViewById(R.id.imageButton8);
        reloj.setOnClickListener(this);
        notas = (ImageButton)findViewById(R.id.imageButton9);
        notas.setOnClickListener(this);


    }

    //Evento para seleccionar nuestra aplicación para abrir
    @Override
    public void onClick(View view){
    int select = view.getId();
        Context context = getApplicationContext();
        CharSequence text = null;
        int duracion = Toast.LENGTH_SHORT;

        try {
        switch (select) {

            case R.id.imageButton:
                Intent v2 = new Intent(this,Calendario.class);
                text="Calendario";
                startActivity(v2);
                break;
            case R.id.imageButton2:
                Intent v1 = new Intent(this,Contacto.class);
                text="Contactos";
                startActivity(v1);
                break;
            case R.id.imageButton3:
                Intent v3 = new Intent(this,Conversor_moneda.class);
                text="Conversor de moneda";
                startActivity(v3);
                break;
            case R.id.imageButton4:
                Intent v4 = new Intent(this,Conversor_unidades.class);
                text="Conversor de unidades";
                startActivity(v4);
                break;
            case R.id.imageButton5:
                Intent v5 = new Intent(this,Traductor.class);
                text="Traductor";
                startActivity(v5);
                break;
            case R.id.imageButton6:
                Intent v6 = new Intent(this,Calculadora.class);
                text="Calculadora";
                startActivity(v6);
                break;
            case R.id.imageButton7:
                Intent v7 = new Intent(this,Dibujo.class);
                text="Paint";
                startActivity(v7);
                break;
            case R.id.imageButton8:
                Intent v8 = new Intent(this,Reloj.class);
                text="Reloj";
                startActivity(v8);
                break;
            case R.id.imageButton9:
                Intent v9 = new Intent(this,Notas.class);
                text="Notas";
                startActivity(v9);
                break;

        }

        } catch  (Exception e) {
            Toast.makeText(this, "Error al abrir esta aplicación", Toast.LENGTH_SHORT).show();;}

        Toast toast = Toast.makeText(context,text,duracion);
        toast.show();

    }
}
