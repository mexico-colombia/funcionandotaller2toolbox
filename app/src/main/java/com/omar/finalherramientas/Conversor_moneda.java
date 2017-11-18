package com.omar.finalherramientas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.example.cristian.mytoolbox.R;

public class Conversor_moneda extends AppCompatActivity implements OnClickListener {

    Button btnNum0, btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7, btnNum8, btnNum9, limpiar, punto;
    ImageButton Usa1, Usa2, Eur1, Eur2, Col1, Col2;
    boolean decimal = false;
    int  Conver = 0, Result = 0;
    double operacion = 0;
    Double[] number = new Double[20];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor_moneda);

        btnNum0 = (Button) findViewById(R.id.btn_0);
        btnNum0.setOnClickListener(this);

        btnNum1 = (Button) findViewById(R.id.btn_1);
        btnNum1.setOnClickListener(this);

        btnNum2 = (Button) findViewById(R.id.btn_2);
        btnNum2.setOnClickListener(this);

        btnNum3 = (Button) findViewById(R.id.btn_3);
        btnNum3.setOnClickListener(this);

        btnNum4 = (Button) findViewById(R.id.btn_4);
        btnNum4.setOnClickListener(this);

        btnNum5 = (Button) findViewById(R.id.btn_5);
        btnNum5.setOnClickListener(this);

        btnNum6 = (Button) findViewById(R.id.btn_6);
        btnNum6.setOnClickListener(this);

        btnNum7 = (Button) findViewById(R.id.btn_7);
        btnNum7.setOnClickListener(this);

        btnNum8 = (Button) findViewById(R.id.btn_8);
        btnNum8.setOnClickListener(this);

        btnNum9 = (Button) findViewById(R.id.btn_9);
        btnNum9.setOnClickListener(this);

        limpiar = (Button) findViewById(R.id.btn_limpiar);
        limpiar.setOnClickListener(this);

        punto = (Button) findViewById(R.id.btn_punto);
        punto.setOnClickListener(this);


        Usa1 = (ImageButton)findViewById(R.id.imageButton_Usa1);
        Usa1.setOnClickListener(this);

        Usa2 = (ImageButton)findViewById(R.id.imageButton_Usa2);
        Usa2.setOnClickListener(this);

        Eur1 =(ImageButton)findViewById(R.id.imageButton_Eur1);
        Eur1.setOnClickListener(this);

        Eur2 = (ImageButton)findViewById(R.id.imageButton_Eur2);
        Eur2.setOnClickListener(this);

        Col1=(ImageButton)findViewById(R.id.imageButton_Col1);
        Col1.setOnClickListener(this);

        Col2 = (ImageButton)findViewById(R.id.imageButton_Col2);
        Col2.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        TextView screen = (TextView) findViewById(R.id.ttxt_Moneda);
        TextView result = (TextView) findViewById(R.id.Resultado);
        int select = view.getId();
        String SaveNum = screen.getText().toString();

        try {
            switch (select) {

                case R.id.btn_0:
                    screen.setText(SaveNum + "0");
                    break;
                case R.id.btn_1:
                    screen.setText(SaveNum + "1");
                    break;
                case R.id.btn_2:
                    screen.setText(SaveNum + "2");
                    break;
                case R.id.btn_3:
                    screen.setText(SaveNum + "3");
                    break;
                case R.id.btn_4:
                    screen.setText(SaveNum + "4");
                    break;
                case R.id.btn_5:
                    screen.setText(SaveNum + "5");
                    break;
                case R.id.btn_6:
                    screen.setText(SaveNum + "6");
                    break;
                case R.id.btn_7:
                    screen.setText(SaveNum + "7");
                    break;
                case R.id.btn_8:
                    screen.setText(SaveNum + "8");
                    break;
                case R.id.btn_9:
                    screen.setText(SaveNum + "9");
                    break;
                case R.id.btn_punto:
                    if (!decimal) {
                        screen.setText(SaveNum + ".");
                        decimal = true;
                    } else {
                        return;
                    }
                    break;

                case R.id.btn_limpiar:
                    result.setText("");
                    screen.setText("");

                    decimal = false;
                    break;

                case R.id.imageButton_Col1:
                    Toast.makeText(this, "Pesos", Toast.LENGTH_SHORT).show();
                    Col2.setEnabled(false);
                    Eur2.setEnabled(true);
                    Usa2.setEnabled(true);

                    Conver = 1;
                    break;

                case R.id.imageButton_Col2:
                    number[0] = Double.parseDouble(SaveNum);
                    Toast.makeText(this, "Convertir a Pesos", Toast.LENGTH_SHORT).show();
                    Result = 6;
                    break;

                case R.id.imageButton_Eur1:
                    Toast.makeText(this, "Euros", Toast.LENGTH_SHORT).show();
                    Col2.setEnabled(true);
                    Eur2.setEnabled(false);
                    Usa2.setEnabled(true);
                    Conver = 2;
                    break;

                case R.id.imageButton_Eur2:
                    number[0] = Double.parseDouble(SaveNum);
                    Toast.makeText(this, "Convertir a Euros", Toast.LENGTH_SHORT).show();
                    Result = 5;
                    break;

                case R.id.imageButton_Usa1:
                    Toast.makeText(this, "Dolar", Toast.LENGTH_SHORT).show();
                    Conver = 3;
                    Col2.setEnabled(true);
                    Eur2.setEnabled(true);
                    Usa2.setEnabled(false);
                    break;

                case R.id.imageButton_Usa2:
                    number[0] = Double.parseDouble(SaveNum);
                    Toast.makeText(this, "Convertir a Dolar", Toast.LENGTH_SHORT).show();
                    Result = 4;
                    break;

            }
        } catch (Exception e) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }


            //Dolar a pesos
            if (Conver == 3) {
                if (Result == 6) {
                    operacion = number[0] * 3012.05;
                    result.setText(String.valueOf(operacion));
                }
                //Dolar a Euros
                if (Result == 5) {
                    operacion = number[0] * 0.857;
                    result.setText(String.valueOf(operacion));
                }
            }

            //Euro a Pesos
            if (Conver == 2){
                if (Result == 6){
                    operacion = number[0] * 3513.40;
                    result.setText(String.valueOf(operacion));
                }
                //Euro a Dolar
                if (Result == 4) {
                    operacion = number[0] * 1.16;
                    result.setText(String.valueOf(operacion));
                }
            }
            //Peso a Euro
            if (Conver == 1){
                if (Result == 5){
                    operacion = number[0] * 0.00028;
                    result.setText(String.valueOf(operacion));
                }
                //Peso a Dolar
                if (Result == 4) {
                    operacion = number[0] * 0.000332;
                    result.setText(String.valueOf(operacion));

                }
            }
    }

}
