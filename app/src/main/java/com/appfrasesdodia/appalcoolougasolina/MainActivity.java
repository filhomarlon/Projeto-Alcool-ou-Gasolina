package com.appfrasesdodia.appalcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool     = findViewById(R.id.texteditAlcool);
        editPrecoGasolina   = findViewById(R.id.texteditGasolina);
        textResultado       = findViewById(R.id.textResultado);

    }

    public void calcularPreco(View view){

        //recuperando os valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //validar campos
        Boolean camposValidados =  validarCampos(precoAlcool,precoGasolina);
        if(camposValidados){

        //convertendo string para numeros
        Double valorAlcool = Double.parseDouble(precoAlcool);
        Double valorGasolina = Double.parseDouble(precoGasolina);

        //calculando
        Double resultado = valorAlcool / valorGasolina;
        if( resultado >= 0.7){
            textResultado.setText("Melhor usar gasolina");
        }else {
            textResultado.setText("Melhor usar Álcool");
        }

        }else{
            textResultado.setText("Preencha os preços primeiro.");
        }

    }

    public boolean validarCampos(String pAlcool, String pGasolina){

    Boolean camposValidados = true;

    if(pAlcool == null || pAlcool.equals("")){
        camposValidados = false;
    }else if(pGasolina == null || pGasolina.equals("")){
        camposValidados = false;
    }

    return  camposValidados;
    }



}
