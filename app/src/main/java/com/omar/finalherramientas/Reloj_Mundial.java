package com.omar.finalherramientas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.cristian.mytoolbox.R;

import java.text.DateFormat;
import java.util.Calendar;

public class Reloj_Mundial extends AppCompatActivity {

    TextView txt, txt2, txt3, txt4, txt5, txt6;

    DateFormat dateFormatTL = DateFormat.getDateTimeInstance();
    DateFormat dateFormatTB = DateFormat.getDateTimeInstance();
    DateFormat dateFormatTM = DateFormat.getDateTimeInstance();
    DateFormat dateFormatTT = DateFormat.getDateTimeInstance();
    DateFormat dateFormatTMo = DateFormat.getDateTimeInstance();
    DateFormat dateFormatTLA = DateFormat.getDateTimeInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reloj__mundial);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txt = (TextView) findViewById(R.id.hora1);
        txt2 = (TextView) findViewById(R.id.hora2);
        txt3 = (TextView) findViewById(R.id.hora3);
        txt4 = (TextView) findViewById(R.id.hora4);
        txt5 = (TextView) findViewById(R.id.hora5);
        txt6 = (TextView) findViewById(R.id.hora6);



        verhoramundial();


    }

    private void verhoramundial() {

        Calendar BA = Calendar.getInstance();
        BA.add(Calendar.HOUR,2);

        Calendar LA = Calendar.getInstance();
        LA.add(Calendar.HOUR,-2);

        Calendar LON = Calendar.getInstance();
        LON.add(Calendar.HOUR,5);

        Calendar MAL = Calendar.getInstance();
        MAL.add(Calendar.HOUR,10);
        System.out.println(MAL.getTime());

        Calendar MOS = Calendar.getInstance();
        MOS.add(Calendar.HOUR,9);

        Calendar TO = Calendar.getInstance();
        TO.add(Calendar.HOUR,14);



        txt.setText(" Buenos Aires " + "\n " + dateFormatTB.format(BA.getTime()));
        txt2.setText(" Los Angeles " + "\n " + dateFormatTLA.format(LA.getTime()));
        txt3.setText(" Londres " + "\n "   + dateFormatTL.format(LON.getTime()));
        txt4.setText(" Maldivas " + "\n " + dateFormatTM.format(MAL.getTime()));
        txt5.setText(" Moscu " + "\n " + dateFormatTMo.format(MOS.getTime()));
        txt6.setText(" Tokio " + "\n " + dateFormatTT.format(TO.getTime()));
    }

}
