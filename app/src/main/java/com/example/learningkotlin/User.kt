package com.example.learningkotlin

//En la propia declaracion de la clase ya va tambien el constructor
data class User(var nombre : String, var edad : Int, var dni : String,
                var nacionalidad : String, var amigos : ArrayList<User>?){

    constructor(nombre : String, edad : Int, dni : String) : this(nombre, edad, dni, "Española", null) {

    }


}
