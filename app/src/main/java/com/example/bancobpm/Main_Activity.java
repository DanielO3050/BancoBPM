package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Main_Activity extends AppCompatActivity
{
    private ProgressBar progress;
    private Button btn;

    // Variables Login
    private EditText user;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Guardar datos por id.
        //login.
        user = findViewById(R.id.nombre);
        pass = findViewById(R.id.contraseña);

        //Progress bar y Botón.
        progress = (ProgressBar) findViewById(R.id.pb);
        btn = (Button) findViewById(R.id.btn);

        progress.setVisibility(View.INVISIBLE); // Desaparece Progress Bar.

       // El elemento OnClick de la interfaz.
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // La tarea Asíncrona solo se ejecuta si el usuario y contraseña es correcto.
                String usuario = user.getText().toString();
                String contraseña = pass.getText().toString();

                if (usuario.equalsIgnoreCase("android") && contraseña.equals("123"))
                {
                    new Task().execute();
                    Intent i = new Intent (getBaseContext(), Home_act.class);
                    startActivity(i);
                }
            }
        });
    }

    // Tarea Asíncrona
    class Task extends AsyncTask<String, Void, String>
    {
        @Override  // Config. de la barra.
        protected void onPreExecute()
        {
            progress.setVisibility(View.VISIBLE); // Hacer visible Prog. Bar.
        }

        @Override // Correr tarea pesada.
        protected String doInBackground(String... strings)
        {
            for (int i = 1; i <= 10; i++)
            {
                try
                {
                    Thread.sleep(1000);
                }

                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s)
        {

        }
    }

    // Tarea Pesada
    public void Hilo (View v) {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}