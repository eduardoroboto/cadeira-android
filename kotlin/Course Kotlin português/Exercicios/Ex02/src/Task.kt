fun main() {
    var numeros = listOf(-58, 75, 46, -65, -27, 12, 62, -66, 59, -73)
    val positivos = contarPositivos(numeros)
    val negativos = contarNegativos(numeros)
    println("A quantidade de numeros positivos é $positivos e de negativos é $negativos")
}

fun contarPositivos(numeros: List<Int>): Int {
    var positivos = 0
    for(numero in numeros) if(numero>=0) positivos+=1

    return positivos
}

fun contarNegativos(numeros: List<Int>): Int {
    var negativos = 0
    for(numero in numeros) if(numero<0) negativos+=1

    return negativos
}
