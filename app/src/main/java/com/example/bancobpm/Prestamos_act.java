package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Prestamos_act extends AppCompatActivity
{

    private Spinner spinner1;
    private Spinner spinner2;
    private TextView textView;
    private int SaldoAlex = 750000;
    private int SaldoRoxana = 900000;
    private int CreditoHip = 1000000;
    private int CreditoAuto = 500000;
    private int saldoAlHP = SaldoAlex + CreditoHip;
    private int saldoAlAT = SaldoAlex + CreditoAuto;
    private int saldoRxHP = SaldoRoxana + CreditoHip;
    private int saldoRxAT = SaldoRoxana + CreditoAuto;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos_act);

        spinner1 =(Spinner)findViewById(R.id.sp2);
        spinner2 = (Spinner)findViewById(R.id.sp3);
        textView = (TextView)findViewById(R.id.tx1);

        // Recibir los datos de los arraylist.

        ArrayList<String> listaClientes =  (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList <String> listaCreditos = (ArrayList<String>) getIntent().getSerializableExtra("listaCreditos");

        ArrayAdapter <String> adap1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter <String> adap2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaCreditos);
        spinner1.setAdapter(adap1);
        spinner2.setAdapter(adap2);

    }

    public void Prestamo(View v)
    {
        String cliente = spinner1.getSelectedItem().toString();
        String credito = spinner2.getSelectedItem().toString();


        // Para Alex
        if (cliente.equals("Alex") & credito.equals("Credito Hipotecario"))
        {
            textView.setText(new StringBuilder().append("Su Saldo Final con el Prestamo de Credito Hipotecario es de: ").append(saldoAlHP).append(" Pesos "));
        }
        else if (cliente.equals("Alex") & credito.equals("Credito Automotriz"))
        {
            textView.setText(new StringBuilder().append("Su Saldo Final con el Prestamo de Credito Automotriz es de: ").append(saldoAlAT).append(" Pesos "));
        }

        // Para Roxana
        else if (cliente.equals("Roxana") & credito.equals("Credito Hipotecario"))
        {
            textView.setText(new StringBuilder().append("Su Saldo Final con el Prestamo de Credito Hipotecario es de: ").append(saldoRxHP).append(" Pesos "));
        }
        else if (cliente.equals("Roxana") & credito.equals("Credito Automotriz"))
        {
            textView.setText(new StringBuilder().append("Su Saldo Final con el Prestamo de Credito Automotriz es de: ").append(saldoRxAT).append(" Pesos "));
        }

    }

    public void Deuda(View v)
    {
        String cliente = spinner1.getSelectedItem().toString();
        String credito = spinner2.getSelectedItem().toString();

        int deudaAlHP = saldoAlHP/12;
        int deudaAlAT = saldoAlAT/8;
        int deudaRxHP = saldoRxHP/12;
        int deudaRxAT = saldoRxAT/8;

        // Para Alex
        if (cliente.equals("Alex") & credito.equals("Credito Hipotecario"))
        {
            textView.setText(new StringBuilder().append("Cada Cuota de la Deuda a Pagar es de: ").append(deudaAlHP).append(" Pesos "));
        }
        else if (cliente.equals("Alex") & credito.equals("Credito Automotriz"))
        {
            textView.setText(new StringBuilder().append("Cada Cuota de la Deuda a Pagar es de: ").append(deudaAlAT).append(" Pesos "));
        }

        // Para Roxana
        else if (cliente.equals("Roxana") & credito.equals("Credito Hipotecario"))
        {
            textView.setText(new StringBuilder().append("Cada Cuota de la Deuda a Pagar es de: ").append(deudaRxHP).append(" Pesos "));
        }
        else if (cliente.equals("Roxana") & credito.equals("Credito Automotriz"))
        {
            textView.setText(new StringBuilder().append("Cada Cuota de la Deuda a Pagar es de: ").append(deudaRxAT).append(" Pesos "));
        }

    }
}