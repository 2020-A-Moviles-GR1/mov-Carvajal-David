package com.example.restaurante

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import com.example.restaurante.adapter.PlatoAdapter
import com.example.restaurante.clases.CrearPlatoHttp
import com.example.restaurante.clases.PlatoHttp
import com.example.restaurante.services.PlatoService

class eliminarPlato : AppCompatActivity() {
    private lateinit var listViewPlatos: ListView;
    private var listaPlatos: ArrayList<PlatoHttp> = ArrayList<PlatoHttp>();
    private var TAG = "ELIMINAR_PLATO";
    private var mBound: Boolean = false;
    private lateinit var platoService: PlatoService;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eliminar_plato);

        listViewPlatos = findViewById(R.id.listViewEliminar) as ListView;

        listViewPlatos.setOnItemClickListener { parent, view, position, id ->
            try{
                val plato = listaPlatos.get(position);
                eliminarPlato(plato.id);
            } catch (e: java.lang.Exception){ }
        }
    }

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            val binder = service as PlatoService.LocalBinder
            platoService = binder.getService()
            mBound = true;
            listaPlatos = platoService.getAll();
            cargarList(listaPlatos);
        }


        override fun onServiceDisconnected(arg0: ComponentName) {
            mBound = false
        }
    }

    override fun onStart() {
        super.onStart()
        Intent(this, PlatoService::class.java).also { intent ->
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
    }

    override fun onStop() {
        super.onStop()
        unbindService(connection)
        mBound = false
    }

    fun cargarList(listaPlatos: ArrayList<PlatoHttp>) {
        val adapter = PlatoAdapter(this, listaPlatos);
        try {
            listViewPlatos.adapter = adapter
        } catch (e: Exception) {
            Log.i(TAG, "error: ${e}");
        }
    }

    fun eliminarPlato (id: Int){
        var platoActualizado: PlatoHttp? = platoService.delete(id);
            if (platoActualizado != null) {
            if (!listaPlatos.isEmpty()) {
                var index: Int = -1;
                listaPlatos.forEachIndexed { ind, platoHttp ->
                    if (platoHttp.id == platoActualizado?.id) {
                        index = ind;
                        return@forEachIndexed
                    }
                };
                if (index != -1) {
                    listaPlatos.removeAt(index);
                    cargarList(listaPlatos);
                };

            }
            Toast.makeText(this, "Plato eliminado correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Plato no eliminado", Toast.LENGTH_SHORT).show();
        }
    }


}