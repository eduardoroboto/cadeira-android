import org.junit.Assert
import org.junit.Test

class Test {
    @Test
    fun testSomatorio01() {
        Assert.assertEquals(4420, somatorio(listOf(7, 394, 604, 155, 780, 324, 927, 124, 876, 229)))
    }

    @Test
    fun testSomatorio02() {
        Assert.assertEquals(0, somatorio(listOf(0, 0, 0, 0, 0, 0, 0, 0, 0)))
    }

    @Test
    fun testSomatorio03() {
        Assert.assertEquals(1, somatorio(listOf(0, 0, 0, 0, 0, 1, 0, 0, 0)))
    }

    @Test
    fun testSomatorio04() {
        Assert.assertEquals(10, somatorio(listOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)))
    }

    @Test
    fun testSomatorio05() {
        Assert.assertEquals(25, somatorio(listOf(1, 3, 5, 7, 9)))
    }

    @Test
    fun testSomatorio06() {
        Assert.assertEquals(20, somatorio(listOf(0, 2, 4, 6, 8)))
    }
}