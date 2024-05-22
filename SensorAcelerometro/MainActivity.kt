package com.example.inclinometro

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), SensorEventListener {

    //Inicializamos el snesor manager para obtener los sensores del sistema
    private lateinit var sensorManager: SensorManager

    //Variable para utilizar el acelerometro
    private var acelerometro: Sensor? = null

    private lateinit var tvEjeX: TextView
    private lateinit var tvEjeY: TextView
    private lateinit var tvEjeZ: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        tvEjeX = findViewById(R.id.ejeEquis)
        tvEjeY = findViewById(R.id.ejeyGriega)
        tvEjeZ = findViewById(R.id.ejeZeta)

        //Acceder a los métodos del sistema, en este caso de los sensores.
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        //Recibe la constat
        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        if(acelerometro != null) {

            sensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_NORMAL)

        }
    }

    override fun onSensorChanged(event: SensorEvent){

        if(event.sensor.type == Sensor.TYPE_ACCELEROMETER){
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]

            tvEjeX.text = "Eje X: $x"
            tvEjeY.text = "Eje X: $y"
            tvEjeZ.text = "Eje X: $z"
        }

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        TODO("Not yet implemented")
    }
}
