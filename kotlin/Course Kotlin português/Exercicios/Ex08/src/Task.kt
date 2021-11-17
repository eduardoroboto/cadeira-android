fun main() {
    val horasExtras = 40
    val horasFaltas = 20
    val horasGratificacao = calculoHorasGratificação(horasExtras, horasFaltas)

    val gratificação = calculoGratificação(horasGratificacao)

    println("A gratificação será de $gratificação")
}

fun calculoHorasGratificação(horasExtras: Int, horasFaltas: Int): Double {
    return horasExtras - (2.0/3 * horasFaltas)
}

fun calculoGratificação(horasGratificacao: Double): Double {
    val minutorGratificacao = horasGratificacao*60
    if (minutorGratificacao >= 2400 ) return 500.0
    if (minutorGratificacao in 1800.0..2400.0) return 400.0
    if (minutorGratificacao > 1200 && horasGratificacao <= 1800) return 300.0
    if (minutorGratificacao in 600.0..1200.0) return 200.0
    if (minutorGratificacao < 600) return 100.0

    return 0.0

}
