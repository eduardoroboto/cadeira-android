fun main() {
    val codigo = 1
    val quantidade = 19

    val unidadeNota = calcularPrecoNota(codigo, 1)
    val totalNota = calcularPrecoNota(codigo, quantidade)
    val desconto = calcularDesconto(totalNota)

    val precoFinal = totalNota - desconto

    // COLOCAR OS PRINTLN NECESSÁRIOS CONFORME O ENUNCIADO DO PROBLEMA
    // Será necessário representar dentro do programa a tabela de preços
    println("Preço da unidade do produto de codigo ${codigo}: R$${unidadeNota}")
    println()
    println("O preço total para $quantidade produtos: R$${totalNota}")
    println()
    println("Total do Desconto: R$${desconto}")
    println()
    println("O preço final: R$${precoFinal}")
    println()
}

fun calcularDesconto(totalNota: Double): Double {
    if(totalNota<=250.0) return totalNota-totalNota*0.05
    if(totalNota in 250.0..500.0) return totalNota-totalNota*0.10
    if(totalNota>=500.0) return totalNota-totalNota*0.15

    return 0.0
}

fun calcularPrecoNota(codigo: Int, quantidade: Int): Double {
    if(codigo in 1..10)  return 10.0*quantidade
    if(codigo in 11..20) return 15.0*quantidade
    if(codigo in 21..30) return 20.0*quantidade
    if(codigo in 31..40) return 30.0*quantidade

    return 0.0
}
