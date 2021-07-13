package com.example.learningkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    var testTextView : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val changeTextButton = findViewById<Button>(R.id.changeTextButton)
        val openListViewButton = findViewById<Button>(R.id.openListViewButton)
        testTextView = findViewById<TextView>(R.id.testTextView)

        openListViewButton.setOnClickListener {
            val intent = Intent(applicationContext, ListViewActivity::class.java)
            startActivity(intent)
        }

        //nullableAndNotNullable()
        //strings()
        //arrays()
        //mapsAndHash()
        //testeandoEnums()
        //funciones()
        clases()
        //nestedAndInnerClasses()
        //interfaces()
        //funcionesAnonimas()
        //expresionesLamba()
        botones(changeTextButton)
    }

    /*
    Trabajar tipos nullables y no nullables
    */
    private fun nullableAndNotNullable(){

        //Creación de una variable por defecto (no puede ser nula, no nullable).
        var mi_variable : Int = 0

        //Creación de una variable de tipo nullable
        var mi_variable_nula : String? = null

        //Comprobación de nulos tradicional (Si trabajas con variables nullables, Kotlin te obliga a comprobar siempre las variables)
        if (mi_variable_nula != null){
            mi_variable = mi_variable_nula.length
        }else{
            mi_variable = 0
        }
        //Safety Call (Elvis Operator), lo mismo que antes pero en Kotlin. En caso de ser nula le setea un 0, en caso de no serlo, le asigna la longitud
        mi_variable = mi_variable_nula?.length ?: 0

    /*
    SwitchCase en Kotlin: WHEN
    */
        when (mi_variable_nula?.length){
            0 -> println("Nothing to say?")
            in 1..50 -> println("Perfect")
            else -> println("Too long!")
        }
    }

    /*
    Plantillas para las Strings
    */
    private fun strings(){
        var trucha : String? = "trucha"
        var pescadilla : String? = "pescadilla"
        var pargo : String? = "pargo"
        println("Me gusta mucho la $trucha pero odio la $pescadilla y me da igual el $pargo " )
    }

    /*
    Trabajar con arrays o arreglos
    */
    private fun arrays(){
        val nombre = "Brais" //a diferencia del var, el val sirve para crear constantes en Kotlin.
        val apellido = "Martínez" //gracias a la inferencia de tipos de Kotlin, no es necesario indicar el tipo de dato.
        val edad = "32"

        var datosBrais = arrayListOf<String>()
        datosBrais.add(nombre)
        datosBrais.add(apellido)
        datosBrais.add(edad)
        datosBrais.addAll(listOf<String>("19","Agosto","1988")) //con el método addAll podemos añadir de una única vez varios elementos más al array
        println(datosBrais);

        var primerDatoDelArray = datosBrais.get(0) //En kotlin los arrays empiezan en 0
        datosBrais.removeAt(3) //Con esta linea borramos el elemento que se encuentra en la posición 3 del array
        println(datosBrais);

        for(i in 0 until datosBrais.size) {
            println("Este es uno de los valores que tiene el array: " + datosBrais.get(i))
        }

        datosBrais.forEach {
            println("Este es uno de los valores que tiene el array: " + it); //La variable it contiene cada uno de los valores del array
        }
    }

    /*
    Trabajar con ENUM
    */
    enum class DiasDeLaSemana{
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
    }

    private fun testeandoEnums(){
        var diaDeLaSemana  : DiasDeLaSemana? = null
        println("Esto es lo que contiene la variable días e la semana: $diaDeLaSemana")
        diaDeLaSemana = DiasDeLaSemana.LUNES;
        println("Esto es lo que contiene la variable días e la semana: $diaDeLaSemana")

        println(diaDeLaSemana.name) //con la propiedad name accederemos a la representación en String del valor del enum
        diaDeLaSemana = DiasDeLaSemana.valueOf("LUNES") //de esta manera conseguimos el proceso inverso al anterior, es decir, tranformar una String en un enum del tipo DiasDeLaSemana.
        println(diaDeLaSemana.ordinal) // esta propiedad nos indica numericamente la posicion que ocupa el enum dentro de la colección. En este caso al ser LUNES y estar el primero de la colección, nos devolverá el valor 0.

        var diasDeLaSemana = DiasDeLaSemana.values() //nos devuelve un array de DiasDeLaSemana con todos los posibles valores

        diasDeLaSemana.forEach {
            println(it.name);
        }
    }

    /*
    Trabajar con Maps, hash o diccionarios (clave, valor)
    */
    private fun mapsAndHash(){
        var myMap : Map<String,Int> = mapOf()
        myMap = mutableMapOf("Brais" to 1, "Sara" to 2, "Paula" to 5); //Añadimos valores a nuestro mapa mutable, es decir, un mapa al que posteriormente le podremos añadir nuevos valores
        println(myMap)

        myMap.put ("Marta", 8) //Le añadimos un nuevo valor
        println(myMap)

        println(myMap["Brais"]) //Accedemos a un valor asociado a una determinada clave

        myMap.remove("Brais") //Borramos un determinado valor asociado a una clave
    }

    /*
    Trabajar con funciones
    */
    private fun funciones(){

        fun sayMyNameAndAge(name : String, age : Int){ //Recibe dos parametros de entrada
            println("Este es mi nombre: $name y esta es mi edad: $age" )
        }
        sayMyNameAndAge("Brais",32)

        fun sumTwoNumbers(num1 : Int, num2 : Int) : Int{ //Recibe dos parametros y devolvera uno.
            var resultado : Int = num1 + num2
            return resultado;
        }
        println(sumTwoNumbers(3,2))
    }

    /*
    Trabajar con clases
    */
    private fun clases(){
        var myFirstUser = User("Brais", 32, "32789654", "Alemana",null )
        var mySecondUser = User("Brais", 32, "32700600Z")

        println(myFirstUser.toString())
        println(mySecondUser.toString())

        //Accedemos a una constante de la clase USER
        val constante = User.CODIGO_USUARIOS
        println(constante.toString())
    }

    /*
    Trabajar con clases anidadas (nested) e internas (Inner)
    */
    private fun nestedAndInnerClasses (){
        val myNestedClass = MyNestedAndInnerClass.MyNestedClass()
        println(myNestedClass.sum(3,4))

        val myInnerClass = MyNestedAndInnerClass().MyInnerClass()
        println(myNestedClass.sum(3,4))
    }

    /*
    Trabajar con interfaces y clases heredadas
    */
    private fun interfaces(){
        var lenguajes = arrayListOf<Programador.Lenguajes>()
        lenguajes.add(Programador.Lenguajes.JAVA)
        lenguajes.add(Programador.Lenguajes.KOTLIN)
        var programas = arrayListOf<String>()
        programas.add("Photoshop")
        programas.add("Paint")
        val programador1 = Programador("Brais", 32, 1650f, lenguajes)
        val disenador1 = Disenador ("Virginia", 40, 3000f, programas)
        Log.i("-"," " + programador1.ponerAtrabajar())
        Log.i("-"," " + disenador1.ponerAtrabajar())
    }

    /*
    Trabajar con funciones anonimas
    */
   private fun funcionesAnonimas () {

       //Esto es un hola mundo tradicional
       fun holaMundo(){
           println("Hola Mundo")
       }
       //holaMundo()

       //Cuando las funciones solo tienen una línea de código las podemos simplificar de la siguiente manera
       fun holaMundoAlt() = println("Hola Mundo Alternativo")
       //holaMundoAlt()

       //Las funciones anonimas son funciones que no tienen nombre, por este motivo para ser invocadas tienen que ser asignadas a una variable e invocadas
       val miFuncionAnonima = fun () = println("Hola Mundo Anonimo")
       //miFuncionAnonima.invoke()

       //El siguiente ejemplo muestra cómo obtener un array con todos los numero pares desde 0 a un valor determinado, partiendo de una funcion anonima.
       val multiplicarPorDos = fun (numeroAMultiplicar : Int) : Int = numeroAMultiplicar * 2
       //se puede omitir el return porque este este se da por hecho. De la misma manera podríamos omitir el tipo de dato devuelto, ya que este es inferido.
       val multiplicarPorDosAlt = fun (numeroAMultiplicar : Int) = numeroAMultiplicar * 2

       val arrayDepares = Array(10, multiplicarPorDosAlt) //El segundo parametro del constructor del Array es la funcion anonima usada anteriormente
       val arrayDeparesAlt = Array(10, fun (numeroAMultiplicar : Int) = numeroAMultiplicar * 2)//Se podrías prescindir de la variable y pasar directamente la funcion completa

        arrayDepares.forEach{
            println(it.toString())
        }

        arrayDeparesAlt.forEach{
            println(it.toString())
        }
   }

    /*
    Trabajar con expresiones Lambda : Funciones que pueden trabajar internamente con otras funciones
    */
    fun expresionesLamba(){

        //Siguiendo con el ejemplo anterior, haremos la transformación de la última funcion anonima en una expresion Lambda
        val arrayDeParesAlt = Array(10, {numeroAMultiplicar -> numeroAMultiplicar * 2})
        //Otra manera de hacerlo sería con el parámetro it que sería lo mismo pero hace referencia directamente a cada uno de los valores del array (salvando las distancias, sería algo como this)
        val arrayDeParesAltIt = Array(10, {it * 2})

        arrayDeParesAlt.forEach{
            println(it.toString())
        }

        arrayDeParesAltIt.forEach{
            println(it.toString())
        }

        //Otro ejemplo podría ser un filtrado de los elementos de un Array, en el que a cada uno de los elementos del array tiene que pasar por una determinada funcion de
        //comprobación, es decir, un PREDICADO. Esto nos devolverá un tipo bool para decidir que elementos pasan a la segunda lista.
        var arrayDeEnteros = arrayListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        var myFilterArrayDeEnteros = arrayDeEnteros.filter { it > 5 }

        myFilterArrayDeEnteros.forEach{
            println(it.toString())
        }
    }

    fun botones (button : Button){

        //La manera tradicional de hacer click en un boton tal y como hemos hecho siempre es mediante el uso de la interfaz OnClickLister y la definicion de su método onClick

        /*button.setOnClickListener(object : View.OnClickListener { //object es la representacion que hace kotlin de un objeto genérico. En este caso representa a un objeto de la interfaz OnClickListener
            override fun onClick(v: View?) {
                testTextView?.text = "Hola destructor de mundos"
            }
        })*/

        //Al ser una interfaz funcional, es decir, una interfaz que solo tiene un método a definir, podemos usar notación lambda para representarla.
        //El método onCLick de la interfaz funcional OnClickListener recibe un view por parametro  y no devuelve nada, por lo tanto la expresión Lambda
        //la podemos representar de las siguientes formas:

        /*button.setOnClickListener {button ->
            testTextView?. text = "Hola destructor de mundos lambda"
        }*/

        button.setOnClickListener {
            testTextView?. text = "Hola destructor de mundos lambda"
        }
    }
}






