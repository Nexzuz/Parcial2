package com.example.parcial2_srs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {

    public static final String dataUsercache = "dataUser";
    private static final int modo_private = Context.MODE_PRIVATE;
    String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);

        dato = getApplicationContext().getSharedPreferences(dataUsercache, modo_private).getString("user", "0");


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (dato.equalsIgnoreCase("0")) {
                    Intent i = new Intent(SplashScreen.this, Login.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(i);
                }
            }
        }, 2000);
    }
}