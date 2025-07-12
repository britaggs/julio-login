package com.example.loging;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    Button btnBiblioteca, btnOptimizacion, btnGestionTela, btnOrganizacion, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnBiblioteca = findViewById(R.id.btnBiblioteca);
        btnOptimizacion = findViewById(R.id.btnOptimizacion);
        btnGestionTela = findViewById(R.id.btnGestionTela);
        btnOrganizacion = findViewById(R.id.btnOrganizacion);
        btnSalir = findViewById(R.id.btnSalir); // Nuevo botón

        btnBiblioteca.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, Biblioteca.class);
            startActivity(intent);
        });

        btnOptimizacion.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, OptimizacionCorte.class);
            startActivity(intent);
        });

        btnGestionTela.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, GestionTela.class);
            startActivity(intent);
        });

        btnOrganizacion.setOnClickListener(v -> {
            Intent intent = new Intent(Menu.this, Organizacion.class);
            startActivity(intent);
        });

        // Lógica para botón de salir de sesión
        btnSalir.setOnClickListener(v -> {
            new AlertDialog.Builder(Menu.this)
                    .setTitle("Cerrar sesión")
                    .setMessage("¿Estás seguro de que deseas cerrar sesión?")
                    .setPositiveButton("Aceptar", (dialog, which) -> {
                        // Aquí puedes redirigir al login o simplemente cerrar la actividad
                        Intent intent = new Intent(Menu.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();
        });
    }
}