package com.example.conversormoneda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    float valor;
    private final float DOLAR= 44.70f;
    private final float EURO= 48.70f;
    private final float REAL= 16.23f;

    EditText editValor;

    private Button btnConvertir;
    private Button btnReset;

    private RadioGroup radioGroup;
    private RadioButton radioEuro;
    private RadioButton radioDolar;
    private RadioButton radioReal;

    private TextView textResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConvertir= findViewById(R.id.btnConvertir);
        btnReset= findViewById(R.id.btnReset);
        radioGroup=findViewById(R.id.radioGroup);
        radioEuro=findViewById(R.id.radioEuro);
        radioDolar=findViewById(R.id.radioDolar);
        radioReal=findViewById(R.id.radioReal);
        textResultado=findViewById(R.id.textResultado);
        editValor=findViewById(R.id.editValor);

        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Convertir();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reset();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radioDolar:
                        Toast.makeText(MainActivity.this, "Selecciono Dolar", Toast.LENGTH_SHORT);
                        break;
                    case R.id.radioEuro:
                        Toast.makeText(MainActivity.this, "Selecciono Euro", Toast.LENGTH_SHORT);
                        break;
                    case R.id.radioReal:
                        Toast.makeText(MainActivity.this, "Selecciono Real", Toast.LENGTH_SHORT);
                        break;
                }
            }
        });

    }

    private void Convertir() {
        if (editValor.getText().toString().isEmpty()) {
            Toast.makeText(this, "Esto esta vacío", Toast.LENGTH_SHORT).show();
        } else {
            DecimalFormat format= new DecimalFormat("#.##");
            float resultado = 0f;
            valor = Float.parseFloat(String.valueOf(editValor.getText()));

            if (radioDolar.isChecked()) {
                resultado = valor / DOLAR;
            }
            if (radioEuro.isChecked()) {
                resultado = valor / EURO;
            }
            if (radioReal.isChecked()) {
                resultado = valor / REAL;
            }
            textResultado.setText((String.valueOf(format.format(resultado))));
        }
    }

    private void Reset(){
        textResultado.setText(null);
        editValor.setText(null);
        radioDolar.setChecked(true);
    }
}
