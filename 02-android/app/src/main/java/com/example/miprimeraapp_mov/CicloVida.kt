package com.example.miprimeraapp_mov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_ciclo_vida.*

class CicloVida : AppCompatActivity() {

    var numeroActual = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciclo_vida)
        Log.i("Activity",ServicioBDDMemoria.numero.toString())
        if(numeroActual !=0){
            tv_numero.text = numeroActual.toString()
        }
        numeroActual=ServicioBDDMemoria.numero

        btn_Anadir.setOnClickListener {
            sumaUnValor() }

    }

    fun sumaUnValor(){
        numeroActual = numeroActual + 1
        ServicioBDDMemoria.anadirNumero()
        tv_numero.text = numeroActual.toString()
    }

    override fun onStart() {
        super.onStart()
        Log.i("Activity","OnStrat")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Activity","OnRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Activity", "OnResume")
    }

    override fun onPause(){
        super.onPause()
        Log.i("Activity", "OnPause")
    }

    override fun onStop(){
        super.onStop()
        Log.i("Activity", "OnStop")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.i("Activity", "OnDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle
    ) {
        Log.i("Activity", "onSaveInstanceState")
        outState?.run {
            putInt("NumeroActualGuardado",numeroActual)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle
    ) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("Activity","onRestoreInstaceState")
        val valorRecuperado = savedInstanceState
            ?.getInt("numerActualGuardado")
        if(valorRecuperado !=null){
            this.numeroActual = valorRecuperado
            tv_numero.text=this.numeroActual.toString()
        }

    }
}




