package com.example.loging;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Biblioteca extends AppCompatActivity {

    private EditText inputExportar, inputEditar;
    private TextView textoGuardado;
    private Spinner spinnerPrendas, spinnerTallas;

    private String textoExportado = "";
    private String textoEditado = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biblioteca);

        // Referencias de UI
        inputExportar = findViewById(R.id.input_exportar);
        inputEditar = findViewById(R.id.input_editar);
        textoGuardado = findViewById(R.id.texto_guardado);
        spinnerPrendas = findViewById(R.id.spinner_prendas);
        spinnerTallas = findViewById(R.id.spinner_tallas);

        Button btnExportar = findViewById(R.id.btn_exportar);
        Button btnEditar = findViewById(R.id.btn_editar);
        Button btnEliminar = findViewById(R.id.btn_eliminar);
        Button btnRegresarMenu = findViewById(R.id.btn_regresar_menu);

        // Exportar
        btnExportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoExportado = inputExportar.getText().toString();
                actualizarTextoGuardado();
            }
        });

        // Editar
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoEditado = inputEditar.getText().toString();
                actualizarTextoGuardado();
            }
        });

        // Eliminar
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputExportar.setText("");
                inputEditar.setText("");
                textoExportado = "";
                textoEditado = "";
                textoGuardado.setText("Información eliminada.");
            }
        });

        // Regresar al menú
        btnRegresarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irAlMenu = new Intent(Biblioteca.this, Menu.class);
                startActivity(irAlMenu);
                finish(); // Opcional: cierra esta pantalla para no regresar con el botón de atrás
            }
        });
    }

    private void actualizarTextoGuardado() {
        StringBuilder resultado = new StringBuilder();

        if (!textoExportado.isEmpty()) {
            resultado.append("📤 Exportado: ").append(textoExportado).append("\n");
        }
        if (!textoEditado.isEmpty()) {
            resultado.append("📝 Editado: ").append(textoEditado);
        }

        if (resultado.length() == 0) {
            textoGuardado.setText("No hay datos guardados.");
        } else {
            textoGuardado.setText(resultado.toString());
        }
    }
}