package br.com.unifor.sistemasolar.repository

import br.com.unifor.sistemasolar.R
import br.com.unifor.sistemasolar.model.Planet
import br.com.unifor.sistemasolar.model.PlanetType

object PlanetRepository {

    fun findAll():List<Planet>{
        return listOf(
//            Nome,	Período(dias)	Massa(kg) 	Diâmetro (km) 	Período de rotação (horas)	Gravidade no equador  	Satélites naturais conhecido
            Planet(1, "Mercúrio",	"87,969 dias","3,3011 × 10^23","4879,4 km","1407,5 horas","3,7 m/s²",0,PlanetType.solido,R.drawable.p1),
            Planet(2, "Vênus","583,92 dias ","4,8685 × 10^24 kg","12.103,6 km"," -5.832,5 horas ","8,87 m/s²",0,PlanetType.solido,R.drawable.p2),
            Planet(3, "Terra","365,256363004 dias"," 5,9736 × 10^24","12.756,2 km","23h 56m 4,100s","9,780327 m/s²",1,PlanetType.solido,R.drawable.p3),
            Planet(4, "Marte","686,971 dias","6,4174 × 10^23 kg","6792,4 km","24 h 37 min 22 s ","3,711 m/s²",2,PlanetType.solido,R.drawable.p4),
            Planet(5,"Ceres"," 1680,5 dias","9,5 × 10^20 kg","974,6 ± 3,6 km","9,0744 horas","0.2745862 m/s²",0,PlanetType.anão,R.drawable.p5),
            Planet(6,"Júpiter","4.331,572 dias","1,8986 × 10^27 kg","142.984 ± 8 km","9,8 horas","24,79 m/s²",79,PlanetType.gasoso,R.drawable.p6),
            Planet(7,"Saturno"," 10.759,22 dias","5,6846 × 10^26 kg","120.536 km","10h 34min","10,44 m/s²",82,PlanetType.gasoso,R.drawable.p7),
            Planet(8,"Urano","30.799,095 dias"," (8,6810 ± 0,0013) × 10^25 kg","51.118 ± 8 km","17 h 14 min 24 s","8,69 m/s²",27,PlanetType.gasoso,R.drawable.p8),
            Planet(9,"Neptuno"," 60.190,03 dias","1,0243 × 10^26 kg","49.528 km","16 h 6 min 36 s","11,15 m/s²",13,PlanetType.gasoso,R.drawable.p9),
            Planet(10,"Plutão","90.613,305 dias","(1,305 ± 0,007) × 10^22 kg","2.376,6 ± 3,2","6 d 9 h 17 m 36 s","0,658 m/s²",5,PlanetType.anão,R.drawable.p10),
            Planet(11,"Haumea","103.468,02 dias"," (4,2 ± 0,1) × 10^21 kg","1.600 km","3 h 54 m 55 s","2,4 × 10^-12 m/s²",2,PlanetType.anão,R.drawable.p11),
            Planet(12,"Makemake","113.154,45 dias","?","1420 ± 60 km","7,771 ± 0,003 horas ","?",1,PlanetType.anão,R.drawable.p12),
            Planet(13,"Éris","203.500 dias","(1,66 ± 0,02) × 10²² kg","2.326 ± 12 km","25,9 ± 0,5 h","0,82±0,02 m/s²",1,PlanetType.anão,R.drawable.p13),
            Planet(14,"Sedna","4.163.850 dias","?","995 ± 80 km","0,42 d (10,3 h ± 30%)","~0.2941995 m/s²",0,PlanetType.anão,R.drawable.p14),
        )
    }

    fun findAllSolido():List<Planet>{
        return findAll().filter { it.type_of_planet == PlanetType.solido }
    }

    fun findAllGasoso():List<Planet>{

        return findAll().filter { it.type_of_planet == PlanetType.gasoso}
    }

    fun findAllAnao():List<Planet>{

        return findAll().filter { it.type_of_planet == PlanetType.anão }
    }
}