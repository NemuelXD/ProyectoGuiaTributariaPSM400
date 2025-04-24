package com.nemo.proyectoguiatributariapsm400;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivityCalendario extends AppCompatActivity {

    public ListView listaCalendario;
    public ImageButton botonInicio;

    String[] items = {
            "E\nN\nE\nR\nO",
            "F\nE\nB\nR\nE\nR\nO",
            "M\nA\nR\nZ\nO",
            "A\nB\nR\nI\nL",
            "M\nA\nY\nO",
            "J\nU\nN\nI\nO",
            "J\nU\nL\nI\nO",
            "A\nG\nO\nS\nT\nO",
            "S\nE\nP\nT\nI\nE\nM\nB\nR\nE",
            "O\nC\nT\nU\nB\nR\nE",
            "N\nO\nB\nI\nE\nM\nB\nR\nE",
            "D\nI\nC\nI\nE\nM\nB\nR\nE"};
    int[] images = {
            R.drawable.img_calendario01,
            R.drawable.img_calendario02,
            R.drawable.img_calendario03,
            R.drawable.img_calendario04,
            R.drawable.img_calendario05,
            R.drawable.img_calendario06,
            R.drawable.img_calendario07,
            R.drawable.img_calendario08,
            R.drawable.img_calendario09,
            R.drawable.img_calendario10,
            R.drawable.img_calendario11,
            R.drawable.img_calendario12};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_calendario);

        this.listaCalendario = (ListView) findViewById(R.id.listViewCalendario);
        this.botonInicio = (ImageButton) findViewById(R.id.imageButtonHome);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listview_img, R.id.textView, items) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                ImageView imageView = view.findViewById(R.id.imageView);
                imageView.setImageResource(images[position]);

                return view;
            }
        };
        this.listaCalendario.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.botonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityCalendario.this,MainActivityAjustes.class));
            }
        });
    }
}