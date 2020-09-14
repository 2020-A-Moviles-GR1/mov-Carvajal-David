package com.example.miprimeraapp_mov

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback,
GoogleMap.OnCameraMoveCanceledListener,
GoogleMap.OnCameraMoveListener,
GoogleMap.OnCameraIdleListener,
GoogleMap.OnPolylineClickListener,
GoogleMap.OnPolygonClickListener, GoogleMap.OnCameraMoveStartedListener {

    private lateinit var mMap: GoogleMap
    var tienePermisos=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)


        solicitarPermisos()


        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        ///1) permisos

        establecerConfiguracionMapa(mMap)
        establecerListeners(mMap)

        val paseoSanfrancisco = LatLng(-0.198940, -78.436850)
        val puntoUsuario = LatLng(-0.198940, -78.436850)
        val titulo ="paseo San Francisco"
        val zoom = 17f
        anadirMarcador(paseoSanfrancisco,titulo)
        moverCamaraConZoom(puntoUsuario,zoom)


        val poliLineaUno= googleMap.addPolyline(
            PolylineOptions()
                .clickable(true)
                .add(
                    LatLng(-0.203768, -78.449051),
                    LatLng(-0.202566, -78.454641),
                    LatLng(-0.199821, -78.453310),
                    LatLng(-0.200243, -78.446743)
                )
        )
        val poligonoUno = googleMap.addPolygon(
            PolygonOptions()
                .clickable(true)
                .add(
                    LatLng(-0.204863, -78.444095),
                    LatLng(-0.204785, -78.443975),
                    LatLng(-0.205930, -78.443515),
                    LatLng(-0.205784, -78.443204)
                )
        )
        //poligonoUno.fillColor=


        // Add a marker in Sydney and move the camera
        //val sydney = LatLng(-34.0, 151.0)
        //mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    fun moverCamaraConZoom(latLng: LatLng, zoom: Float=10f){
        mMap.moveCamera(
            CameraUpdateFactory
                .newLatLngZoom(latLng, zoom)
        )
    }

    fun anadirMarcador(latLng: LatLng, title: String){

        mMap.addMarker(
            MarkerOptions()
                .position(latLng)
                .title(title)
        )
    }

    fun establecerConfiguracionMapa(mapa:GoogleMap){
        val contexto = this.applicationContext
        with(mapa){
            val permisosFineLocation = ContextCompat
                .checkSelfPermission(
                    contexto,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                )
            val tienePermisos = permisosFineLocation == PackageManager.PERMISSION_GRANTED
            if (tienePermisos){
                mapa.isMyLocationEnabled= true
            }
            uiSettings.isZoomControlsEnabled=true
            uiSettings.isMyLocationButtonEnabled=true
        }
    }


    fun solicitarPermisos(){
        val permisosFineLocation = ContextCompat
            .checkSelfPermission(
            this.applicationContext,
            Manifest.permission.ACCESS_FINE_LOCATION

        )
      val tienePermisos = permisosFineLocation == PackageManager.PERMISSION_GRANTED
        if (tienePermisos){
            Log.i("Mapa","Tiene permisos Fine LOCATION")

            this.tienePermisos=true

        }else{
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION
                ),
                1 //codigo que esperamos.
            )

        }
    }
    fun establecerListeners(map: GoogleMap){
        with(map){
            setOnCameraIdleListener(this@MapsActivity)
            setOnCameraMoveStartedListener(this@MapsActivity)
            setOnCameraMoveListener(this@MapsActivity)
            setOnPolylineClickListener(this@MapsActivity)
            setOnPolygonClickListener(this@MapsActivity)
        }
    }

    override fun onCameraMoveCanceled() {
        Log.i("mapa","Empezando a mover onCameraMoveStarted")
    }

    override fun onCameraMove() {
        Log.i("mapa","Moviendo onCameraMove")
    }

    override fun onCameraIdle() {
        Log.i("mapa", "Quieto onCmaedaIdle")
    }

    override fun onPolylineClick(p0: Polyline?) {
        Log.i("mapa", "PolyLinea ${p0.toString()}")
    }

    override fun onPolygonClick(p0: Polygon?) {
        Log.i("mapa","Polugono ${p0.toString()}")
    }

   override fun onCameraMoveStarted(p0: Int) {
        Log.i("mapa", "Moviendo onCameraMoveStaeted")
    }


}