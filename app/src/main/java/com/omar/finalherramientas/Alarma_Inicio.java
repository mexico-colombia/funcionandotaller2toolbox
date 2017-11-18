package com.omar.finalherramientas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cristian.mytoolbox.R;

public class Alarma_Inicio extends AppCompatActivity {

    public static final int NOTIFICACION_ID=1;
    Button btn_add;
    TextView txt1, txt2, txt3, txt4, txt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarma__inicio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btn_add = (Button) findViewById(R.id.add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Alarma_Inicio.this, Alarma.class);
                startActivity(i);


            }

        });

    }

}
