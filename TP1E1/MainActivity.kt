package ar.edu.ifts18

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //Establecer los atributos
    //lateinit retrasar la inicialización de la variable

    private lateinit var etNumero: EditText
    private lateinit var boton: Button
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        //Tomo las propiedades definidas a nivel clase y busco por id en el layout activtymain
        etNumero = findViewById(R.id.ingresoNumero)
        boton = findViewById(R.id.btnProc)
        tvResultado = findViewById(R.id.tvResultado)

        boton.setOnClickListener {

            val numeroString = etNumero.text.toString()

            if(numeroString.isNotEmpty() && numeroString.esNumero()) {

                val numero = numeroString.toInt()


                 if (esParOimpar(numero)) {

                     //Agarrá el texview, la propiedad text y ponele lo que te paso...
                    tvResultado.text = "$numero es par"


                }else{
                    tvResultado.text = "$numero es impar"
                }


            }else{

                tvResultado.text = "Ingrese un dato valido por favor!!"
            }


        }



    }


    private fun esParOimpar(num: Int): Boolean {
        return num % 2 == 0
    }

    //Función que determina si es numérico
    private fun String.esNumero(): Boolean{

        //Primero hace lo que esta en el try, y luego si no "puede", pasa al catch
        return try {

            this.toInt()
            true

        }catch (e: NumberFormatException){

            false
        }

    }
}
