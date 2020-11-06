package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Clientes_act extends AppCompatActivity
{

    private EditText etcodigo, etnombre, etsalario;
    private Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        etcodigo = (EditText)findViewById(R.id.txt1);
        etnombre = (EditText)findViewById(R.id.txt2);
        etsalario = (EditText)findViewById(R.id.txt3);
        button1 = (Button)findViewById(R.id.butn1);
        button2 = (Button)findViewById(R.id.butn2);
        button3 = (Button)findViewById(R.id.butn3);
        button4 = (Button)findViewById(R.id.butn4);

    }

    // Metodos.
    public  void GuardarCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BDClientes",null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); // permite darle permisos de escritura sobre la base de datos.

        if (!etcodigo.getText().toString().isEmpty() || !etnombre.getText().toString().isEmpty() )
        //para que se ejecute cuando no este vacio, los edittext de codigo y nombre.
        {
            ContentValues cont = new ContentValues(); // permite contener los valores de codigo, nombre y salario.

            cont.put("codigo", etcodigo.getText().toString());
            cont.put("nombre", etnombre.getText().toString());
            cont.put("salario", etsalario.getText().toString());

            db.insert("Clientes",null, cont);
            db.close();

            Toast.makeText(this, "Has Guardado un Cliente en la Base de Datos", Toast.LENGTH_LONG).show();

            etcodigo.setText("");
            etnombre.setText("");
            etsalario.setText("");
        }
        else
        {
            Toast.makeText(this, "Debe ingresar los Datos del Cliente", Toast.LENGTH_LONG).show();
        }
    }

    public void MostrarCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BDClientes",null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); // permite darle permisos de escritura sobre la base de datos.

        String codigo = etcodigo.getText().toString();

        if (!codigo.isEmpty() )
        {
            Cursor fila = db.rawQuery("SELECT nombre, salario FROM Clientes WHERE codigo=" + codigo, null);

            if (fila.moveToFirst()) // si no hay campos devuelve vacio.
            {
                etnombre.setText(fila.getString(0));
                etsalario.setText(fila.getString(1));
            }
            else
            {
                Toast.makeText(this, "No se Encuentran los Datos en la Tabla Clientes", Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this,"No hay Cliente con el Codigo Asociado", Toast.LENGTH_LONG).show();
        }
    }

    public void EliminarCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BDClientes",null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); // permite darle permisos de escritura sobre la base de datos.

        String codigo = etcodigo.getText().toString();
        String nombre = etnombre.getText().toString();

        if (codigo.isEmpty() || nombre.isEmpty())  // Mensaje por si no se ingresa codigo o nombre.
        {
            Toast.makeText(this, "Falta Ingresar Codigo de Cliente, Para Eliminarlo de la Base de Datos", Toast.LENGTH_LONG).show();
        }
        else
        {
            db.delete("Clientes", "codigo=" + codigo, null);
            db.close();
            Toast.makeText(this, "Has Eliminado un Cliente de la Base de Datos", Toast.LENGTH_LONG).show();
        }

    }

    public  void ActualizarCliente(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BDClientes",null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); // permite darle permisos de escritura sobre la base de datos.

        String codigo = etcodigo.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo", etcodigo.getText().toString());
        cont.put("nombre", etnombre.getText().toString());
        cont.put("salario", etsalario.getText().toString());

        if (!codigo.isEmpty())
        {
            db.update("Clientes", cont , "codigo="+codigo, null );
            db.close();
            Toast.makeText(this, "Has Actualizado la Informacion del Cliente", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Falta Ingresar los Datos del Cliente, Para Actualizar la Base de Datos", Toast.LENGTH_LONG).show();
        }
    }
}