fun main() {
    val salarioAtual = 300.0
    println(calcularNovoSalario(salarioAtual))
}

fun calcularNovoSalario(salarioAtual:Double):Double{
    if(salarioAtual<=300.0) return salarioAtual+salarioAtual*0.5

    if(salarioAtual>300.0 && salarioAtual<=500) return salarioAtual+salarioAtual*0.4

    if(salarioAtual>500.0 && salarioAtual<=700) return salarioAtual+salarioAtual*0.3

    if(salarioAtual>700.0 && salarioAtual<=800) return salarioAtual+salarioAtual*0.2

    if(salarioAtual>800.0 && salarioAtual<=1000) return salarioAtual+salarioAtual*0.1

    if(salarioAtual>1000.0) return salarioAtual+salarioAtual*0.05

  return salarioAtual
}