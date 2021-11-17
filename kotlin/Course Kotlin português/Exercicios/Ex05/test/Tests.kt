import org.junit.Assert
import org.junit.Test

class Test {

    @Test fun testSeno30() {
        Assert.assertEquals(0.5, seno(0.52359877559), 1e-5)
    }

    @Test fun testSeno45() {
        Assert.assertEquals(0.70710678118, seno(0.78539816339), 1e-5)
    }

    @Test fun testSeno90() {
        Assert.assertEquals(1.0, seno(1.57079632679), 1e-5)
    }
}