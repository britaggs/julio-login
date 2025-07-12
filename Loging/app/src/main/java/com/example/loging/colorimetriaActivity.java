package com.example.loging;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class colorimetriaActivity extends AppCompatActivity {

    EditText inputSkin, inputHair, inputEyes, inputBrows;
    Button btnCheck;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colorimetria);

        inputSkin = findViewById(R.id.inputSkin);
        inputHair = findViewById(R.id.inputHair);
        inputEyes = findViewById(R.id.inputEyes);
        inputBrows = findViewById(R.id.inputBrows);
        btnCheck = findViewById(R.id.btnCheck);
        resultText = findViewById(R.id.resultText);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String piel = inputSkin.getText().toString().toLowerCase().trim();
                String cabello = inputHair.getText().toString().toLowerCase().trim();
                String ojos = inputEyes.getText().toString().toLowerCase().trim();
                String cejas = inputBrows.getText().toString().toLowerCase().trim();

                String resultado = calcularColorimetria(piel, cabello, ojos, cejas);
                resultText.setText(resultado);
            }
        });
    }

    private String calcularColorimetria(String piel, String cabello, String ojos, String cejas) {
        // Verano
        if (piel.contains("rosada") && cabello.contains("rubio") &&
                ojos.contains("azul") && cejas.contains("rubio")) {
            return "Estación: Verano\nColores que más te resaltan: Azul cielo, lavanda, gris perla.";
        }
        if (piel.contains("marfil") && cabello.contains("platinado") &&
                ojos.contains("celeste") && cejas.contains("claras")) {
            return "Estación: Verano\nColores que más te resaltan: Rosa empolvado, azul suave, lila.";
        }

        // Otoño
        if (piel.contains("morena") && cabello.contains("castaño") &&
                ojos.contains("verde") && cejas.contains("oscuras")) {
            return "Estación: Otoño\nColores que más te resaltan: Terracota, verde musgo, mostaza.";
        }
        if (piel.contains("bronceada") && cabello.contains("pelirrojo") &&
                ojos.contains("miel") && cejas.contains("rojizas")) {
            return "Estación: Otoño\nColores que más te resaltan: Marrón cálido, naranja quemado.";
        }

        // Invierno
        if (piel.contains("oliva") && cabello.contains("negro") &&
                ojos.contains("oscuros") && cejas.contains("negras")) {
            return "Estación: Invierno\nColores que más te resaltan: Rojo cereza, azul marino, fucsia.";
        }
        if (piel.contains("pálida") && cabello.contains("castaño") &&
                ojos.contains("gris") && cejas.contains("oscuras")) {
            return "Estación: Invierno\nColores que más te resaltan: Negro, blanco puro, azul eléctrico.";
        }

        // Primavera
        if (piel.contains("beige") && cabello.contains("dorado") &&
                ojos.contains("miel") && cejas.contains("doradas")) {
            return "Estación: Primavera\nColores que más te resaltan: Coral, turquesa, verde menta.";
        }

        // Si no coincide con ningún perfil conocido
        return "No se pudo determinar la estación. Por favor verifica los datos.";
    }
}






