package com.example.interfaz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    EditText etBirthday,alumno_registrado;
    Calendar calendario = Calendar.getInstance();
    Button pase_lista, administrar_grupos, hoy, salida, crear_grupo_vacio, crear_grupo_arch, agregar_alumno;
    Spinner spinner1, spinner2, spinner3;
    ListView list_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button pase_lista = (Button) findViewById(R.id.pase_lista);
        Button administrar_grupos = (Button) findViewById(R.id.buttonAdministrarGrupo);
        Button hoy = (Button) findViewById(R.id.button_hoy);
        Button salida = (Button) findViewById(R.id.button_salir_aplicacion);
        Button crear_grupo_vacio = (Button) findViewById(R.id.grupo_vacio);
        Button crear_grupo_arch = (Button) findViewById(R.id.grupo_arch);
        Button agregar_alumno = (Button) findViewById(R.id.agregar_alumno);
        EditText alumno_registrado = (EditText) findViewById(R.id.alumno_registrado);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        ListView list_view = (ListView) findViewById(R.id.list_view);

        // Importante: Esto va antes de instanciar controles dentro de cada pestaña

        // Agregar las pestañas---
        Resources res = getResources();
        TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec spec1 = tabHost.newTabSpec("");
        spec1.setContent(R.id.tab1);
        spec1.setIndicator("PASES LISTA");

        TabHost.TabSpec spec2 = tabHost.newTabSpec("");
        spec2.setContent(R.id.tab2);
        spec2.setIndicator("Grupos");

        TabHost.TabSpec spec3 = tabHost.newTabSpec("");
        spec3.setContent(R.id.tab3);
        spec3.setIndicator("Alumnos");

        TabHost.TabSpec spec4 = tabHost.newTabSpec("");
        spec4.setContent(R.id.tab4);
        spec4.setIndicator("Estadisticas");
//acomoda las pestañas
        tabHost.addTab(spec1);
        tabHost.addTab(spec2);
        tabHost.addTab(spec3);
        tabHost.addTab(spec4);

        // Otros Recursos (TextView, Buttons, ListView, EditText, etx)

        //calendario
        etBirthday = findViewById(R.id.etBirthday);
        etBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(MainActivity.this, date, calendario
                        .get(Calendar.YEAR), calendario.get(Calendar.MONTH),
                        calendario.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }


    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            calendario.set(Calendar.YEAR, year);
            calendario.set(Calendar.MONTH, monthOfYear);
            calendario.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            actualizarInput();
        }

    };


    private void actualizarInput() {
        String formatoDeFecha = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(formatoDeFecha, Locale.US);

        etBirthday.setText(sdf.format(calendario.getTime()));
    }
}

