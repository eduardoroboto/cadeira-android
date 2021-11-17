package br.com.unifor.sistemasolar.listener

import android.view.View
import br.com.unifor.sistemasolar.model.PlanetType

interface PlanetItemListener {

    fun onItemClick(view: View, position:Int,planetType: String)

}