package com.example.miprimeraapp_mov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviles.RecyclerAdaptador
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.android.synthetic.main.adaptador_persona.*

class RecyclerViewActivity : AppCompatActivity() {
    var numeroLikes =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val listaUsuario = arrayListOf<UsuarioHttp>()
        listaUsuario.add(
            UsuarioHttp(
                1,
                123123154,
                131317415,
                "172472937",
                "David",
                "davjh@gmail.com",
                "Soltero",
                "123456",
                arrayListOf<PokemonHttp>()

            )
        )
        listaUsuario.add(
            UsuarioHttp(
                2,
                123123154,
                131317415,
                "0524729325",
                "Luis",
                "luis@gmail.com",
                "Casado",
                "252525",
                arrayListOf<PokemonHttp>()

            )
        )
        listaUsuario.add(
            UsuarioHttp(
                3,
                123123154,
                131317415,
                "122472915",
                "Carlos",
                "carlos@gmail.com",
                "Divorciado",
                "696969",
                arrayListOf<PokemonHttp>()

            )
        )
        iniciarRecyclerView(
            listaUsuario,
            this,
            rv_usuarios
        )
    }
    fun  iniciarRecyclerView(
        lista : List<UsuarioHttp>,
        actividad: RecyclerViewActivity,
        recycler_view: androidx.recyclerview.widget.RecyclerView
    ){
        val adaptadorUsuario = RecyclerAdaptador(
            lista,
            actividad,
            recycler_view
        )
        rv_usuarios.adapter = adaptadorUsuario
        rv_usuarios.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        rv_usuarios.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(actividad)
        adaptadorUsuario.notifyDataSetChanged()
    }
    fun anadirLikesEnActividad(numero: Int){
        this.numeroLikes = this.numeroLikes + numero
        tv_titulo_rv.text = numeroLikes.toString()
    }
}