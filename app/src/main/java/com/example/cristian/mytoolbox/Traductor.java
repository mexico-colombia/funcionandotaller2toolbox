package com.example.cristian.mytoolbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class Traductor extends AppCompatActivity implements View.OnClickListener {

    Button espanol, ingles;
    int Cont = 0, cont2 = 0;
    String SaveWord;
    EditText palabra;
    WebView Wview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traductor);

        palabra = findViewById(R.id.ETpalabra);
        Wview = findViewById(R.id.web);
        ingles =  findViewById(R.id.btn_ItoE);
        ingles.setOnClickListener(this);
        espanol =  findViewById(R.id.btn_EtoI);
        espanol.setOnClickListener(this);

        Wview.getSettings().setJavaScriptEnabled(true);
        Wview.setWebViewClient(new WebViewClient());
        Wview.setWebChromeClient(new WebChromeClient());




    }

    @Override
    public void onClick(View view) {

        String url="";
        switch (view.getId()){
            case R.id.btn_ItoE:
                url="https://translate.google.com/?hl=es#en/es/"+palabra.getText();
                Wview.loadUrl(url);
                break;
            case R.id.btn_EtoI:
                url="https://translate.google.com/?hl=es#es/en/"+palabra.getText();
                Wview.loadUrl(url);
                break;
        }


/*
        EditText etpalabra = (EditText) findViewById(R.id.ETpalabra);
        SaveWord = etpalabra.getText().toString();
        etpalabra.setText("");
        TextView txtpalabra = (TextView) findViewById(R.id.txtresult);
        String x = "hola";
        int select = view.getId();

        try {
            switch (select) {

                case R.id.btn_EtoI:


                     if (x.toString() != SaveWord.toString())
                     {
                         txtpalabra.setText("Funciona");
                     }


                    break;

                case R.id.btn_ItoE:

                    if (SaveWord == "hello"){ txtpalabra.setText("Hola");}

                    break;

            }
        } catch (Exception e) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }*/
    }
}

