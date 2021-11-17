import org.junit.Assert
import org.junit.Test

class Test {
    @Test
    fun testSalario300() {
        Assert.assertEquals(450.0, calcularNovoSalario(300.0), 0.1)
    }

    @Test
    fun testSalario400() {
        Assert.assertEquals(560.0, calcularNovoSalario(400.0), 0.1)
    }

    @Test
    fun testSalario500() {
        Assert.assertEquals(700.0, calcularNovoSalario(500.0), 0.1)
    }

    @Test
    fun testSalario600() {
        Assert.assertEquals(780.0, calcularNovoSalario(600.0), 0.1)
    }

    @Test
    fun testSalario700() {
        Assert.assertEquals(910.0, calcularNovoSalario(700.0), 0.1)
    }

    @Test
    fun testSalario750() {
        Assert.assertEquals(900.0, calcularNovoSalario(750.0), 0.1)
    }

    @Test
    fun testSalario800() {
        Assert.assertEquals(960.0, calcularNovoSalario(800.0), 0.1)
    }

    @Test
    fun testSalario900() {
        Assert.assertEquals(990.0, calcularNovoSalario(900.0), 0.1)
    }

    @Test
    fun testSalario1000() {
        Assert.assertEquals(1100.0, calcularNovoSalario(1000.0), 0.1)
    }

    @Test
    fun testSalario1200() {
        Assert.assertEquals(1260.0, calcularNovoSalario(1200.0), 0.1)
    }

}