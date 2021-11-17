import org.junit.Assert
import org.junit.Test

class Test {
    @Test
    fun testContabilizarAprovados01() {
        Assert.assertEquals(5, contabilizarAprovados(listOf(55, 42, 77, 63, 29, 57, 89)))
    }

    @Test
    fun testContabilizarAprovados02() {
        Assert.assertEquals(6, contabilizarAprovados(listOf(50, 50, 50, 50, 50, 50)))
    }

    @Test
    fun testContabilizarAprovados03() {
        Assert.assertEquals(0, contabilizarAprovados(listOf(10, 20, 30, 40, 45, 49)))
    }

    @Test
    fun testContabilizarAprovados04() {
        Assert.assertEquals(3, contabilizarAprovados(listOf(100, 80, 70)))
    }
}