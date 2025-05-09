package com.example.parcial2_srs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parcial2_srs.adaptadores.UsuarioAdaptador;
import com.example.parcial2_srs.clases.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InicioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InicioFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InicioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InicioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InicioFragment newInstance(String param1, String param2) {
        InicioFragment fragment = new InicioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        RecyclerView rcv_usuarios = view.findViewById(R.id.rcv_usuarios);

        List<Usuario> listaUsuarios = new ArrayList<>();
        Usuario usu1 = new Usuario("https://koradiproductions.com/wp-content/uploads/2022/03/rick-sanchez.jpg","Rick Sanchez","Alive","Human", "Male", "C137", "Colombia");
        Usuario usu2 = new Usuario("https://rickandmortyapi.com/api/character/avatar/120.jpeg","Rick 2","Dead","Human", "Male", "C137", "Colombia");
        Usuario usu3 = new Usuario("https://rickandmortyapi.com/api/character/avatar/190.jpeg","Rick 3","Alive","Human", "Male", "C137", "Colombia");
        Usuario usu4 = new Usuario("https://rickandmortyapi.com/api/character/avatar/241.jpeg","Rick 4","Dead","Human", "Male", "C137", "Colombia");
        Usuario usu5 = new Usuario("https://rickandmortyapi.com/api/character/avatar/72.jpeg","Rick 5","Alive","Human", "Male", "C137", "Colombia");

        listaUsuarios.add(usu1);
        listaUsuarios.add(usu2);
        listaUsuarios.add(usu3);
        listaUsuarios.add(usu4);
        listaUsuarios.add(usu5);

        rcv_usuarios.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv_usuarios.setAdapter(new UsuarioAdaptador(listaUsuarios));

        return view;
    }
}