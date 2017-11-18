package com.omar.finalherramientas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cristian.mytoolbox.R;

public class Conversor_unidades extends AppCompatActivity implements View.OnClickListener {

    Button btnNum0, btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7, btnNum8, btnNum9, limpiar, punto;
    ImageButton litro1, litro2, galon1, galon2, km1, km2, mll1, mll2;
    boolean decimal = false;
    int Conver = 0, Result = 0;
    double operacion = 0;
    Double[] number = new Double[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor_unidades);

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


        litro1 = (ImageButton) findViewById(R.id.imageButton_litro1);
        litro1.setOnClickListener(this);

        litro2 = (ImageButton) findViewById(R.id.imageButton_litro2);
        litro2.setOnClickListener(this);

        galon1 = (ImageButton) findViewById(R.id.imageButton_galon1);
        galon1.setOnClickListener(this);

        galon2 = (ImageButton) findViewById(R.id.imageButton_galon2);
        galon2.setOnClickListener(this);

        km1 = (ImageButton) findViewById(R.id.imageButton_kilo1);
        km1.setOnClickListener(this);

        km2 = (ImageButton) findViewById(R.id.imageButton_kilo2);
        km2.setOnClickListener(this);

        mll1 = (ImageButton) findViewById(R.id.imageButton_milla1);
        mll1.setOnClickListener(this);

        mll2 = (ImageButton) findViewById(R.id.imageButton_milla2);
        mll2.setOnClickListener(this);


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

                case R.id.imageButton_litro1:
                    Toast.makeText(this, "Litro(s)", Toast.LENGTH_SHORT).show();
                    litro2.setEnabled(false);
                    galon2.setEnabled(true);
                    km2.setEnabled(false);
                    mll2.setEnabled(false);
                    Conver = 1;
                    break;

                case R.id.imageButton_litro2:
                    number[0] = Double.parseDouble(SaveNum);
                    Toast.makeText(this, "Convertir a litro(s)", Toast.LENGTH_SHORT).show();
                    Result = 7;
                    break;

                case R.id.imageButton_galon1:
                    Toast.makeText(this, "Galon(es)", Toast.LENGTH_SHORT).show();
                    litro2.setEnabled(true);
                    galon2.setEnabled(false);
                    km2.setEnabled(false);
                    mll2.setEnabled(false);
                    Conver = 2;
                    break;

                case R.id.imageButton_galon2:
                    number[0] = Double.parseDouble(SaveNum);
                    Toast.makeText(this, "Convertir a Galones", Toast.LENGTH_SHORT).show();
                    Result = 8;
                    break;

                case R.id.imageButton_kilo1:
                    Toast.makeText(this, "Kilometro(s)", Toast.LENGTH_SHORT).show();
                    Conver = 3;
                    litro2.setEnabled(false);
                    galon2.setEnabled(false);
                    km2.setEnabled(false);
                    mll2.setEnabled(true);
                    break;

                case R.id.imageButton_kilo2:
                    number[0] = Double.parseDouble(SaveNum);
                    Toast.makeText(this, "Convertir a Kilometro(s)", Toast.LENGTH_SHORT).show();
                    Result = 5;
                    break;

                case R.id.imageButton_milla1:
                    number[0] = Double.parseDouble(SaveNum);
                    Toast.makeText(this, "Milla(s)", Toast.LENGTH_SHORT).show();
                    litro2.setEnabled(false);
                    galon2.setEnabled(false);
                    km2.setEnabled(true);
                    mll2.setEnabled(false);
                    Conver = 4;
                    break;

                case R.id.imageButton_milla2:
                    number[0] = Double.parseDouble(SaveNum);
                    Toast.makeText(this, "Convertir a Milla(s)", Toast.LENGTH_SHORT).show();
                    Result = 6;
                    break;

            }
        } catch (Exception e) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }


        //Litros a Galones
        if (Conver == 1) {
            if (Result == 8) {
                operacion = number[0] * 0.264;
                result.setText(String.valueOf(operacion));

            }
        }

        //Galones a litros
        if (Conver == 2) {
            if (Result == 7) {
                operacion = number[0] * 3.785;
                result.setText(String.valueOf(operacion));
            }

        }
        //Km a Mll
        if (Conver == 3) {
            if (Result == 6) {
                operacion = number[0] * 0.621371;
                result.setText(String.valueOf(operacion));
            }
        }

        //Mll a Km
        if (Conver == 4) {
            if (Result == 5) {
                operacion = number[0] * 1.60934;
                result.setText(String.valueOf(operacion));
            }

        }
    }
}

