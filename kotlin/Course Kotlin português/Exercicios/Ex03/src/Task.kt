fun main() {
    val numeros = listOf(7, 394, 604, 155, 780, 324, 927, 124, 876, 229)
    val resultado = somatorio(numeros)
    println("A soma é igual a $resultado")
}

fun somatorio(numeros: List<Int>): Int {
    var soma = 0
    for(numero in numeros) soma+=numero
    return soma
}
