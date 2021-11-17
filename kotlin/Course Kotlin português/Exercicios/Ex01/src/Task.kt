fun main() {
    val notas = listOf(55, 42, 77, 63, 29, 57, 89)
    val aprovados = contabilizarAprovados(notas)
    println("A quantidade de estudantes aprovados é $aprovados")
}

fun contabilizarAprovados(notas: List<Int>):Int {
    var aprovados = 0
    for(nota in notas) if (nota>=50) aprovados+=1

    return aprovados
}
