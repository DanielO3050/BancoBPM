package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Seguridad_act extends AppCompatActivity
{
    private EditText edit;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seguridad_act);

        edit = (EditText) findViewById(R.id.edit);
        text = (TextView) findViewById(R.id.tv);
    }

    // Método para generar llave.

    private SecretKeySpec generateKey (String password) throws Exception
    {
        // Firma hmac utilizada para garatizar seguridad de los datos.

        MessageDigest sh = MessageDigest.getInstance("SHA-256");
        byte [] key = password.getBytes("UTF-8"); //Estándar.
        key = sh.digest(key); //Pasar cadena de bytes, la firma hmac.

        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        return secretKey;
    }

    // Método para encriptar / Algoritmo Cifrado AES.

    public String Encriptar (String datos, String password) throws Exception
    {
        if (!edit.getText().toString().isEmpty())
        {
            SecretKeySpec secretKey = generateKey(password); // Recibimos clave generada.

            Cipher cipher = Cipher.getInstance("AES"); // Obtener algoritmo.
            cipher.init(Cipher.ENCRYPT_MODE, secretKey); // Encrita llave.

            byte [] datosEncriptadosBytes = cipher.doFinal(datos.getBytes()); // Obtener cade de bytes.
            String datosEncriptadosString = Base64.encodeToString(datosEncriptadosBytes, Base64.DEFAULT);

            return datosEncriptadosString;
        }

        else
        {
            // Muestra notificación en el dispositivo.

            Toast.makeText(this, "Debe Ingresar Contraseña", Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public void Encriptar (View v)
    {
        try
        {
            String mensaje = Encriptar(edit.getText().toString(), text.getText().toString());
            text.setText(mensaje);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}