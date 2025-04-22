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

public class MainActivityMenu extends AppCompatActivity {
    public ImageButton imgBotonInicio;
    public Button botonInicioSecion;
    public Button botonForm110;
    public Button botonForm610;
    public Button botonForm200;
    public Button botonForm400;
    public Button botonFormRCIVA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_menu);

        this.imgBotonInicio = (ImageButton) findViewById(R.id.imgButtonInicio);
        this.botonInicioSecion = (Button) findViewById(R.id.buttonInicioSesion);
        this.botonForm110 = (Button) findViewById(R.id.buttonForm110);
        this.botonForm610 = (Button) findViewById(R.id.buttonForm610);
        this.botonForm200 = (Button) findViewById(R.id.buttonForm200);
        this.botonForm400 = (Button) findViewById(R.id.buttonForm400);
        this.botonFormRCIVA = (Button) findViewById(R.id.buttonFormRCIVA);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.imgBotonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityMenu.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
            }
        });

        this.botonInicioSecion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityMenu.this, MainActivityGuia.class).putExtra("id", "1"));
            }
        });

        this.botonForm110.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityMenu.this, MainActivityGuia.class).putExtra("id", "2"));
            }
        });

        this.botonForm610.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityMenu.this, MainActivityGuia.class).putExtra("id", "3"));
            }
        });

        this.botonForm200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityMenu.this, MainActivityGuia.class).putExtra("id", "4"));
            }
        });

        this.botonForm400.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityMenu.this, MainActivityGuia.class).putExtra("id", "5"));
            }
        });

        this.botonFormRCIVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityMenu.this, MainActivityGuia.class).putExtra("id", "6"));
            }
        });
    }
}