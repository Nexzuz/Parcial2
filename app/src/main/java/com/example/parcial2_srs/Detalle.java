package com.example.parcial2_srs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

public class Detalle extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalle);

        TextView txtNombre, txtEstado, txtEspecie, txtGenero, txtOrigen, txtUbicacion;
        ImageView imgUsuario;

        txtNombre = findViewById(R.id.txt_detalle_nombre);
        txtEstado = findViewById(R.id.txt_detalle_estado);
        txtEspecie = findViewById(R.id.txt_detalle_especie);
        txtGenero = findViewById(R.id.txt_detalle_genero);
        txtOrigen = findViewById(R.id.txt_detalle_origen);
        txtUbicacion = findViewById(R.id.txt_detalle_ubicacion);
        imgUsuario = findViewById(R.id.img_detalle_usuario);

        // Obtener datos del intent
        String nombre = getIntent().getStringExtra("nombre");
        String estado = getIntent().getStringExtra("estado");
        String especie = getIntent().getStringExtra("especie");
        String imagen = getIntent().getStringExtra("imagen");
        String genero = getIntent().getStringExtra("genero");
        String origen = getIntent().getStringExtra("origen");
        String ubicacion = getIntent().getStringExtra("ubicacion");

        // Mostrar datos
        txtNombre.setText(nombre);
        txtEstado.setText(estado);
        txtEspecie.setText(especie);
        txtGenero.setText(genero);
        txtOrigen.setText(origen);
        txtUbicacion.setText(ubicacion);
        Picasso.get().load(imagen).into(imgUsuario);
    }
}