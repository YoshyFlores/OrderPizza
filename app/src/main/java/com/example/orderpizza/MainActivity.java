package com.example.orderpizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Ordes ordes;
    TextView total;
    double precio_final;
    Button continuar;
    EditText nombreC;
    RadioButton size, size1, size2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ordes=new Ordes();
        total=findViewById(R.id.total);
        continuar=(Button) findViewById(R.id.btnPrecio);
        nombreC=(EditText)findViewById(R.id.nom);
        size=(RadioButton)findViewById(R.id.rdPequena);
        size1=(RadioButton)findViewById(R.id.rdMediana);
        size2=(RadioButton)findViewById(R.id.rdGrande);


        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto=nombreC.getText().toString();
                Bundle parame=new Bundle();
                parame.putString("eNombre",texto);

                Intent paso=new Intent(MainActivity.this,Pantalla2.class);
                paso.putExtras(parame);
                paso.putExtra("eTotal",calcular());
                if(size.isChecked()){paso.putExtra("sizes", size.getText().toString());}
                if(size1.isChecked()){paso.putExtra("sizes",size1.getText().toString());}
                if(size2.isChecked()){paso.putExtra("sizes",size2.getText().toString());}
                startActivity(paso);

            }
        });

    }

    public void radioClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {

            case R.id.rdPequena:
                if (checked)
                    ordes.setPizza_precio(5);
                break;
            case R.id.rdMediana:
                if(checked)
                    ordes.setPizza_precio(10);
                break;
            case R.id.rdGrande:
                if(checked)
                    ordes.setPizza_precio(15);
                break;

        }
        total.setText("Total Price:" + ordes.getPizza_precio());

    }

    public void onCheckboxClicked(View view) {
        boolean checked=((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.chPepperoni:
                if (checked)
                    ordes.setPepperoni_price(2);
                else
                    ordes.setPepperoni_price(0);
                break;

            case R.id.chJamon:
                if (checked)
                    ordes.setJamon_price(2);
                else
                    ordes.setJamon_price(0);
                break;

            case R.id.chCarne:
                if (checked)
                    ordes.setCarne_price(3);
                else
                    ordes.setCarne_price(0);
                break;

            case R.id.chBacon:
                if (checked)
                    ordes.setBacon_price(3);
                else
                    ordes.setBacon_price(0);
                break;

            case R.id.chLoroco:
                if (checked)
                    ordes.setLoroco_price(1);
                else
                    ordes.setLoroco_price(0);
                break;

            case R.id.chPina:
                if (checked)
                    ordes.setPina_price(1);
                else
                    ordes.setPina_price(0);
                break;

            case R.id.chPimientos:
                if (checked)
                    ordes.setPimientos_price(1);
                else
                    ordes.setPimientos_price(0);
                break;
        }
        total.setText("Total Price:"+calcular());
        }
        private double calcular()
        {
            precio_final=(ordes.getPizza_precio()+ordes.getPepperoni_price()+ordes.getJamon_price()+ordes.getCarne_price()+ordes.getBacon_price()+ordes.getLoroco_price()+ordes.getPina_price()+ordes.getPimientos_price());
            return precio_final;

        }
    }
