package com.example.miprimeraapp_mov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_b_list_view.*


class BListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_list_view)
        val listaEntrenadores = arrayListOf<RestauranteEntrenador>()
        listaEntrenadores.add(RestauranteEntrenador("Adrian", "Eguez"))
        listaEntrenadores.add(RestauranteEntrenador("Vicente", "Sarzosa"))
        listaEntrenadores.add(RestauranteEntrenador("Wendy", "Moises"))
        listaEntrenadores.add(RestauranteEntrenador("Ivan", "Parra"))
        listaEntrenadores.add(RestauranteEntrenador("Juan", "Duran"))
        listaEntrenadores.add(RestauranteEntrenador("Andrea", "Lara"))
        listaEntrenadores.add(RestauranteEntrenador("Lisa", "Guerrero"))
        val adaptador = ArrayAdapter(
            this, // Contexto
            android.R.layout.simple_list_item_1, // Nombre Layout
            listaEntrenadores // Lista
        )

        lv_numeros.adapter = adaptador
        lv_numeros
            .onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Log.i("list-view", "Posicion $position")
        }
        btn_anadir_entrenador.setOnClickListener {
            anadirEntrenador(adaptador,listaEntrenadores)
        }

    }
    fun anadirEntrenador(adatador:ArrayAdapter<RestauranteEntrenador>,listaEntrenadores:ArrayList<RestauranteEntrenador>){

        listaEntrenadores.add(RestauranteEntrenador("Nuevo","Entrenador"))
        adatador.notifyDataSetChanged()
    }
}
