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

public class MainActivity extends AppCompatActivity {

    public Button botonIniciar;
    public ImageButton imgBotonAjustes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        this.botonIniciar = (Button) findViewById(R.id.buttonIniciar);
        this.imgBotonAjustes = (ImageButton) findViewById(R.id.imgButtonAjustes);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.botonIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivityMenu.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
            }
        });

        this.imgBotonAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivityAjustes.class));
                overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);
            }
        });
    }
}