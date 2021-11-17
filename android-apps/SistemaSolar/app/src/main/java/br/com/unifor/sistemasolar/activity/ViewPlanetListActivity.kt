package br.com.unifor.sistemasolar.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.unifor.sistemasolar.R
import br.com.unifor.sistemasolar.adapter.PlanetAdapter
import br.com.unifor.sistemasolar.listener.PlanetItemListener
import br.com.unifor.sistemasolar.model.PlanetType
import br.com.unifor.sistemasolar.repository.PlanetRepository

class ViewPlanetListActivity : AppCompatActivity(),PlanetItemListener{

    private lateinit var mPlanetList:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_planet_list)

        val llm = LinearLayoutManager(this)
        val planetType = intent.getStringExtra("choice")

       var planetAdapter = PlanetAdapter(PlanetRepository.findAll())

        if(planetType=="telluric"){
           planetAdapter = PlanetAdapter(PlanetRepository.findAllSolido())
        }

        if(planetType=="gas"){
            planetAdapter = PlanetAdapter(PlanetRepository.findAllGasoso())
        }

        if(planetType=="dwarf"){
            planetAdapter = PlanetAdapter(PlanetRepository.findAllAnao())
        }
        planetAdapter.setOnPlanetItemListener(this)
        mPlanetList = findViewById(R.id.recyclerview_planet_list)

        mPlanetList.apply{
            hasFixedSize()
            adapter = planetAdapter
            layoutManager = llm
        }

    }

    override fun onItemClick(view: View, position: Int,planetType: String) {
        val it = Intent(this,ViewPlanetActivity::class.java)
        it.putExtra("planet_id",position)
        it.putExtra("planet_type",planetType)
        startActivity(it)
    }
}