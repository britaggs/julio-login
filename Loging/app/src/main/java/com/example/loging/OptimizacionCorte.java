package com.example.loging;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OptimizacionCorte extends AppCompatActivity {

    Spinner spinnerAncho, spinnerPanos;
    EditText editTextNovedades;
    Button btnGuardar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optimizacion_corte);

        spinnerAncho = findViewById(R.id.spinnerAnchoTela);
        spinnerPanos = findViewById(R.id.spinnerPanosTela);
        editTextNovedades = findViewById(R.id.editTextNovedades);
        btnGuardar = findViewById(R.id.btnGuardarDiseno);
        btnRegresar = findViewById(R.id.btnRegresarMenu); // Nuevo botón

        // Opciones de ancho de tela
        String[] opcionesAncho = {"1.40", "1.50", "1.80"};
        ArrayAdapter<String> adapterAncho = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opcionesAncho);
        spinnerAncho.setAdapter(adapterAncho);

        // Opciones de paños de tela
        String[] opcionesPanos = {"300", "500"};
        ArrayAdapter<String> adapterPanos = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, opcionesPanos);
        spinnerPanos.setAdapter(adapterPanos);

        // Botón para guardar
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ancho = spinnerAncho.getSelectedItem().toString();
                String panos = spinnerPanos.getSelectedItem().toString();
                String novedades = editTextNovedades.getText().toString();

                Toast.makeText(OptimizacionCorte.this, "Diseño guardado:\nAncho: " + ancho + "\nPaños: " + panos + "\nNovedades: " + novedades, Toast.LENGTH_LONG).show();
            }
        });

        // Botón para regresar a menú
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptimizacionCorte.this, Menu.class); // Asegúrate de que "Menu" sea tu actividad
                startActivity(intent);
                finish(); // Cierra esta pantalla
            }
        });
    }
}