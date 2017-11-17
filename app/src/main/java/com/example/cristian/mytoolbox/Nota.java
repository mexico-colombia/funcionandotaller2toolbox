package com.example.cristian.mytoolbox;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.cristian.mytoolbox.Base_De_Datos.Conexion;

public class Nota extends AppCompatActivity implements View.OnClickListener {

    EditText EdT, EdC;
    Button Save, Cancel;
    String Cargar;
    TextView txt;


    private SQLiteDatabase db;
    private EditText titulo,contenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);
        titulo = findViewById(R.id.txttitulo);
        contenido = findViewById(R.id.txtcotenido);
        Save =  findViewById(R.id.Save);
        Save.setOnClickListener(this);
        Cancel = findViewById(R.id.Cance);
        Cancel.setOnClickListener(this);
   /*     admin = new AdminSQLiteOpenHelper(this, vars.bd, null, vars.version);
        bd = admin.getWritableDatabase();

        try {
            if (bd != null) {
                fila = bd.rawQuery("SELECT * FROM alarma", null);
                if (fila.moveToFirst()) {
                    do {
                        String alarma = fila.getString(0);
                        String tituloss = fila.getString(1);
                        String descripcionss = fila.getString(2);
                        String fechahora = fila.getString(3) + " " + fila.getString(4);
                        Cargar = "Item " + alarma + ", " + tituloss + ", " + descripcionss + ", " + fechahora + "\n";
                        txt.append(Cargar);
                    } while (fila.moveToNext());
                }

            }
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Error base de datos. " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        bd.close();

        EdT = (EditText) findViewById(R.id.EditTi);
        EdC = (EditText) findViewById(R.id.EdiCont);
        Save = (Button) findViewById(R.id.Save);
        Save.setOnClickListener(this);
        Cancel = (Button) findViewById(R.id.Cance);
        Cancel.setOnClickListener(this);
    }

    public void OnToggleClicked(View view) {

        if (((ToggleButton) view).isChecked()) {

            Intent v1 = new Intent(this,Alarma.class);
            startActivity(v1);

            Toast.makeText(Nota.this, "Programando alerta", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(Nota.this, "Alerta no programada", Toast.LENGTH_SHORT).show();

        }*/
    }

    @Override
    public void onClick(View view) {
        Intent v1 = new Intent(this, MainActivity.class);

        int select = view.getId();
        try {
            switch (select) {

                case R.id.Save:
                    /*

                    registro = new ContentValues();
                    registro.put("encabezado", EdT.getText().toString());
                    registro.put("mensaje", EdC.getText().toString());
                    bd.insert("alarma", null, registro);//nombre de la tabla
                    bd.close();



                    Toast.makeText(Nota.this, "Nota Guardada", Toast.LENGTH_SHORT).show();
                    startActivity(v1);*/


                    try {
                        Conexion conexion = new Conexion(getApplicationContext(),"db_nota",null,1);
                        conexion.getWritableDatabase();

                        db = conexion.getWritableDatabase();
                        db.execSQL("INSERT INTO nota (titulo,contenido) VALUES ('"+titulo.getText().toString().trim()+"','"+contenido.getText().toString().trim()+"')" );
                        titulo.setText(null);
                        contenido.setText(null);

                        Toast.makeText(this, "Nota agreagada correctamente ", Toast.LENGTH_SHORT).show();

                    }catch (Exception e){
                        Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
                    }
                    break;

                case R.id.Cance:
                    Intent main = new Intent(getApplicationContext(),Notas.class);
                    Toast.makeText(Nota.this, "Nota Cancelada", Toast.LENGTH_SHORT).show();
                    startActivity(main);
                    break;

            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
        }

    }
}
