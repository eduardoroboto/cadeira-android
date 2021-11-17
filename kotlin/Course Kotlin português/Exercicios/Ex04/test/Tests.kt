import org.junit.Assert
import org.junit.Test

class Test {
    @Test
    fun testSomatorioQuadrado01() {
        Assert.assertEquals(28286, somatorioQuadrado(listOf(41, 50, 80, 63, 29, 8, 94, 11, 25, 57)))
    }

    @Test
    fun testSomatorioQuadrado02() {
        Assert.assertEquals(10, somatorioQuadrado(listOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)))
    }

    @Test
    fun testSomatorioQuadrado03() {
        Assert.assertEquals(0, somatorioQuadrado(listOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)))
    }

    @Test
    fun testSomatorioQuadrado04() {
        Assert.assertEquals(1000, somatorioQuadrado(listOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10)))
    }

    @Test
    fun testSomatorioQuadrado05() {
        Assert.assertEquals(55, somatorioQuadrado(listOf(1,2,3,4,5)))
    }

}