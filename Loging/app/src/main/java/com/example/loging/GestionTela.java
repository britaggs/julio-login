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

public class GestionTela extends AppCompatActivity {

    Spinner spinnerMaterial, spinnerColor;
    EditText editCantidad, editExtraTela;
    Button btnAgregar, btnEliminar, btnEditar, btnGuardar, btnRegresar;

    String[] materiales = {"Dacron", "Lino", "Polilycra", "Chalis"};
    String[] colores = {"Estampado", "Negro", "Blanco", "Rojo", "Azul"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_tela);

        spinnerMaterial = findViewById(R.id.spinnerMaterial);
        spinnerColor = findViewById(R.id.spinnerColor);
        editCantidad = findViewById(R.id.editCantidad);
        editExtraTela = findViewById(R.id.editExtraTela);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnEditar = findViewById(R.id.btnEditar);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnRegresar = findViewById(R.id.btnRegresarMenu);

        ArrayAdapter<String> adapterMaterial = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, materiales);
        spinnerMaterial.setAdapter(adapterMaterial);

        ArrayAdapter<String> adapterColor = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, colores);
        spinnerColor.setAdapter(adapterColor);

        btnAgregar.setOnClickListener(v -> {
            editExtraTela.setHint("Nombre de la nueva tela");
            editExtraTela.setVisibility(View.VISIBLE);
        });

        btnEditar.setOnClickListener(v -> {
            editExtraTela.setHint("Editar nombre de tela");
            editExtraTela.setVisibility(View.VISIBLE);
        });

        btnEliminar.setOnClickListener(v -> {
            String mat = spinnerMaterial.getSelectedItem().toString();
            Toast.makeText(this, "Tela eliminada: " + mat, Toast.LENGTH_SHORT).show();
        });

        btnGuardar.setOnClickListener(v -> {
            String mat = spinnerMaterial.getSelectedItem().toString();
            String col = spinnerColor.getSelectedItem().toString();
            String cant = editCantidad.getText().toString();
            String extra = editExtraTela.getText().toString();

            if (editExtraTela.getVisibility() == View.VISIBLE && !extra.isEmpty()) {
                Toast.makeText(this, "Tela personalizada: " + extra, Toast.LENGTH_SHORT).show();
            }

            Toast.makeText(this, "Diseño guardado:\n" + mat + " - " + col + " - " + cant + "m", Toast.LENGTH_LONG).show();
            editExtraTela.setVisibility(View.GONE); // Ocultar campo extra
        });

        btnRegresar.setOnClickListener(v -> {
            Intent intent = new Intent(GestionTela.this, Menu.class); // Cambia a tu actividad principal real
            startActivity(intent);
            finish();
        });
    }
}