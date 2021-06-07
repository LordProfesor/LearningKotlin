package com.example.learningkotlin

class MyNestedAndInnerClass {

    private val one = 1

    //Clase anidadada (Nested Class)
    class MyNestedClass(){
        //La constante uno, no será accesible desde esta clase, ya que se encuetra fuera
        //del ambito de la misma
        fun sum (first : Int, second : Int ) : Int{
            return first + second;
        }
    }

    //Clase interna (Inner Class)
    inner class MyInnerClass(){
        //En este caso, sí podemos acceder a la constante uno, ya que hemos declarado la
        //clase como interna y por lo tanto podrá acceder a los atributos de la clase superior.
        fun sumOne(number : Int) : Int{
            return number + one
        }
    }
}