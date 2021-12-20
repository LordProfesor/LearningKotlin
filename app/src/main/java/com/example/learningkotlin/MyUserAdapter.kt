package com.example.learningkotlin

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

/*El XML del item se puede pasar en el constructor de class MyUserAdapter. En vez de eso como en
este caso el XML va a ser siempre el mismo. Se lo paso directamente al constructor del ArrayAdapter.*/
class MyUserAdapter(context: Context, viewToPaint: Int, private val userList: ArrayList<User>)
    : ArrayAdapter<User>(context, viewToPaint, userList) {

    /*Cada vez que se dibuja un elemento nuevo en pantalla se hace una llamada al getView. Por este motivo, es llamado la primera
    que se muestra la vista para dibujar los elementos iniciales y posteriormente cada vez que hacemos scroll arriba o abajo y
    aparecen y desaparecen nuevos elementos.*/
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        /*En principio solo usaremos el parametro position. Por comodidad dejaremos el convertView y el parent para más adelante.
        Estos nos serviran para optimizar el funcionamiento del listView con los viewHolder, pero por ahora, podremos prescindir de ellos*/
        Log.i("Demostración: ","entrando en el getView")

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