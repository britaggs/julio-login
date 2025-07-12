package com.example.loging;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Vinculamos los elementos del layout
        EditText nombre = findViewById(R.id.EditT_nombre);
        EditText apellido1 = findViewById(R.id.EditT_Primerapellido);
        EditText apellido2 = findViewById(R.id.EditT_Segundoapellido);
        EditText roll = findViewById(R.id.EditT_Roll);
        EditText correo = findViewById(R.id.EditT_Correoelectronico);
        EditText contraseña = findViewById(R.id.EditT_Contraseña);
        Button btnRegistrar = findViewById(R.id.Btn_registrar);

        // Acción al hacer clic en el botón
        btnRegistrar.setOnClickListener(v -> {
            Intent intent = new Intent(Registro.this, Usuario.class);

            // Enviar los datos a Usuario.java
            intent.putExtra("nombre", nombre.getText().toString());
            intent.putExtra("apellido1", apellido1.getText().toString());
            intent.putExtra("apellido2", apellido2.getText().toString());
            intent.putExtra("roll", roll.getText().toString());
            intent.putExtra("correo", correo.getText().toString());
            intent.putExtra("contraseña", contraseña.getText().toString());

            startActivity(intent);
        });
    }
}