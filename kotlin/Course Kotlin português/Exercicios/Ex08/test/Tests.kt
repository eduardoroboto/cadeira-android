import org.junit.Assert
import org.junit.Test
import kotlin.random.Random

class Test {

    @Test
    fun testCalculoHorasGratificacao01() {
        Assert.assertEquals(20.0, calculoHorasGratificação(20, 0), 0.1)
    }

    @Test
    fun testCalculoHorasGratificacao02() {
        Assert.assertEquals(0.0, calculoHorasGratificação(20, 30), 0.1)
    }

    @Test
    fun testCalculoHorasGratificacao03() {
        Assert.assertEquals(10.0, calculoHorasGratificação(30, 30), 0.1)
    }

    @Test
    fun testCalculoGratificacao01() {
        Assert.assertEquals(500.0, calculoGratificação(Random.nextDouble(40.0, 100.0)), 0.1)
    }

    @Test
    fun testCalculoGratificacao02() {
        Assert.assertEquals(400.0, calculoGratificação(Random.nextDouble(30.0, 39.0)), 0.1)
    }

    @Test
    fun testCalculoGratificacao03() {
        Assert.assertEquals(300.0, calculoGratificação(Random.nextDouble(20.0, 29.0)), 0.1)
    }

    @Test
    fun testCalculoGratificacao04() {
        Assert.assertEquals(200.0, calculoGratificação(Random.nextDouble(10.0, 19.0)), 0.1)
    }

    @Test
    fun testCalculoGratificacao05() {
        Assert.assertEquals(100.0, calculoGratificação(Random.nextDouble( 10.0)), 0.1)
    }

}