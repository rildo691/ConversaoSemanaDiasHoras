package com.example.conversaosemanadiashoras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et_horas;
    Button btn_calcular;
    TextView txt_inicial;
    TextView txt_resultadoSemanas;
    TextView txt_resultadoDias;
    TextView txt_resultadoHoras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_horas = (EditText) findViewById(R.id.et_horas);
        btn_calcular = (Button) findViewById(R.id.btn_calcular);
        txt_resultadoSemanas = (TextView) findViewById(R.id.textView4);
        txt_resultadoDias = (TextView) findViewById(R.id.textView5);
        txt_resultadoHoras = (TextView) findViewById(R.id.textView6);
        txt_inicial = (TextView) findViewById(R.id.textView7);

        btn_calcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int numeroHoras = Integer.parseInt(et_horas.getText().toString());
                int valorSemanas = 0, valorDias = 0, valorHoras = 0, operacao = numeroHoras;

                while (numeroHoras > 0){
                    if (numeroHoras >= 168){
                        numeroHoras -= 168;
                        valorSemanas++;
                    } else if (numeroHoras >= 24){
                        numeroHoras -= 24;
                        valorDias++;
                    } else {
                        valorHoras = numeroHoras;
                        numeroHoras -= valorHoras;
                    }
                }

                txt_inicial.setText(operacao + " " + "horas são ");
                txt_resultadoSemanas.setText(Integer.toString(valorSemanas));
                txt_resultadoDias.setText(Integer.toString(valorDias));
                txt_resultadoHoras.setText(Integer.toString(valorHoras));
                et_horas.setText("");

            }
        });
    }
}