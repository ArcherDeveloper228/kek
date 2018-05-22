package main.scala

import java.lang.Math 

class ScalarNumber(val number: Double) extends Number {
  
  def module(): Double = Math.abs(number)
  
}