package com.example.learningkotlin

//En la propia declaracion de la clase ya va tambien el constructor
data class User(var nombre : String, var edad : Int){

    //Aquí tendríamos un segundo constructor usando los parametros del primer constructor y con un parametro extra.
   constructor(nombre : String, edad : Int, dni : String): this(nombre, edad){

   }

    //Aquí tendríamos un tercer constructor usando los parametros del primer constructor, del segundo y con un parametro extra que además puede ser nulo.
    constructor(nombre : String, edad : Int, dni : String, amigos : Array<User>?): this(nombre, edad, dni){

    }

    //Aquí tendríamos un cuarto constructor usando los parametros del primer constructor, del segundo, del tercero y con un parametro extra que por defecto será "Española"
    constructor(nombre : String, edad : Int, dni : String, amigos : Array<User>?, nacionalidad : String = "Española"): this(nombre, edad, dni, amigos){

    }
}
