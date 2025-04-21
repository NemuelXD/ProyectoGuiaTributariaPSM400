package com.nemo.proyectoguiatributariapsm400;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.nemo.proyectoguiatributariapsm400.modelo.DatosGuia;
import com.nitish.typewriterview.TypeWriterView;

public class MainActivityGuia extends AppCompatActivity {

    public LinearLayout disenioTitulo01;
    public LinearLayout disenioTitulo02;
    public RelativeLayout imgPresentacion01;
    public RelativeLayout imgPresentacion02;
    public Button botonGuia01;
    public Button botonGuia02;
    public Button botonContinuar;
    public Button botonVolver;
    public TypeWriterView textoGuia01;
    public TypeWriterView textoGuia02;
    public ImageView imgGuia01;
    public ImageView imgGuia02;

    public DatosGuia datosGuia;
    public AlphaAnimation animGuia;
    public int controlAparicion = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_guia);

        this.disenioTitulo01 = (LinearLayout) findViewById(R.id.layoutGuia01);
        this.disenioTitulo02 = (LinearLayout) findViewById(R.id.layoutGuia02);
        this.imgPresentacion01 = (RelativeLayout) findViewById(R.id.layoutImg01);
        this.imgPresentacion02 = (RelativeLayout) findViewById(R.id.layoutImg02);
        this.botonGuia01 = (Button) findViewById(R.id.buttonGuia01);
        this.botonGuia02 = (Button) findViewById(R.id.buttonGuia02);
        this.textoGuia01 = (TypeWriterView) findViewById(R.id.textView01);
        this.textoGuia02 = (TypeWriterView) findViewById(R.id.textView02);
        this.imgGuia01 = (ImageView) findViewById(R.id.imageView01);
        this.imgGuia02 = (ImageView) findViewById(R.id.imageView02);
        this.botonContinuar = (Button) findViewById(R.id.buttonContinuar);
        this.botonVolver = (Button) findViewById(R.id.buttonVolver);

        this.datosGuia = new DatosGuia();
        this.animGuia = new AlphaAnimation(0.0f, 1.0f);
        this.animGuia.setDuration(2000);

        escucharBotonVolver();
        escucharBotonContinuar();

        new Handler().postDelayed(new Runnable() {
            @SuppressLint("DiscouragedApi")
            @Override
            public void run() {
                disenioTitulo01.setVisibility(View.VISIBLE);
                imgPresentacion01.setVisibility(View.VISIBLE);
                botonGuia01.setText(controlAparicion + "");
                textoGuia01.animateText(datosGuia.obtenerDescripsionGuia(controlAparicion, datosGuia.getGuiaInicioSecion()));
                textoGuia01.setCharacterDelay(80);
                imgGuia01.setImageResource(getResources().getIdentifier(datosGuia.obtenerRutaImgGuia(controlAparicion, datosGuia.getGuiaInicioSecion()), "drawable", getPackageName()));
                disenioTitulo01.startAnimation(animGuia);
                imgPresentacion01.startAnimation(animGuia);
            }
        }, 2000);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void escucharBotonVolver() {
        this.botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityGuia.this, MainActivityMenu.class));
            }
        });
    }

    private void escucharBotonContinuar() {
        this.botonContinuar.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DiscouragedApi")
            @Override
            public void onClick(View view) {
                if (controlAparicion % 2 != 0) {
                    controlAparicion++;
                    disenioTitulo02.setVisibility(View.VISIBLE);
                    imgPresentacion02.setVisibility(View.VISIBLE);
                    botonGuia02.setText(controlAparicion + "");
                    textoGuia02.animateText(datosGuia.obtenerDescripsionGuia(controlAparicion, datosGuia.getGuiaInicioSecion()));
                    textoGuia02.setCharacterDelay(80);
                    imgGuia02.setImageResource(getResources().getIdentifier(datosGuia.obtenerRutaImgGuia(controlAparicion, datosGuia.getGuiaInicioSecion()), "drawable", getPackageName()));
                    disenioTitulo02.startAnimation(animGuia);
                    imgPresentacion02.startAnimation(animGuia);
                } else {
                    controlAparicion++;
                    disenioTitulo02.setVisibility(View.INVISIBLE);
                    imgPresentacion02.setVisibility(View.INVISIBLE);
                    botonGuia01.setText(controlAparicion + "");
                    textoGuia01.animateText(datosGuia.obtenerDescripsionGuia(controlAparicion, datosGuia.getGuiaInicioSecion()));
                    textoGuia01.setCharacterDelay(80);
                    imgGuia01.setImageResource(getResources().getIdentifier(datosGuia.obtenerRutaImgGuia(controlAparicion, datosGuia.getGuiaInicioSecion()), "drawable", getPackageName()));
                    disenioTitulo01.startAnimation(animGuia);
                    imgPresentacion01.startAnimation(animGuia);
                }
            }
        });
    }
}