package com.example.orderpizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {
    Button volv;
    TextView name;
    TextView finaltotal;
    TextView tamno;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        name=findViewById(R.id.nombre);
        volv=(Button) findViewById(R.id.btnvolver);
        finaltotal=(TextView)findViewById(R.id.txtdatos);
        tamno=(TextView)findViewById(R.id.txttaman);

        Bundle recibir=this.getIntent().getExtras();
        String datosrecibidos =recibir.getString("eNombre");
        Double dat=recibir.getDouble("eTotal");
        String dat2=recibir.getString("sizes");

        name.setText(datosrecibidos);
        finaltotal.setText("Total a pagar: $"+" "+dat);
        tamno.setText("Tamaño seleccionado: "+" "+dat2);


        volv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paso1=new Intent(Pantalla2.this, MainActivity.class);
                startActivity(paso1);
            }
        });


    }
}