package com.example.cristian.mytoolbox;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cristian.mytoolbox.Base_De_Datos.Conexion;

public class DetallaNotas extends AppCompatActivity {
    Bundle parametros;
    String datorecibido;
    Cursor cursor;
    SQLiteDatabase db;
    TextView [] informacion;
    String []campos ;
    String [] parametro;
    Conexion con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalla_notas);




     try {


         con = new Conexion(getApplicationContext(), "db_nota", null, 1);
         db = con.getWritableDatabase();
         informacion = new TextView[4];

         informacion[0] = findViewById(R.id.txttitulo);
         informacion[1] = findViewById(R.id.txtcotenido);

         parametros = this.getIntent().getExtras();
         datorecibido = parametros.getString("dato");



         Toast.makeText(this, ""+datorecibido, Toast.LENGTH_SHORT).show();
         parametro = new String[]{datorecibido};
         campos = new String[]{"titulo", "contenido"};
         cursor = db.query("nota", campos, "idnota=?",parametro, null, null, null);
         cursor.moveToFirst();



         informacion[0].setText(cursor.getString(0));
         informacion[1].setText(cursor.getString(1));
     }catch (SQLException e){
        informacion[0].setText(""+e);
     }





    }
}
