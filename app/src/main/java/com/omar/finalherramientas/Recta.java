package com.omar.finalherramientas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cristian.mytoolbox.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
public class Recta extends AppCompatActivity implements View.OnClickListener {

    LineGraphSeries<DataPoint> series;
    EditText M , B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recta);
        Button Calc = (Button) findViewById(R.id.Calculadora);
        Calc.setOnClickListener(this);
        Button Graf = (Button)findViewById(R.id.Graficar);
        Graf.setOnClickListener(this);

        //Los Edits por el usuario
        M = (EditText) findViewById(R.id.M);
        B = (EditText) findViewById(R.id.B);


    }

    public void onClick(View view) {
        int select = view.getId();
        try {
            switch (select) {

                case R.id.Graficar:
                    double x, y;
                    double m = Double.parseDouble(M.getText().toString());
                    double b = Double.parseDouble(B.getText().toString());

                    GraphView graph = (GraphView) findViewById(R.id.Graph_2);
                    series = new LineGraphSeries<DataPoint>();

                    for (int i = -4; i<4; i++ ) {
                        x = i;
                        y = m * x + b;
                        series.appendData(new DataPoint(x, y), true, 9);
                    }
                    graph.addSeries(series);

                    break;

                case R.id.Calculadora:
                    Intent v1 = new Intent(this, MainActivity.class);
                    startActivity(v1);
                    break;
            }

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();

        }
    }
}





