package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Info_act extends AppCompatActivity
{
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);

        videoView = (VideoView) findViewById(R.id.vd); // Llamar video por id.

        // Ruta del video.
        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse (ruta);

        videoView.setVideoURI(uri); // Video obtiene el recurso.

        // Definir Controles de Navegación de video.

        MediaController media = new MediaController (this);
        videoView.setMediaController(media);
    }

    public void Maps (View v)
    {
        Intent i = new Intent (this, Maps_act.class);
        startActivity(i);
    }
}