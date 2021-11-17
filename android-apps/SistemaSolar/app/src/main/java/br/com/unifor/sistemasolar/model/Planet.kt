package br.com.unifor.sistemasolar.model

import android.text.SpannableString

data class Planet(
    val id:Int,
    val name:String,
    val periodo:String,
    val massa:String,
    val diametro:String,
    val periodo_rotacao:String,
    val gravidade:String,
    val satelites_naturais:Int,
    val type_of_planet:PlanetType,
    val photo:Int,
)

enum class PlanetType {
   solido,gasoso,anão
}
