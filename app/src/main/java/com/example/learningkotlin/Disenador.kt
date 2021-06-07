package com.example.learningkotlin

/*La clase diseñador hereda de la clase Empleado e implementa la interfaz trabajadores la cual nos obliga a
definir el método ponerAtrabajar*/
class Disenador(nombre : String, edad : Int, salario : Float, var programas : ArrayList<String>)
    :Empleado(nombre, edad, salario), Trabajadores {

    override fun ponerAtrabajar() : String{
        return ("El disenador $nombre está diseñando")
    }
}