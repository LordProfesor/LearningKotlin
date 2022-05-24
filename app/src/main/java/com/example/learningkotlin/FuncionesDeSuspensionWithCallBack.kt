package com.example.learningkotlin

interface FuncionesDeSuspensionWithCallBack {

    companion object{

        fun doHeavyTaskWithCallBack(time : Int, funcionesDeSuspension: FuncionesDeSuspensionWithCallBack){
            Thread{ //Dentro de un hilo diferente de ejecución no se permite realizar un return
                Thread.sleep(time.toLong())//Usamos el sleep para simular que una tarea tarda en ejecutarse
                funcionesDeSuspension.callback("Respuesta")
            }.start()
        }
    }

    fun callback(respuesta : String)
}