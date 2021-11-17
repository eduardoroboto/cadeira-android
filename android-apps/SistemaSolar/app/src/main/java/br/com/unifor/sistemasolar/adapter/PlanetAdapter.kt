package br.com.unifor.sistemasolar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.unifor.sistemasolar.R
import br.com.unifor.sistemasolar.listener.PlanetItemListener
import br.com.unifor.sistemasolar.model.Planet
import br.com.unifor.sistemasolar.model.PlanetType

class PlanetAdapter(private val planets:List<Planet>):
    RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder>() {

    class PlanetViewHolder(item: View, listener: PlanetItemListener?):RecyclerView.ViewHolder(item){
        val planetPhoto:ImageView = item.findViewById(R.id.item_planet_imageview_photo)
        val planetName:TextView = item.findViewById(R.id.item_planet_textview_name)
        var planetType:String = "solido"
        init {
            item.setOnClickListener {
                listener?.onItemClick(it,adapterPosition,planetType)
            }
        }

    }


    private var listener:PlanetItemListener? = null

    fun setOnPlanetItemListener(listener: PlanetItemListener){
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        val item:View = LayoutInflater.from(parent.context).inflate(R.layout.item_planet_list,parent,false)
        return PlanetViewHolder(item,listener)
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        holder.planetPhoto.setImageResource(planets[position].photo)
        holder.planetName.text = planets[position].name
        holder.planetType = planets[position].type_of_planet.toString()
    }

    override fun getItemCount(): Int {
        return planets.size
    }

}