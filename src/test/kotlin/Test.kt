import com.ferdllr.Models.Character
import com.ferdllr.constCalc
import com.ferdllr.main
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class Test {
    @Test
    fun modiTest(){
        var charTest = Character()
        charTest.CON = 1
        println("charcon = ${charTest.CON}; modifier = ${constCalc(charTest.CON)}")
        assertEquals(-5, constCalc(charTest.CON))
        charTest.CON = 2
        println("charcon = ${charTest.CON}; modifier = ${constCalc(charTest.CON)}")
        assertEquals(-4, constCalc(charTest.CON))
        charTest.CON = 5
        println("charcon = ${charTest.CON}; modifier = ${constCalc(charTest.CON)}")
        assertEquals(-3, constCalc(charTest.CON))
        charTest.CON = 12
        println("charcon = ${charTest.CON}; modifier = ${constCalc(charTest.CON)}")
        assertEquals(1, constCalc(charTest.CON))
        charTest.CON = 20
        println("charcon = ${charTest.CON}; modifier = ${constCalc(charTest.CON)}")
        assertEquals(5, constCalc(charTest.CON))
    }
}