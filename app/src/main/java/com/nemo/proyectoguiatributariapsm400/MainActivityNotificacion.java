package com.nemo.proyectoguiatributariapsm400;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.work.Data;
import androidx.work.WorkManager;

import com.nemo.proyectoguiatributariapsm400.modelo.WorkManagerNoti;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class MainActivityNotificacion extends AppCompatActivity {

    public EditText datoNIT;
    public Button botonHora;
    public TextView vistaFecha;
    public TextView vistaHora;
    public Button botonGuardarNotifi;
    public Button botonEliminarNotifi;

    public ImageButton botonInicio;

    public Calendar fechaActual = Calendar.getInstance();
    public Calendar calendario = Calendar.getInstance();
    public int minutos;
    public int hora;
    public int dia;
    public int mes;
    public int anio;

    int diasPagoEnero = 0;
    int diasPagoFebrero = 0;
    int diasPagoMarzo = 0;
    int diasPagoJunio = 0;
    int diasPagoJulio = 0;
    int diasPagoAgosto = 0;
    int diasPagoSeptiembre = 0;
    int diasPagoOctubre = 0;
    int diasPagoNobiembre = 0;
    int diasPagoDiciembre = 0;

    public String NIT[][] = {
            {"0", "14", "13"},
            {"1", "14", "14"},
            {"2", "15", "15"},
            {"3", "16", "16"},
            {"4", "17", "19"},
            {"5", "21", "19"},
            {"6", "21", "19"},
            {"7", "21", "20"},
            {"8", "21", "21"},
            {"9", "22", "22"}};

    int diasPagoAbril = 6;
    public String fechasPagoTribAbril[][] = {
            {"14", "04", "2025"},
            {"15", "04", "2025"},
            {"16", "04", "2025"},
            {"17", "04", "2025"},
            {"21", "04", "2025"},
            {"22", "04", "2025"}};

    int diasPagoMayo = 8;
    public String fechasPagoTribMayo[][] = {
            {"13", "05", "2025"},
            {"14", "05", "2025"},
            {"15", "05", "2025"},
            {"16", "05", "2025"},
            {"19", "05", "2025"},
            {"20", "05", "2025"},
            {"21", "05", "2025"},
            {"22", "05", "2025"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_notificacion);

        this.datoNIT = (EditText) findViewById(R.id.editTextNumberNIT);
        this.botonHora = (Button) findViewById(R.id.buttonHora);
        this.vistaFecha = (TextView) findViewById(R.id.textViewFecha);
        this.vistaHora = (TextView) findViewById(R.id.textViewHora);
        this.botonGuardarNotifi = (Button) findViewById(R.id.buttonGuardarNotifi);
        this.botonEliminarNotifi = (Button) findViewById(R.id.buttonEliminarNotifi);
        this.botonInicio = (ImageButton) findViewById(R.id.imageButtonHom);

        /*
        this.botonFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendario.set(2025,3,24);

                anio = fechaActual.get(Calendar.YEAR);
                mes = fechaActual.get(Calendar.MONTH);
                dia = fechaActual.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                        calendario.set(Calendar.DAY_OF_MONTH, d);
                        calendario.set(Calendar.MONTH, m);
                        calendario.set(Calendar.YEAR, y);

                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        String cadenaFecha = format.format(calendario.getTime());
                        vistaFecha.setText(cadenaFecha);

                    }
                }, anio, mes, dia);
                datePickerDialog.show();
            }
        });*/

        this.botonHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hora = fechaActual.get(Calendar.HOUR_OF_DAY);
                minutos = fechaActual.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(view.getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int h, int min) {
                        calendario.set(Calendar.HOUR_OF_DAY, h);
                        calendario.set(Calendar.MINUTE, min);

                        vistaHora.setText(String.format("%02d:%02d", h, min));
                    }
                }, hora, minutos, true);
                timePickerDialog.show();
            }
        });

        this.botonGuardarNotifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (datoNIT.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivityNotificacion.this, "Ingrese su ultimo digito\ndel NIT por favor...", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(datoNIT.getText().toString()) >= 0 && Integer.parseInt(datoNIT.getText().toString()) <= 9 && !vistaHora.getText().toString().equalsIgnoreCase("Hora seleccionada")) {
                    int nit = Integer.parseInt(datoNIT.getText().toString());
                    registrarFecha(nit);
                    String tag = generateKey();
                    long alertTime = calendario.getTimeInMillis() - System.currentTimeMillis();
                    int random = (int) (Math.random() * 50 + 1);
                    Data data = guardarData("Mi Guia Tributaria", "Recuerda pagar hoy tus impuestos :)", random);
                    WorkManagerNoti.guardarNotificacion(alertTime, data, "tag2");
                    Toast.makeText(MainActivityNotificacion.this, "Notificacion guardada", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivityNotificacion.this, "Ingrese un dato valido por favor\no valide la hora...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        this.botonEliminarNotifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarNotificacion("tag2");
            }
        });

        this.botonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityNotificacion.this, MainActivityAjustes.class));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void registrarFecha(int nit) {
        for (int i = 0; i < 10; i++) {
            if (Integer.parseInt(NIT[i][0]) == nit) {
                int mesActual = fechaActual.get(Calendar.MONTH) + 1;
                switch (mesActual) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        for (int j = 0; j < diasPagoAbril; j++) {
                            if (Integer.parseInt(fechasPagoTribAbril[j][0]) == Integer.parseInt(NIT[i][1])) {
                                int d = Integer.parseInt(fechasPagoTribAbril[j][0]);
                                int m = Integer.parseInt(fechasPagoTribAbril[j][1]);
                                int y = Integer.parseInt(fechasPagoTribAbril[j][2]);
                                calendario.set(y, m - 1, d);
                            }
                        }
                        break;
                    case 5:
                        for (int j = 0; j < diasPagoMayo; j++) {
                            if (Integer.parseInt(fechasPagoTribMayo[j][0]) == Integer.parseInt(NIT[i][2])) {
                                int d = Integer.parseInt(fechasPagoTribMayo[j][0]);
                                int m = Integer.parseInt(fechasPagoTribMayo[j][1]);
                                int y = Integer.parseInt(fechasPagoTribMayo[j][2]);
                                calendario.set(y, m - 1, d);
                            }
                        }
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    case 12:
                        break;
                }
            }
        }
    }

    public void pruebafecha() {
        calendario.set(2025, 3, 24);
    }

    public void eliminarNotificacion(String tag) {
        WorkManager.getInstance(this).cancelAllWorkByTag(tag);
        Toast.makeText(MainActivityNotificacion.this, "Notificacion Eliminada!", Toast.LENGTH_SHORT).show();
    }

    public String generateKey() {
        return UUID.randomUUID().toString();
    }

    public Data guardarData(String titulo, String detalle, int idNoti) {
        return new Data.Builder()
                .putString("titulo", titulo)
                .putString("detalle", detalle)
                .putInt("idNoti", idNoti).build();
    }
}