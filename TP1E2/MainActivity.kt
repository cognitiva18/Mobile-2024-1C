package ar.edu.paroimpar

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity





class MainActivity : AppCompatActivity() {

    private lateinit var etNumeroUno: EditText
    private lateinit var etNumeroDos: EditText
    private lateinit var tvResultado: TextView
    private lateinit var btDeterminar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

        etNumeroUno = findViewById(R.id.etNumeroUno)
        etNumeroDos = findViewById(R.id.etNumeroDos)
        tvResultado = findViewById(R.id.tvResultado)
        btDeterminar = findViewById(R.id.btDeterminar)

        tvResultado.text = "Estoy inicilizado en onCreate"

        btDeterminar.setOnClickListener {

            val num1 = etNumeroUno.text.toString().toInt()
            val num2 = etNumeroDos.text.toString().toInt()

            if(num1 % num2 == 0){
                tvResultado.text = "Es múltiplo"
            }else{

                tvResultado.text = "No es múltiplo"
            }


        }



    }
}
