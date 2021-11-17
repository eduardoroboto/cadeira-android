fun main() {
    val anguloRadianos = 0.78539816339
    val resultado = seno(anguloRadianos)
    println("O somatório dos quadrados dos numeros é $resultado")
}


fun factorial(number:Int):Int {
    var value = 1
    for (i in 1..number) value*=i
    return value
}

fun pow(base:Double, expoent:Int):Double{
    var value = 1.0
    for (i in 1..expoent) value*=base
    return value
}



fun seno(angulo:Double): Double {

    var X1 = angulo/factorial(1)
    var choice = false
    var seno = X1
    for (i in 3..10 step 2){
        var Xi = (pow(angulo,i))/factorial(i)
        println("Xi:${Xi} - pow:${angulo},${i} - factorial(${i}):${factorial(i)}")
        if(choice){
            seno+=Xi
            choice=false
            println("Xi:${Xi} - seno:${seno} - i:${i}")
        }else{
            seno-=Xi
            choice=true
            println("Xi:${Xi} - seno:${seno} - i:${i}")
        }
    }

  return seno
}
