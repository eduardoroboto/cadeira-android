package br.com.unifor.personview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.unifor.personview.R
import br.com.unifor.personview.listener.PersonItemListener
import br.com.unifor.personview.model.User

class PeopleAdapter(private val users:List<User>): RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>(){



   class PeopleViewHolder(item:View, listener: PersonItemListener?):RecyclerView.ViewHolder(item){

      val mPeoplePhoto:ImageView = item.findViewById(R.id.item_people_imageview_photo)
      val mPeopleName:TextView = item.findViewById(R.id.item_people_textview_name)
      val mPeopleEmail:TextView = item.findViewById(R.id.item_people_textview_email)
      val mPeopleBirthday:TextView = item.findViewById(R.id.item_people_textview_birthday)
      init {
      item.setOnClickListener {
         listener?.onItemClick(it,adapterPosition)
      }
      }
   }

   private var listener:PersonItemListener? = null

   fun setOnPersonItemListener(listener: PersonItemListener){
      this.listener = listener
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
       val item:View = LayoutInflater.from(parent.context).inflate(R.layout.item_people_list, parent, false)
      return PeopleViewHolder(item,listener)
   }

   override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
      holder.mPeoplePhoto.setImageResource(users[position].photo)
      holder.mPeopleName.text =  users[position].name
      holder.mPeopleEmail.text =  users[position].email
      holder.mPeopleBirthday.text =  users[position].birthday
   }

   override fun getItemCount(): Int {
       return users.size
   }

}