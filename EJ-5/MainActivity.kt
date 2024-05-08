package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var etPrecioKilo: EditText
    private lateinit var etPesoGramos: EditText
    private lateinit var tvPrecioLista: TextView
    private lateinit var tvPrecioFinal: TextView
    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        
        
        setContentView(R.layout.activity_main)

        etPrecioKilo = findViewById(R.id.etPrecioKilo)
        etPesoGramos = findViewById(R.id.etPesoGramos)
        tvPrecioLista = findViewById(R.id.tvPrecioLista)
        tvPrecioFinal = findViewById(R.id.tvPrecioFinal)
        btnCalcular = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            
            val precioKilo = etPrecioKilo.text.toString().toInt()
            val precioGramos = etPesoGramos.text.toString().toInt()
        
            //Definir el tipo de dato en las variables... (? probar con diferentes TD: Double, Int, ect
            
            val precioLista = precioKilo * precioGramos / 1000
            
            //Modularizar cálculo de descuento
            var descuento = 0.0

            if (precioGramos > 1000) {
                descuento = precioLista * 0.20
            } else if (precioGramos > 500) {
                descuento = precioLista * 0.10
            } else if (precioGramos > 250) {
                descuento = precioLista * 0.05
            }
            

            val precioFinal = precioLista - descuento

            tvPrecioLista.text = "Precio de lista: $precioLista"
            tvPrecioFinal.text = "Precio final con descuento: $precioFinal"
        }
    }
}
