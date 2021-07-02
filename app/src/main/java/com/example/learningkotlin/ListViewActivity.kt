package com.example.learningkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val listView = findViewById<ListView>(R.id.listViewUsers)

        var myFirstUser = User("Brais", 32, "32789654", "Alemana",null )
        var mySecondUser = User("Ramonin", 38, "32700600Z")
        var myThirdUser = User("Jose Luis", 54, "47896547X")

        var userList = arrayListOf<User>()
        userList.add(myFirstUser)
        userList.add(mySecondUser)
        userList.add(myThirdUser)

        listView.adapter = MyUserAdapter(applicationContext, userList)









    }
}