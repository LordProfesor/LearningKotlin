package com.example.learningkotlin

/*
Las clases por defecto son final en kotlin y no se puede herdar de ellas, si queremos poder heredar
habrá que usar el modificador open.
*/
open class Empleado (var nombre : String, var edad : Int, var salario : Float) {

}