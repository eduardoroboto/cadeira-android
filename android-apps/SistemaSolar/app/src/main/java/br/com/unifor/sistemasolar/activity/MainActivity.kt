package br.com.unifor.sistemasolar.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import br.com.unifor.sistemasolar.R

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var buttonAll: Button
    private lateinit var buttonTelluricPlanet: Button
    private lateinit var buttonGasPlanet: Button
    private lateinit var buttonDwarfPlanet: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonTelluricPlanet = findViewById(R.id.button_telluric_planet)
        buttonGasPlanet = findViewById(R.id.button_gas_planet)
        buttonDwarfPlanet = findViewById(R.id.button_dwarf_planet)


        buttonTelluricPlanet.setOnClickListener(this)
        buttonGasPlanet.setOnClickListener(this)
        buttonDwarfPlanet.setOnClickListener(this)


    }

    override fun onClick(view: View?) {
        when (view?.id) {


            R.id.button_telluric_planet -> {

                val it = Intent(this, ViewPlanetListActivity::class.java)
                it.putExtra("choice", "telluric")
                startActivity(it)
            }

            R.id.button_gas_planet -> {

                val it = Intent(this, ViewPlanetListActivity::class.java)
                it.putExtra("choice", "gas")
                startActivity(it)
            }

            R.id.button_dwarf_planet -> {

                val it = Intent(this, ViewPlanetListActivity::class.java)
                it.putExtra("choice", "dwarf")
                startActivity(it)
            }

        }
    }
}