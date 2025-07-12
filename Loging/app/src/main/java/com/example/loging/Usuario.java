package com.example.loging;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Usuario extends AppCompatActivity {

    EditText editNombre, editPrimerApellido, editSegundoApellido, editRol, editCorreo, editContrasena;
    Button btnIrAlMenu, btnIrPantallaAntigua, btnIrRegistro, btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_usuario);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicialización de campos de texto
        editNombre = findViewById(R.id.editNombre);
        editPrimerApellido = findViewById(R.id.editPrimerApellido);
        editSegundoApellido = findViewById(R.id.editSegundoApellido);
        editRol = findViewById(R.id.editRol);
        editCorreo = findViewById(R.id.editCorreo);
        editContrasena = findViewById(R.id.editContrasena);

        // Botones existentes
        btnIrAlMenu = findViewById(R.id.btnIrAlMenu);
        btnIrPantallaAntigua = findViewById(R.id.btnIrPantallaAntigua);

        // Nuevos botones
        btnOk = findViewById(R.id.btnOk);
        btnIrRegistro = findViewById(R.id.btnIrRegistro);

        //  Lógica mejorada para el botón OK
        btnOk.setOnClickListener(v -> {
            String nombre = editNombre.getText().toString().trim();
            String correo = editCorreo.getText().toString().trim();
            String contrasena = editContrasena.getText().toString().trim();

            if (!nombre.isEmpty() && !correo.isEmpty() && !contrasena.isEmpty()) {
                Toast.makeText(Usuario.this, "Puede ingresar al menú", Toast.LENGTH_SHORT).show();

                // Ir al menú automáticamente
                Intent intent = new Intent(Usuario.this, Menu.class);
                startActivity(intent);
            } else {
                Toast.makeText(Usuario.this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
            }
        });

        // ✅ Botón para ir al registro
        btnIrRegistro.setOnClickListener(v -> {
            Intent intent = new Intent(Usuario.this, Registro.class);
            startActivity(intent);
        });

        // ✅ Botones ya existentes
        btnIrAlMenu.setOnClickListener(v -> {
            Intent intent = new Intent(Usuario.this, Menu.class);
            startActivity(intent);
        });

        btnIrPantallaAntigua.setOnClickListener(v -> {
            Intent intent = new Intent(Usuario.this, MainActivity.class);
            startActivity(intent);
        });
    }
}