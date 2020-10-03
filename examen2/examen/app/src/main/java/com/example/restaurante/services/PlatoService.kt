package com.example.restaurante.services

import android.app.Service
import android.content.ComponentCallbacks
import android.content.Intent
import android.media.session.MediaSession
import android.os.Binder
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import com.beust.klaxon.Klaxon
import com.example.restaurante.clases.CrearPlatoHttp
import com.example.restaurante.clases.PlatoHttp
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.await
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.fuel.httpPut
import com.github.kittinunf.result.Result
import kotlinx.coroutines.flow.callbackFlow
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.log
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass


class PlatoService : Service() {

    private var TAG = "SERVICE_PLATO";
    private val binder = LocalBinder();
    private val urlPrincipal = "http://192.168.43.87:1337";

    private val mGenerator = Random();

    val randomNumber: Int
        get() = mGenerator.nextInt(100)

    fun getAll(): ArrayList<PlatoHttp> {
        val url = this.urlPrincipal + "/plato"
        var listaPlatos = ArrayList<PlatoHttp>();
        val asynUrl = url.httpGet()
            .responseString { req, res, result ->
                when (result) {
                    is Result.Failure -> {
                        val error = result.getException()
                        Log.i(TAG, "error ${error}")
                    }
                    is Result.Success -> {
                        val data = result.get();
                        val objetoPlatos = Klaxon().parseArray<PlatoHttp>(data);
                        if (objetoPlatos != null) {
                            objetoPlatos.forEach {
                                listaPlatos.add(it);
                            }
                        }
                    }
                }
            }
        asynUrl.join();
        return listaPlatos;
    }

    fun getId(id: Int): PlatoHttp? {
        val url = this.urlPrincipal + "/plato" + "/" + id;
        var getPlato: PlatoHttp? = null;
        val asynUrl =  url.httpGet()
            .responseString { req, res, result ->
            when (result) {
                is Result.Failure -> { }
                is Result.Success -> {
                    val data = result.get();
                    val objetoPlatos = Klaxon().parse<PlatoHttp>(data);
                    if (objetoPlatos != null) {
                        getPlato = objetoPlatos;
                    }
                }
            }
        }
        asynUrl.join();
        return getPlato;
    }

    fun create(objeto: CrearPlatoHttp): PlatoHttp? {
        val parametrosPlato: List<Pair<String, Any>> = listOf(
            "nombre" to objeto.nombre,
            "precioUnitario" to objeto.precioUnitario,
            "latitud" to objeto.latitud,
            "longitud" to objeto.longitud,
            "url" to objeto.url,
            "urlImagen" to objeto.urlImagen
        )
        var getPlato: PlatoHttp? = null;
        val url = this.urlPrincipal + "/plato"
        val asynUrl =  url.httpPost(parametrosPlato)
            .responseString { req, res, result ->
                when (result) {
                    is Result.Failure -> {
                    }
                    is Result.Success -> {
                        val data = result.get();
                        try{
                            val objetoPlatos = Klaxon().parse<PlatoHttp>(data);
                            if (objetoPlatos != null) {
                                getPlato = objetoPlatos;
                            }
                        }catch (e: Exception){
                            Log.i(TAG, e.toString());
                        }
                    }
                }
            }
        asynUrl.join();
        return getPlato;
    }

    fun update(id: Int, parametros: CrearPlatoHttp): PlatoHttp? {
        val parametrosPlato: List<Pair<String, Any>> = listOf(
            "nombre" to parametros.nombre,
            "precioUnitario" to parametros.precioUnitario,
            "latitud" to parametros.latitud,
            "longitud" to parametros.longitud,
            "url" to parametros.url,
            "urlImagen" to parametros.urlImagen
        )
        var getPlato: PlatoHttp? = null;
        val url = this.urlPrincipal + "/plato" + "/" + id;
        val asynUrl =  url.httpPut(parametrosPlato)
            .responseString { req, res, result ->
                when (result) {
                    is Result.Failure -> { }
                    is Result.Success -> {
                        val data = result.get();
                        val objetoPlatos = Klaxon().parse<PlatoHttp>(data);
                        if (objetoPlatos != null) {
                            getPlato = objetoPlatos;
                        }
                    }
                }
            }
        asynUrl.join();
        return getPlato;
    }

    fun delete(id: Int): PlatoHttp? {
        var getPlato: PlatoHttp? = null;
        val url = this.urlPrincipal + "/plato" + "/" + id;
        val asynUrl =  url.httpDelete()
            .responseString { req, res, result ->
                when (result) {
                    is Result.Failure -> { }
                    is Result.Success -> {
                        val data = result.get();
                        val objetoPlatos = Klaxon().parse<PlatoHttp>(data);
                        if (objetoPlatos != null) {
                            getPlato = objetoPlatos;
                        }
                    }
                }
            }
        asynUrl.join();
        return getPlato;
    }

    inner class LocalBinder: Binder(){
        fun getService(): PlatoService {
            return this@PlatoService
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return binder;
    }
}
