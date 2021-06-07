package com.example.learningkotlin

/*La clase programador hereda de la clase Empleado e implementa la interfaz trabajadores la cual nos obliga a
definir el método ponerAtrabajar*/
class Programador(nombre : String, edad : Int, salario : Float, lenguajes : ArrayList<Lenguajes> )
        :Empleado(nombre, edad, salario), Trabajadores {

    enum class Lenguajes{
        JAVA, KOTLIN, C,
    }

    override fun ponerAtrabajar() : String {
        return ("El programador $nombre está programando")
    }
}