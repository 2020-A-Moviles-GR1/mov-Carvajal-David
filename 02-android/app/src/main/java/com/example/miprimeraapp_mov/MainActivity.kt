package com.example.miprimeraapp_mov

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("Activity", "OnCreate")

        btn_ciclo_vida.setOnClickListener { boton -> irCicloDeVida() } //tambien se puede utilizar this.irciclodeVida

        btn_ciclo_vida.setOnClickListener { boton -> irListView() } //tambien se puede utilizar this.irciclodeVida

        btn_list_view.setOnClickListener { boton -> irListView() }

        btn_intent_respuesta.setOnClickListener { irAIntentConRespuestas() }

        btn_intent_implicito.setOnClickListener { enviarIntentConRespuesta() }

        btn_resp_propia.setOnClickListener { enviarIntentConRespuesta() }

    }

    fun enviarIntentConRespuestaPropia(){
        val intenetExplicito = Intent(
            this, IntentEnviarParametros:: class.java
        )
        startActivityForResult(intenetExplicito, 421)
    }

    fun enviarIntentConRespuesta(){
        val intentConRespuesta = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
        //this.startActivityForResult(intent, codigoRespuesta 420)
        //420 los pusimos nostros, no es ningun numero en especial
        this.startActivityForResult(intentConRespuesta, 420)


    }
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(resultCode){
            Activity.RESULT_OK ->{

                Log.i("resultado","okok")

                when(requestCode){
                    420->{...}
                    421->{
                   // val  uri =data?.data
                    //if (uri != null)
                    if (data!=null)
                    {
                        //val cursor = contentResolver.query(uri, null, null, null, null, null)
                        val nombre = data.getStringArrayExtra("nombre")
                        val edad =data.getIntExtra("edad",0)
                        Log.i("resultado","nombre: ${nombre} Edad${edad}")
                       // cursor?.moveToFirst()
                       /* val indiceTelefono = cursor?.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.NUMBER
                        )
                        val telefono = cursor?.getString(indiceTelefono!!)
                        cursor?.close()
                        Log.i("resultado", "Telefono: ${telefono}")*/
                    }
                }
                }
            }
            Activity.RESULT_CANCELED ->{
                Log.i("resultado", "ella No te ama")
            }
        }
    }

    fun irAIntentConRespuestas(){
        val intenetExplicito = Intent(
            this, IntentEnviarParametros:: class.java
        )
        intenetExplicito.putExtra("numero", 420)
        startActivity(intenetExplicito)
    }

    fun irListView(){
        val intentExplicito = Intent(
            this,BListViewActivity::class.java
        )
        //this.startActivity(intentExplicito)
        startActivity(intentExplicito)
    }


    fun irCicloDeVida() {
        val intentExplicito = Intent(

            this,
            CicloVida::class.java
        )

        //this.startActivity(intentExplicito)
        startActivity(intentExplicito) //metodo dentro de la clase que estamos utilizando para ir a la otra actividad
    }

}


