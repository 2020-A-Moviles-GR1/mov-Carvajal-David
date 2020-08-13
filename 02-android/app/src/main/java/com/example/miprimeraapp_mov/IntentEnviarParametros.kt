package com.example.miprimeraapp_mov

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent_enviar_parametros.*

class IntentEnviarParametros : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_enviar_parametros)

        //propiedad, Clase Intent

        val numeroEncontrado = intent.getIntExtra("numero", 0)
        if(numeroEncontrado !=0) {
            Log.i("intents", "el numero encontrado es:${numeroEncontrado} ")
        }

        val textoCompartido : String? = intent.getStringExtra(Intent.EXTRA_TEXT)
        if (textoCompartido !=null){
            Log.i("intents","el texto es: ${textoCompartido}")
        }


        val cachetes = intent.getParcelableExtra<Mascota>("cachetes")
        if(cachetes != null){
            Log.i("parcelable", "${cachetes.nombre} ${cachetes.duenio?.nombre}")
        }

        val arregloMascotas = intent.getParcelableArrayListExtra<Mascota>("arregloMascotas")
        if(arregloMascotas != null){
            arregloMascotas.forEach {
                Log.i("parcelable", "EN ARREGLO")
                Log.i("parcelable", "${cachetes.nombre} ${cachetes.duenio?.nombre}")
            }

        }

        btn_devolver_respuesta.setOnClickListener {
            //Metodo Clase
            //this.finish()
            finish() }

        btn_resp_aceptar.setOnClickListener {
            val nombre="David "
            val edad = "25"
            val intentRespuesta = Intent()
            intentRespuesta.putExtra("name", nombre)
            intentRespuesta.putExtra("edad", edad)
            setResult(
                Activity.RESULT_OK,intentRespuesta
            )
            finish()
        }

        btn_rep_cancelar.setOnClickListener {
            val intentCancelado=Intent()
            setResult(
                Activity.RESULT_CANCELED,intentCancelado
            )
            finish()
        }

    }
}
