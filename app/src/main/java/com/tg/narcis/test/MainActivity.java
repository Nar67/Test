package com.tg.narcis.test;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivty";
    Button buttonOne, buttonTwo, buttonThree;
    TextView texto;
    Toolbar toolbar;
    private int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonOne = (Button) findViewById(R.id.button1);
        buttonTwo = (Button) findViewById(R.id.button2);
        buttonThree = (Button) findViewById(R.id.button3);
        texto = (TextView) findViewById(R.id.text);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("TULVAR");
        setSupportActionBar(toolbar);

        final Context context = this;
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Bandera.class);
                startActivity(i);
                Log.v(TAG, "Soy el boton 1");
                texto.setText("Pulsado el boton 1");
            }
        });
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
    }



    private void setText(String tex) {
        texto.setText(tex);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Log.v(TAG, "Soy el boton 1 en this");
                setText("Pulsado el boton 1");
                break;
            case R.id.button2:
                Intent i = new Intent(this, Calculator.class);
                startActivity(i);
                Log.v(TAG, "Soy el boton 2");
                setText("Pulsado el boton 2");
                break;
            case R.id.button3:
                i = new Intent(this, MediaPlayerActivity.class);
                startActivity(i);
                Log.v(TAG, "Soy el boton 3");
                setText("Pulsado el boton 3");
                break;

        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.v(TAG, "restore");
        result = savedInstanceState.getInt("result");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v(TAG, "save");
        outState.putInt("result", result); //result proviene del codigo del edit text que no tengo
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_test,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent inte = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"));
        startActivity(inte);
        Log.v(TAG,"Pulsado menu");
        return true;
    }

    public void meHanHechoClick(View v){
        setText("Pulsado el boton 4");
        Log.v(TAG, "Pulsado el boton 4");
    }
}
