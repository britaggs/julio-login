package com.example.loging;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Organizacion extends AppCompatActivity {

    EditText editTiempo;
    Button btnAlerta, btnGuardar, btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizacion_tareas);

        editTiempo = findViewById(R.id.editTiempo);
        btnAlerta = findViewById(R.id.btnAlerta);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnMenu = findViewById(R.id.btnMenu);

        // Detectar cambios en el tiempo ingresado
        editTiempo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validarTiempo(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Guardar tarea
        btnGuardar.setOnClickListener(v -> {
            String tiempo = editTiempo.getText().toString().trim();
            if (tiempo.isEmpty()) {
                Toast.makeText(this, "Por favor ingresa un tiempo válido.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Tarea guardada: " + tiempo, Toast.LENGTH_SHORT).show();
            }
        });

        // Volver al menú principal
        btnMenu.setOnClickListener(v -> {
            Intent intent = new Intent(Organizacion.this, Menu.class); // <- Aquí era importante poner `Organizacion.this`
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); // Opcional: evita duplicar actividades
            startActivity(intent);
            finish(); // Cerramos esta pantalla para que no se quede abierta
        });
    }

    private void validarTiempo(String tiempoStr) {
        if (tiempoStr.isEmpty()) {
            btnAlerta.setVisibility(View.GONE);
            return;
        }

        try {
            String[] partes = tiempoStr.split(" ");
            int cantidad = Integer.parseInt(partes[0]);

            if (cantidad > 2) {
                btnAlerta.setVisibility(View.VISIBLE);
            } else {
                btnAlerta.setVisibility(View.GONE);
            }

        } catch (Exception e) {
            btnAlerta.setVisibility(View.GONE);
        }
    }
}
