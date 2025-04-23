package com.nemo.proyectoguiatributariapsm400;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivityAjustes extends AppCompatActivity {

    public ImageButton imgBotonInicio;
    public Button botonCalendario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_ajustes);

        this.imgBotonInicio = (ImageButton) findViewById(R.id.imgButtonInicioA);
        this.botonCalendario = (Button) findViewById(R.id.buttonCalendario);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.imgBotonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityAjustes.this, MainActivity.class));
                overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
            }
        });

        this.botonCalendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityAjustes.this, MainActivityCalendario.class));
            }
        });
    }
}