
fun main() {
    val numeros = listOf(41, 50, 80, 63, 29, 8, 94, 11, 25, 57)
    val resultado = somatorioQuadrado(numeros)
    println("O somatório dos quadrados dos numeros é $resultado")
}

fun somatorioQuadrado(numeros: List<Int>): Int {
    var soma_do_quadrado = 0

    for(numero in numeros) soma_do_quadrado+= numero*numero

    return soma_do_quadrado
}
