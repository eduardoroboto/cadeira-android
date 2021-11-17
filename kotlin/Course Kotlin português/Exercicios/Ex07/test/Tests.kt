import org.junit.Assert
import org.junit.Test
import kotlin.random.Random

class Test {
    @Test
    fun testCalcularTotalNota01() {
        val numero = Random.nextInt(0,11)
        val quantidade = Random.nextInt(50)
        val valor = 10.0
        Assert.assertEquals(quantidade * valor, calcularPrecoNota(numero, quantidade), 0.0)
    }

    @Test
    fun testCalcularTotalNota02() {
        val numero = Random.nextInt(11,21)
        val quantidade = Random.nextInt(50)
        val valor = 15.0
        Assert.assertEquals(quantidade * valor, calcularPrecoNota(numero, quantidade), 0.0)
    }

    @Test
    fun testCalcularTotalNota03() {
        val numero = Random.nextInt(21,31)
        val quantidade = Random.nextInt(50)
        val valor = 20.0
        Assert.assertEquals(quantidade * valor, calcularPrecoNota(numero, quantidade), 0.0)
    }

    @Test
    fun testCalcularTotalNota04() {
        val numero = Random.nextInt(31,40)
        val quantidade = Random.nextInt(50)
        val valor = 30.0
        Assert.assertEquals(quantidade * valor, calcularPrecoNota(numero, quantidade), 0.0)
    }

    @Test
    fun testCalcularDesconto01() {
        Assert.assertEquals(190.0, calcularDesconto(200.0), 0.0)
    }

    @Test
    fun testCalcularDesconto02() {
        Assert.assertEquals(237.5, calcularDesconto(250.0), 0.0)
    }

    @Test
    fun testCalcularDesconto03() {
        Assert.assertEquals(315.0, calcularDesconto(350.0), 0.0)
    }

    @Test
    fun testCalcularDesconto04() {
        Assert.assertEquals(450.0, calcularDesconto(500.0), 0.0)
    }

    @Test
    fun testCalcularDesconto05() {
        Assert.assertEquals(510.0, calcularDesconto(600.0), 0.0)
    }

}