package br.com.unifor.todolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.unifor.todolist.R
import br.com.unifor.todolist.model.Category

class CategoryAdapter(private val categories: List<Category>)
    :RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(item: View):RecyclerView.ViewHolder(item){
        val mName: TextView = item.findViewById(R.id.item_category_textview_name)
        val mDescription:TextView  = item.findViewById(R.id.item_category_textview_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val item = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_category_list, parent,false)
        return CategoryViewHolder(item)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.mName.text = categories[position].name
        holder.mDescription.text = categories[position].description
    }

    override fun getItemCount(): Int {
        return categories.size
    }


}