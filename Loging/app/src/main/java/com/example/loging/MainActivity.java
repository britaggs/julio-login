package com.example.loging;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imgVestido;
    Button btnColorimetria, btnVisagismo, btnInicio; // ⬅️ Agregado botón Inicio

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgVestido = findViewById(R.id.imgVestido);
        btnColorimetria = findViewById(R.id.btnColorimetria);
        btnVisagismo = findViewById(R.id.btnVisagismo);
        btnInicio = findViewById(R.id.btnInicio); // ⬅️ Inicialización del botón Inicio

        imgVestido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VestidoDetalleActivity.class);
                startActivity(intent);
            }
        });

        btnColorimetria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, colorimetriaActivity.class);
                startActivity(intent);
            }
        });

        btnVisagismo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VisagismoActivity.class);
                startActivity(intent);
            }
        });

        // ➕ Acción del botón Inicio
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Usuario.class);
                startActivity(intent);
            }
        });
    }
}
