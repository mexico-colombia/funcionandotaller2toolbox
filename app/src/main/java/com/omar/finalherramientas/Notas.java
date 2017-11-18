package com.omar.finalherramientas;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.omar.finalherramientas.Base_De_Datos.Conexion;
import com.example.cristian.mytoolbox.R;

import java.util.ArrayList;

public class Notas extends AppCompatActivity implements View.OnClickListener {

    Button button;
    ListView lista;
    Cursor registros;
    Conexion con;
    SQLiteDatabase db;
    ArrayAdapter adaptador;
    ArrayList<String> listas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);


       button  = findViewById(R.id.btnnotas);
       button.setOnClickListener(this);


        lista =  findViewById(R.id.lista);
        con = new Conexion(getApplicationContext(), "db_nota", null, 1);
        db = con.getWritableDatabase();


        ArrayList<String> listas = new ArrayList<>();
        String consulta ="select titulo  from  nota";

       registros = db.rawQuery(consulta, null);

        if (registros.moveToFirst()) {
            do {
                listas.add(registros.getString(0));
            } while (registros.moveToNext());
        }


        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listas);
        lista.setAdapter(adaptador);
        db.close();

        int tamanodeadaptador = lista.getCount();

        if (tamanodeadaptador==0){
            Toast.makeText(this, "No Hay Notas", Toast.LENGTH_SHORT).show();

        }


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(getApplicationContext(),DetallaNotas.class);

                intent.putExtra("dato",String.valueOf(position+1));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {


        Intent v2 = new Intent(this, Nota.class);
        startActivity(v2);

    }
}
