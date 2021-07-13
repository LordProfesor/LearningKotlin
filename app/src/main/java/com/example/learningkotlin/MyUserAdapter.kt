package com.example.learningkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

//El XML del item se puede pasar en el constructor de class MyUserAdapter. En vez de eso como en
//este caso el XML va a ser siempre el mismo. Se lo paso directamente al constructor del ArrayAdapter.
class MyUserAdapter(context: Context, private val userList: ArrayList<User>)
    : ArrayAdapter<User>(context, R.layout.item_list_view_user, userList) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //CUIDADO AQUI HAY QUE DARLE UNA REVISION PORQUE NO TENGO CLARO SI USAR EL PARAMETRO CONVERTVIEW!!!!!!!!!!!!!!!!
        val inflater = LayoutInflater.from(context)
        val currentListItem = inflater.inflate(R.layout.item_list_view_user, null)

        val imageView = currentListItem.findViewById<ImageView>(R.id.imageViewUser)
        val textViewName = currentListItem.findViewById<TextView>(R.id.textViewName)
        val textViewNacionality = currentListItem.findViewById<TextView>(R.id.textViewNacionality)

        imageView.setImageResource(R.drawable.user)
        textViewName.text = userList.get(position).nombre
        textViewNacionality.text = userList.get(position).nacionalidad

        return currentListItem
    }

}