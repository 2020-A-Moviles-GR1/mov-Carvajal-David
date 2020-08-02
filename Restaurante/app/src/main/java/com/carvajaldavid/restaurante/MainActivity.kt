package com.carvajaldavid.restaurante
import android.app.AlertDialog
import android.content.DialogInterface
import java.io.OutputStreamWriter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //agregar
        btnadd.setOnClickListener{
            val ingredientes= DataCompanion.generarIngredientes();
            val receta: Array<Receta?> = DataCompanion.generarReceta();
            guardarData(ingredientes,receta);
            Toast.makeText(this,
                "Se a generado las 5 recetas y 5 ingredientes", Toast.LENGTH_SHORT).show();



        }

        btnUpdate.setOnClickListener{
            val ingredientes= DataCompanion.actualizarIngredientes();
            val receta: Array<Receta?> = DataCompanion.actualizarReceta();
            guardarData(ingredientes,receta);
            Toast.makeText(this,
                "Se a actualizado el ingrediente con ID 5 y la receta con ID 4", Toast.LENGTH_SHORT).show();
        }
        //borrar
        btnDelete.setOnClickListener{
            DataCompanion.eliminarDatos()
            val outputStreamWriter = OutputStreamWriter(
                openFileOutput("pruebaIngredientes.txt", MODE_PRIVATE)
            )
            outputStreamWriter.write("")
            outputStreamWriter.close()
            val outputStreamWriterR = OutputStreamWriter(
                openFileOutput("pruebaReceta.txt", MODE_PRIVATE)
            )

            outputStreamWriterR.write("")
            outputStreamWriterR.close()
            Toast.makeText(this,
                "Se a eliminado las recetas e ingredientes", Toast.LENGTH_SHORT).show();

        }
        //ver
        btnView.setOnClickListener{
            val ingredientes= DataCompanion.leerIngredientes();
            val receta: Array<Receta?> = DataCompanion.leerRecetas();
            var recetas:String?;
            var ingrediente:String?;
            var message:String?;
            recetas = "Recetas\n";
            ingrediente = "Ingredientes\n";
            for (rece in receta ){
                if (rece != null) {
                    recetas = " "+ recetas + " ID: "+rece.id+"  Nombre:"+ rece.nombre+"\n"
                }else{
                    recetas = "No se ha generado recetas"
                }

            }
            for (ingre in ingredientes ){
                if (ingre != null) {
                    ingrediente = " "+ ingrediente + " ID: "+ingre.id+"  Nombre:"+ ingre.nombre+"\n"
                }else{
                    ingrediente = "No se ha generado ingredientes"
                }

            }
            message = recetas+"\n"+ingrediente

            val dialogBuilder = AlertDialog.Builder(this).setIcon(
                android.R.drawable.ic_dialog_alert)
            dialogBuilder.setTitle("Recetas e ingredients")

            dialogBuilder.setMessage(message)
            dialogBuilder.setPositiveButton("Accept", DialogInterface.OnClickListener { _, _ ->
               
            })
            //respuesta negativa
            dialogBuilder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->
                //pass
            })
            dialogBuilder.create().show()



        }

    }

    private fun guardarData(ingredientes: Array<Ingredientes?>,receta: Array<Receta?> ){

        try {
            val outputStreamWriter = OutputStreamWriter(
                openFileOutput("pruebaReceta.txt", MODE_PRIVATE)
            )
            for( rece in receta ){
                if (rece != null) {
                    outputStreamWriter.write(""+ rece.id.toString())
                    outputStreamWriter.write(","+ rece.nombre.toString())

                    outputStreamWriter.write(","+ rece.numeroIngredientes.toString())
                    outputStreamWriter.write(","+ rece.fechaRealiza.toString())
                    outputStreamWriter.write(","+ rece.tiempo.toString())
                    outputStreamWriter.write("\n")
                }


            }
            outputStreamWriter.close()



        } catch (e: Exception) {
            e.printStackTrace()
        }
        try {
            val outputStreamWriterI = OutputStreamWriter(
                openFileOutput("pruebaIngredientes.txt", MODE_PRIVATE)
            )
            for( ingrediente in ingredientes ){
                if (ingrediente != null) {

                    outputStreamWriterI.write(""+ ingrediente.id.toString())
                    outputStreamWriterI.write(","+ ingrediente.nombre.toString())

                    outputStreamWriterI.write(","+ ingrediente.peso.toString())
                    outputStreamWriterI.write(","+ ingrediente.cantidad.toString())
                    outputStreamWriterI.write(","+ ingrediente.existencia.toString())
                    outputStreamWriterI.write("\n")
                }


            }
            outputStreamWriterI.close()



        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}