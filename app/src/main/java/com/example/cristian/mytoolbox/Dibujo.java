package com.example.cristian.mytoolbox;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class Dibujo extends AppCompatActivity {
    Fragment fragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dibujo);
     //   paintView = (PaintView) findViewById(R.id.PaintView);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
     //   paintView.init(metrics);

        fragment = new FragmentPaint();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,fragment).commit();



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.normal :
            //    paintView.normal();
                return true;
            case R.id.emboss :
            //    paintView.emboss();
                return true;
            case R.id.blur :
            //    paintView.blur();
                return true;
            case R.id.clear :
             //   paintView.clear();
                return true;
        }

        return  super.onOptionsItemSelected(item);
    }


}
