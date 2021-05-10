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
    TextView txt_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_horas = (EditText) findViewById(R.id.et_horas);
        btn_calcular = (Button) findViewById(R.id.btn_calcular);
        txt_resultado = (TextView) findViewById(R.id.textView);

        btn_calcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int numeroHoras = Integer.parseInt(et_horas.getText().toString());
                int valorSemanas = 0, valorDias = 0, valorHoras = 0, operacao = numeroHoras;
                String saida = "";

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

                saida = operacao + " " + "horas são ";

                if (valorSemanas > 1 || valorSemanas == 0){
                    saida += valorSemanas + " " + "semanas, ";
                } else {
                    saida += valorSemanas + " " + "semana, ";
                }

                if (valorDias > 1 || valorDias == 0){
                    saida += valorDias + " " + "dias, ";
                } else {
                    saida += valorDias + " " + "dia, ";
                }

                if (valorHoras > 1 || valorHoras == 0){
                    saida += valorHoras + " " + "horas.";
                } else {
                    saida += valorHoras + " " + "hora.";
                }

                txt_resultado.setText(saida);
                et_horas.setText("");
            }
        });
    }
}