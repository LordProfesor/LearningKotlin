package com.example.learningkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val listView = findViewById<ListView>(R.id.listViewUsers)

        //Array personalizado
        var myFirstUser = User("Brais", 32, "32789654", "Alemana",null )
        var mySecondUser = User("Ramonin", 38, "32700600Z")
        var myThirdUser = User("Jose Luis", 54, "47896547X")


        var userList = arrayListOf<User>()
        userList.add(myFirstUser)
        userList.add(mySecondUser)
        userList.add(myThirdUser)
        userList.add(myFirstUser)
        userList.add(mySecondUser)
        userList.add(myThirdUser)
        userList.add(myFirstUser)
        userList.add(mySecondUser)
        userList.add(myThirdUser)

        listView.adapter = MyUserAdapter(applicationContext, R.layout.item_list_view_user, userList)
        listView.emptyView = findViewById<TextView>(R.id.emptyElement) //Aquí seteamos la vista que queremos que aparezca en caso de que el listado esté vacio.

        //Array estandar (sin personalizar)
     /*   var frutas = arrayListOf<String>()
        frutas.add("Fresas")
        frutas.add("Arándanos")
        frutas.add("Kiwis")
        frutas.add("Moras")
        frutas.add("Frambuesas")
        listView.adapter = ArrayAdapter<String>(applicationContext, android.R.layout.simple_list_item_1, frutas)*/

    }
}