package com.example.learningkotlin

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class MyUserAdapter(context: Context, resource: Int, objects: Array<User>)
    : ArrayAdapter<User>(context,resource,objects) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {






        return super.getView(position, convertView, parent)
    }

}