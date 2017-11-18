package com.omar.finalherramientas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cristian.mytoolbox.R;

import java.text.DateFormat;
import java.util.Calendar;

public class BarraDeAccion extends AppCompatActivity {

    TextView txt;
    DateFormat dateFormat = DateFormat.getDateInstance();
    Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barra_de_accion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txt = (TextView) findViewById(R.id.fecha);

        verfecha();


    }


    private void verfecha() {
        txt.setText( dateFormat.format(calendar.getTime()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_barra_de_accion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        Context context = getApplicationContext();
        CharSequence text = null;
        int duracion = Toast.LENGTH_SHORT;



        //noinspection SimplifiableIfStatement
        if (id == R.id.Alarma) {
            text="Alarma";
            Intent Ala = new Intent(this,Alarma_Inicio.class);
            startActivity(Ala);

            //return true;
        }
        if (id == R.id.Reloj_Mundial) {
            text="Reloj Mundial";

            Intent Mun = new Intent(this,Reloj_Mundial.class);
            startActivity(Mun);
            //return true;
        }
        if (id == R.id.Cronometro) {
            text="Cronometro";

            Intent Cro = new Intent(this,Cronometro.class);
            startActivity(Cro);
            //return true;
        }
        if (id == R.id.Temporizador) {
            text="Temporizador";

            Intent Tem = new Intent(this,Temporizador.class);
            startActivity(Tem);
            //return true;
        }

        Toast toast = Toast.makeText(context,text,duracion);
        toast.show();

        return super.onOptionsItemSelected(item);
    }
}
