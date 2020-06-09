package com.example.a0609

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SensorEventListener {

    lateinit var sm : SensorManager
    lateinit var acc : Sensor
    lateinit var mag : Sensor




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sm=getSystemService(SENSOR_SERVICE) as SensorManager
        acc=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        mag = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)


    }


    override fun onResume() {
        super.onResume()

        sm.registerListener(this,acc,SensorManager.SENSOR_DELAY_GAME)
        sm.registerListener(this,mag,SensorManager.SENSOR_DELAY_GAME)


    }

    override fun onPause(){
        super.onPause()

        sm.unregisterListener(this,acc)
        sm.unregisterListener(this, mag)


    }


    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
// TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSensorChanged(p0: SensorEvent?) {
//TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        when(p0!!.sensor.type){

            Sensor.TYPE_ACCELEROMETER->{

            acc1.text=p0!!.values[0].toString()
            acc2.text=p0!!.values[1].toString()
            acc3.text=p0!!.values[2].toString()
        }

            Sensor.TYPE_MAGNETIC_FIELD->{

            mag1.text =p0!!.values[0].toString()
            mag2.text =p0!!.values[1].toString()
            mag3.text =p0!!.values[2].toString()
        }

        }


    }


}