package com.nemo.proyectoguiatributariapsm400;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.nitish.typewriterview.TypeWriterView;

public class MainActivityGuia extends AppCompatActivity {

    public LinearLayout disenioTitulo02;
    public RelativeLayout imgPresentacion02;
    public int controlOrdenAparicion = 1;
    public Button botonContinuar;

    public String lineasGuiaForm110[][] = {
            {"1", "Debe ingresar al siguiente sitio web https://www.impuestos.gob.bo"},
            {"2", "Seleccione la opcion \"Siat en linea\"."}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_guia);

        this.disenioTitulo02 = (LinearLayout) findViewById(R.id.layoutGuia02);
        this.imgPresentacion02 = (RelativeLayout) findViewById(R.id.layoutImg02);
        this.botonContinuar = (Button) findViewById(R.id.buttonContinuar);


        this.botonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (disenioTitulo02.getVisibility() == View.VISIBLE) {
                    disenioTitulo02.setVisibility(View.INVISIBLE);
                    imgPresentacion02.setVisibility(View.INVISIBLE);
                } else {
                    disenioTitulo02.setVisibility(View.VISIBLE);
                    imgPresentacion02.setVisibility(View.VISIBLE);
                    Button botonGuia02 = findViewById(R.id.buttonGuia02);
                    botonGuia02.setText(lineasGuiaForm110[1][0]);

                    TypeWriterView typeWriterView2 = findViewById(R.id.textView11);
                    typeWriterView2.animateText(lineasGuiaForm110[1][1]);
                    typeWriterView2.setCharacterDelay(80);
                }
            }
        });

        Button botonGuia01 = findViewById(R.id.buttonGuia01);
        botonGuia01.setText(lineasGuiaForm110[0][0]);

        TypeWriterView typeWriterView = findViewById(R.id.textView10);
        typeWriterView.animateText(lineasGuiaForm110[0][1]);
        typeWriterView.setCharacterDelay(80);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}