package ar.edu.angulos

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var etAngulo: EditText
    private lateinit var boton: Button
    private lateinit var tvResultado: TextView
    private lateinit var rbGRados: RadioButton
    private lateinit var rbRadianes: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        etAngulo = findViewById(R.id.etAngulo)
        boton = findViewById(R.id.btConvertir)
        tvResultado = findViewById(R.id.tvResultado)
        rbGRados = findViewById(R.id.rbGrados)
        rbRadianes = findViewById(R.id.rbRad)

        boton.setOnClickListener{

            convertir()

        }

    }

    private fun convertir() {

        val anguloString = etAngulo.text.toString()

        if(anguloString.isEmpty()) {

            tvResultado.text = "Ingrese un valor!"
            return
        }

        val anguloDouble = anguloString.toDouble()

        val resultado: Double = if (rbGRados.isChecked){

                anguloDouble.aRadianes()

        }else{

            
            return
        }

        tvResultado.text = "Resultado: $resultado"

    }

    fun Double.aRadianes(): Double {

        return this*Math.PI/180

    }
}
