package com.tg.narcis.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivty";
    Button buttonOne, buttonTwo, buttonThree;
    TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonOne = (Button) findViewById(R.id.button1);
        buttonTwo = (Button) findViewById(R.id.button2);
        buttonThree = (Button) findViewById(R.id.button3);
        texto = (TextView) findViewById(R.id.text);



        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                Log.v(TAG, "Soy el boton 2");
                setText("Pulsado el boton 2");
                break;
            case R.id.button3:
                Log.v(TAG, "Soy el boton 3");
                setText("Pulsado el boton 3");
                break;

        }
    }

    public void meHanHechoClick(View v){
        setText("Pulsado el boton 4");
        Log.v(TAG, "Pulsado el boton 4");
    }
}
