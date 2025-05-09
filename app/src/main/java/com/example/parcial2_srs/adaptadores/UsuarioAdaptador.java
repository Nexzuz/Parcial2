package com.example.parcial2_srs.adaptadores;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial2_srs.Detalle;
import com.example.parcial2_srs.R;
import com.example.parcial2_srs.clases.Usuario;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UsuarioAdaptador extends RecyclerView.Adapter<UsuarioAdaptador.ViewHolder> {

    private List<Usuario> datos;

    public UsuarioAdaptador(List<Usuario> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public UsuarioAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);
        return new ViewHolder(view, datos); // Pasamos la lista al ViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdaptador.ViewHolder holder, int position) {
        Usuario dato = datos.get(position);
        holder.bind(dato);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_nombre_usuario, txt_estado_usuario, txt_especie_usuario;
        ImageView img_usuario;
        List<Usuario> datos;

        public ViewHolder(@NonNull View itemView, List<Usuario> datos) {
            super(itemView);
            this.datos = datos;

            txt_nombre_usuario = itemView.findViewById(R.id.txt_nombre_usuario);
            txt_estado_usuario = itemView.findViewById(R.id.txt_estado_usuario);
            txt_especie_usuario = itemView.findViewById(R.id.txt_especie_usuario);
            img_usuario = itemView.findViewById(R.id.img_usuario);

            Button btnDetalles = itemView.findViewById(R.id.btn_detalles);

            btnDetalles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Usuario usuarioSeleccionado = datos.get(position);

                        Intent intent = new Intent(v.getContext(), Detalle.class);
                        intent.putExtra("nombre", usuarioSeleccionado.getNombre());
                        intent.putExtra("estado", usuarioSeleccionado.getEstado());
                        intent.putExtra("especie", usuarioSeleccionado.getEspecie());
                        intent.putExtra("imagen", usuarioSeleccionado.getImagen());
                        intent.putExtra("genero", usuarioSeleccionado.getGenero());
                        intent.putExtra("origen", usuarioSeleccionado.getOrigen());
                        intent.putExtra("ubicacion", usuarioSeleccionado.getUbicacion());


                        v.getContext().startActivity(intent);
                    }
                }
            });
        }

        public void bind(Usuario dato) {
            txt_nombre_usuario.setText(dato.getNombre());
            txt_estado_usuario.setText(dato.getEstado());
            txt_especie_usuario.setText(dato.getEspecie());
            Picasso.get().load(dato.getImagen()).into(img_usuario);
        }
    }
}