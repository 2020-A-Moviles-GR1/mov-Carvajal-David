import java.util.*

fun main(args:Array<String>)
{

    print("Hola")

}

    //como inicializar variables
    //exsiten 2 tipos de variables en ktlin:
    //variables mutables o reasignada:
    //variables Inmutables:
    //ambas son redes decllaradas pero no se pueden igualar o inicializar
    // de preferencia se utiliza inmutable, para que el codigo sea mantenible en el tiempo!!
    var edadProfesor =31// a qui no se especifica el tipo de dato
                        // ; no es necesario
                        //Duck typing
                        //var edadcachorro: x-> necesitamos el tipo de datos
    var dedadCachorro:Int
    dedadCachorro=3

    //Inmutables.-No se pueden reasignar
    val numeroCuenta=123456
    numeroCuenta=12345

    val nombreProfesor= "David Carvajal"
    val sueldo =4.20
    val apellidoProfesor='C'
    val fechaNacimiento = Date()

    //comparaciones

    if(sueldo==4.20)
    {

    }else
    {

    }

    when (sueldo){ //permite hacer varia concatenaciones
        //casos
        4.20-> print("Sueldo vitalicio")
        -4.20 -> print("Sueldo de Bajon")
        //
        else-> println("no se reconoce el sueldo")
    }

    val EsSueldoMayorAlEstablecido = if(sueldo==12.20)true else false

    //FUNCIONES
    calcularSueldo(1000.00,14.00)

    //parametros nombrados,
    
   fun calcularSueldo(
            tasa:Double =16.00,    //requeridos
            sueldo:Double=800.00,   //tiene valor por defecto
            calculoEspecial: Int?=null   //pueden ser null
    ):Double {
        if(calculoEspecial!=null){
            return sueldo * tasa * calculoEspecial
        }else{
            return  sueldo * tasa
        }

    }

    fun calcularSueldo (sueldo: Double, tasa:Double):Int
    {//para retornar la variable que necesitamos //
    return 10
    }
    fun imprimirMensaje():Unit{
        //unit=void
        print("")

    }


}

