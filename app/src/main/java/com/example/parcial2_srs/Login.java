package com.example.parcial2_srs;

import android.content.Context;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    public static final String dataUsercache = "dataUser";
    private static final int modo_private = Context.MODE_PRIVATE;
    EditText edt_text_user,edt_text_password ;
    Button btn_iniciar;

    //variables sharedpreference

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        edt_text_user = findViewById(R.id.edt_text_user);
        edt_text_password = findViewById(R.id.edt_text_password);
        btn_iniciar = findViewById(R.id.btn_pantalla);

        sharedPreferences = getSharedPreferences(dataUsercache,modo_private);
        editor = sharedPreferences.edit();

        btn_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
        });

    }

    private void validar() {
        String usuario;
        String password;

        usuario = edt_text_user.getText().toString();
        password = edt_text_password.getText().toString();

        if (!usuario.isEmpty() && !password.isEmpty()){
            //guardado de datos
            editor.putString("user",usuario);
            editor.commit();
            Intent i = new Intent(Login.this, MainActivity.class);
            startActivity(i);
        }else{
            Toast.makeText(Login.this, "Debe completar todos los campos",Toast.LENGTH_LONG).show();
        }
    }
}