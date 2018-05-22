package main.scala

import java.lang.Math

class ComplexNumber(val number_1: Double, val number_2: Double) extends Number {
  
  def module(): Double = Math.sqrt(Math.pow(number_1, 2) + Math.pow(number_2, 2))
  
}