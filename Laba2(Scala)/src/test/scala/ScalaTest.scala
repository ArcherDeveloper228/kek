package test.scala

import org.scalatest.FunSuite

class ScalaTest extends FunSuite {
  
  test("Change list(Empty list)") {
    assert(main.scala.Main.changeList(Nil, 100, 3) == Nil)
  }
  
  test("Change list(Non-empty list)") {
    assert(main.scala.Main.changeList(1::2::3::4::5::6::7::8::Nil, 100, 3) 
        == 1::2::100::3::4::100::5::6::100::7::8::Nil)
  }
  
  test("Reverse right(Empty list)") {
    assert(main.scala.Main.reverseRight(Nil) == Nil)
  }
  
  test("Reverse right(Non-empty list)") {
    assert(main.scala.Main.reverseRight(1::2::3::4::5::6::7::8::Nil) == 8::7::6::5::4::3::2::1::Nil)
  }
  
  test("Delete same key(Empty map)") {
    assert(main.scala.Main.deleteSameKey(Map()) == Map())
  }
  
  test("Delete same key(Non-empty map)") {
    assert(main.scala.Main.deleteSameKey(Map((1,1),(2,1),(3,2))) == Map((3,2),(1,1)))
  }
  
}