package com.example.loging;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class VestidoDetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vestido_detalle);


        ImageView imgVestido = findViewById(R.id.imgVestido);
        TextView textoDetalle = findViewById(R.id.textoDetalle);


    }
}