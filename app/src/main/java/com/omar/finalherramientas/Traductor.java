package com.omar.finalherramientas;

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

import com.example.cristian.mytoolbox.R;

public class Traductor extends AppCompatActivity implements View.OnClickListener {

    Button espanol, ingles;

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

    }
}

