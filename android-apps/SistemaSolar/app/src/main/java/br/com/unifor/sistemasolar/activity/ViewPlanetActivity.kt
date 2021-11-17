package br.com.unifor.sistemasolar.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import br.com.unifor.sistemasolar.R
import br.com.unifor.sistemasolar.adapter.PlanetAdapter
import br.com.unifor.sistemasolar.model.Planet
import br.com.unifor.sistemasolar.repository.PlanetRepository

class ViewPlanetActivity : AppCompatActivity() {

   private lateinit var  planetPhoto: ImageView
   private lateinit var planetName: TextView
    private lateinit var planetPeriod: TextView
    private lateinit var planetMass: TextView
    private lateinit var planetDiameter: TextView
    private lateinit var planetRotatioPeriod: TextView
    private lateinit var planetGravity: TextView
    private lateinit var planetNaturalSatelites: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_planet)

        planetPhoto = findViewById(R.id.planet_imageview_photo)
        planetName = findViewById(R.id.planet_textview_name)
        planetPeriod = findViewById(R.id.planet_textview_orbial_period)
        planetMass = findViewById(R.id.planet_textview_mass)
        planetDiameter = findViewById(R.id.planet_textview_diameter)
        planetRotatioPeriod = findViewById(R.id.planet_textview_rotation_period)
        planetGravity = findViewById(R.id.planet_textview_gravity)
        planetNaturalSatelites = findViewById(R.id.planet_textview_number_of_natural_satelites)

        val position = intent.getIntExtra("planet_id",-1)
        val typeOfPlanet = intent.getStringExtra("planet_type")
        if(position >= 0){

            if(typeOfPlanet=="solido"){
                planetToView(PlanetRepository.findAllSolido().get(position))
                }

            else if(typeOfPlanet=="gasoso"){
                planetToView(PlanetRepository.findAllGasoso().get(position))
            }

            else if(typeOfPlanet=="anão"){
                planetToView(PlanetRepository.findAllAnao().get(position))
            }
        }
    }

    private fun planetToView(it: Planet) {
        planetPhoto.setImageResource(it.photo)
        planetName.text = it.name
        planetPeriod.text = it.periodo
        planetMass.text = it.massa
        planetDiameter.text = it.diametro
        planetRotatioPeriod.text = it.periodo_rotacao
        planetGravity.text = it.gravidade
        planetNaturalSatelites.text = it.satelites_naturais.toString()
    }
}