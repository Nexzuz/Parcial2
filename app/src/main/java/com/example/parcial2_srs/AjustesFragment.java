package com.example.parcial2_srs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AjustesFragment extends Fragment {

    public static final String dataUsercache = "dataUser";
    private static final int modo_private = Context.MODE_PRIVATE;

    public AjustesFragment() {
        // Constructor vacío obligatorio
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ajustes, container, false);

        TextView txt_usuario_detalle;
        String dato;

        txt_usuario_detalle = view.findViewById(R.id.txt_usuario_ajustes);

        dato = requireActivity().getSharedPreferences(dataUsercache, modo_private).getString("user", "0");

        txt_usuario_detalle.setText(dato);




        Button btnCerrarSesion = view.findViewById(R.id.btn_cerrar_sesion);

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = requireActivity().getSharedPreferences(Login.dataUsercache, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                Toast.makeText(getActivity(), "Sesión cerrada", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getActivity(), Login.class);
                startActivity(i);
            }
        });

        return view;
    }
}