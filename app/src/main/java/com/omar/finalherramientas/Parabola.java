package com.omar.finalherramientas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cristian.mytoolbox.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Parabola extends AppCompatActivity implements View.OnClickListener {


    EditText A , B, C;
    LineGraphSeries<DataPoint> series;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parabola);

        Button Cal = (Button)findViewById(R.id.Calcu);
        Cal.setOnClickListener(this);

        Button Grafic = (Button)findViewById(R.id.Graficar);
        Grafic.setOnClickListener(this);;

        //Los Edits por el usuario
        A = (EditText) findViewById(R.id.A);
        B = (EditText) findViewById(R.id.B);
        C = (EditText) findViewById(R.id.C);



    }

    public void onClick(View view) {
        int select = view.getId();
        try {
            switch (select) {

                case R.id.Graficar:

                    double x, y;
                    double a = Double.parseDouble(A.getText().toString());
                    double b = Double.parseDouble(B.getText().toString());
                    double c = Double.parseDouble(C.getText().toString());




                    GraphView graph = (GraphView) findViewById(R.id.Graph);
                    series = new LineGraphSeries<DataPoint>();
                    for (int i = -1000; i<1000; i++ ) {

                        x = i;
                        y = a*Math.pow(x,2) + b*x + c;
                        series.appendData(new DataPoint(x, y), true, 2001);
                    }

                    graph.addSeries(series);

                    break;

                case R.id.Calcu:
                    Intent v1 = new Intent(this, MainActivity.class);
                    startActivity(v1);
                    break;
            }

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();

        }
    }

}
