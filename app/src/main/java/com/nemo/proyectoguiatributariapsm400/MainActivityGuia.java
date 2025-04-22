package com.nemo.proyectoguiatributariapsm400;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.nemo.proyectoguiatributariapsm400.modelo.DatosGuia;
import com.nitish.typewriterview.TypeWriterView;

import pl.droidsonroids.gif.GifImageView;

public class MainActivityGuia extends AppCompatActivity {

    public LinearLayout disenioTitulo;
    public LinearLayout disenioTitulo01;
    public LinearLayout disenioTitulo02;
    public RelativeLayout imgPresentacion01;
    public RelativeLayout imgPresentacion02;
    public Button botonGuia01;
    public Button botonGuia02;
    public Button botonContinuar;
    public Button botonVolver;
    public TextView textoTitulo;
    public TypeWriterView textoGuia01;
    public TypeWriterView textoGuia02;
    public GifImageView imgGifGuia;
    public ImageView imgGuia01;
    public ImageView imgGuia02;
    public DatosGuia datosGuia;
    public AlphaAnimation animGuia;
    public int controlAparicion = 0;
    public int idGuia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_guia);
        idGuia = Integer.parseInt(getIntent().getStringExtra("id"));

        this.disenioTitulo = (LinearLayout) findViewById(R.id.layoutTitulo);
        this.disenioTitulo01 = (LinearLayout) findViewById(R.id.layoutGuia01);
        this.disenioTitulo02 = (LinearLayout) findViewById(R.id.layoutGuia02);
        this.imgPresentacion01 = (RelativeLayout) findViewById(R.id.layoutImg01);
        this.imgPresentacion02 = (RelativeLayout) findViewById(R.id.layoutImg02);
        this.botonGuia01 = (Button) findViewById(R.id.buttonGuia01);
        this.botonGuia02 = (Button) findViewById(R.id.buttonGuia02);
        this.textoTitulo = (TextView) findViewById(R.id.textViewTitulo);
        this.textoGuia01 = (TypeWriterView) findViewById(R.id.textView01);
        this.textoGuia02 = (TypeWriterView) findViewById(R.id.textView02);
        this.imgGifGuia = (GifImageView) findViewById(R.id.imageViewGif02);
        this.imgGuia01 = (ImageView) findViewById(R.id.imageView01);
        this.imgGuia02 = (ImageView) findViewById(R.id.imageView02);
        this.botonContinuar = (Button) findViewById(R.id.buttonContinuar);
        this.botonVolver = (Button) findViewById(R.id.buttonVolver);

        this.datosGuia = new DatosGuia();
        this.animGuia = new AlphaAnimation(0.0f, 1.0f);
        this.animGuia.setDuration(2000);

        if (idGuia == 1) {
            cargarTituloGuia("INICIO DE SECION", "gif_asistente2", Color.rgb(93, 173, 226));
        }
        if (idGuia == 2) {
            cargarTituloGuia("FORMULARIO 110", "gif_asistente2", Color.rgb(70, 223, 90));
        }
        if (idGuia == 3) {
            cargarTituloGuia("FORMULARIO 610", "gif_asistente2", Color.rgb(245, 48, 90));
        }
        if (idGuia == 4) {
            cargarTituloGuia("FORMULARIO 200", "gif_asistente3", Color.rgb(219, 51, 245));
        }
        if (idGuia == 5) {
            cargarTituloGuia("FORMULARIO 400", "gif_asistente3", Color.rgb(245, 127, 50));
        }
        if (idGuia == 6) {
            cargarTituloGuia("FORMULARIO RC-IVA", "gif_asistente3", Color.rgb(51, 229, 188));
        }

        escucharBotonVolver();
        escucharBotonContinuar();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                aparecerInicioSecion01();
            }
        }, 1500);

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
                    aparecerInicioSecion02();
                } else {
                    aparecerInicioSecion01();
                }
            }
        });
    }

    @SuppressLint("DiscouragedApi")
    public void cargarTituloGuia(String titulo, String gifGuia, int botonColor) {
        this.textoTitulo.setText(titulo);
        this.imgGifGuia.setImageResource(getResources().getIdentifier(gifGuia, "drawable", getPackageName()));
        this.botonGuia01.setBackgroundColor(botonColor);
        this.botonGuia02.setBackgroundColor(botonColor);
    }

    @SuppressLint("DiscouragedApi")
    public void aparecerInicioSecion01() {
        controlAparicion++;
        disenioTitulo01.setVisibility(View.VISIBLE);
        imgPresentacion01.setVisibility(View.VISIBLE);
        disenioTitulo02.setVisibility(View.INVISIBLE);
        imgPresentacion02.setVisibility(View.INVISIBLE);
        botonGuia01.setText(controlAparicion + "");
        textoGuia01.animateText(datosGuia.obtenerDescripsionGuia(controlAparicion, datosGuia.getGuiaInicioSecion()));
        textoGuia01.setCharacterDelay(80);
        imgGuia01.setImageResource(getResources().getIdentifier(datosGuia.obtenerRutaImgGuia(controlAparicion, datosGuia.getGuiaInicioSecion()), "drawable", getPackageName()));
        disenioTitulo01.startAnimation(animGuia);
        imgPresentacion01.startAnimation(animGuia);
    }

    @SuppressLint("DiscouragedApi")
    public void aparecerInicioSecion02() {
        controlAparicion++;
        disenioTitulo02.setVisibility(View.VISIBLE);
        imgPresentacion02.setVisibility(View.VISIBLE);
        botonGuia02.setText(controlAparicion + "");
        textoGuia02.animateText(datosGuia.obtenerDescripsionGuia(controlAparicion, datosGuia.getGuiaInicioSecion()));
        textoGuia02.setCharacterDelay(80);
        imgGuia02.setImageResource(getResources().getIdentifier(datosGuia.obtenerRutaImgGuia(controlAparicion, datosGuia.getGuiaInicioSecion()), "drawable", getPackageName()));
        disenioTitulo02.startAnimation(animGuia);
        imgPresentacion02.startAnimation(animGuia);
    }
}