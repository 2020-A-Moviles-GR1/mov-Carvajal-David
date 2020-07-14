package com.example.miprimeraapp_mov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_b_list_view.*

class BListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_list_view)
        val listaEntrenador = arrayListOf<RestauranteEntrenador>()

        listaEntrenador.add(RestauranteEntrenador("David", "Carvajal"))
        listaEntrenador.add(RestauranteEntrenador("Rober", "Sulca"))
        listaEntrenador.add(RestauranteEntrenador("Dario", "Pilca"))
        listaEntrenador.add(RestauranteEntrenador("Adrian", "Andaluz"))
        listaEntrenador.add(RestauranteEntrenador("Esteban", "Sarmiento"))
        listaEntrenador.add(RestauranteEntrenador("Darwin", "Zulca"))
        listaEntrenador.add(RestauranteEntrenador("Juan", "Ramirez"))
        listaEntrenador.add(RestauranteEntrenador("Issac", "Tuquerres"))

        val adaptador = ArrayAdapter(
            this,android.R.layout.simple_list_item_1

        )
        lv_numeros.adapter=adaptador
        lv_numeros
            .onItemClickList{

            }
    }
}
