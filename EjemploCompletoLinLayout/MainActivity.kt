package com.example.linearlayout

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var editTextNombre: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var btnEnviar: Button
    private lateinit var btnCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        editTextNombre = findViewById(R.id.etNombreCompleto)
        editTextEmail = findViewById(R.id.etMail)
        btnEnviar = findViewById(R.id.btEnviar)
        btnCancelar = findViewById(R.id.btCancelar)

        btnEnviar.setOnClickListener {

            val nombreCompleto = editTextNombre.text.toString()
            val email = editTextEmail.text.toString()


            if(nombreCompleto.isEmpty() || email.isEmpty()){

                Toast.makeText(this,"Por favor complete los campos requeridos", Toast.LENGTH_SHORT).show()
            }else{

                Toast.makeText(this,"Se ha enviado:\nNombre: $nombreCompleto \nEmail: $email", Toast.LENGTH_SHORT).show()
            }

        }


        btnCancelar.setOnClickListener{

            editTextNombre.text.clear()
            editTextEmail.text.clear()
            Toast.makeText(this,"Se ha borrado!!", Toast.LENGTH_SHORT).show()

        }



    }
}
