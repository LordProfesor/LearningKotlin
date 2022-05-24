package com.example.learningkotlin

class FuncionesDeSuspensionWithLambda {

    companion object{

        //Esta función recibe por parámetro un valor de tiempo y una función que a su vez recibe por parametro
        //una string y no devuelve nada. Esta función la recibimos por parámetro para poder retornar a quien nos
        //ha llamado. Esto sería como el callback de JAVA que en Kotlin nos lo podemos ahorrar al permitir este tipo
        //de mecanismos.
        fun doHeavyTaskWithLambda (time : Int, resultado : (String) -> Unit){
            Thread{
                Thread.sleep(time.toLong())
                resultado("Respuesta")
            }.start()
        }
    }
}