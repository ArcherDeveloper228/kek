package test.scala

import main.scala.ComplexNumber
import main.scala.ScalarNumber
import org.scalatest.FunSuite
import java.util.Calendar

class ScalaTest extends FunSuite {
  
  test("Current date") {
    assert(main.scala.Main.currentDate("M/D h:m") == 
      Calendar.getInstance.get(Calendar.MONTH).toString + "/" + Calendar.getInstance.get(Calendar.DAY_OF_MONTH).toString + 
        " " + Calendar.getInstance.get(Calendar.HOUR).toString + ":" + Calendar.getInstance.get(Calendar.MINUTE).toString)
  }
  
  test("Calculate number(complex number)") {
    assert(main.scala.Main.calculateNumber(new ComplexNumber(4,4)) == 5.656854249492381)
  }

  test("Calculate number(scalar number)") {
    assert(main.scala.Main.calculateNumber(new ScalarNumber(5)) == 5.0)
  }
  
}