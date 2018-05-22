package main.scala

import java.util.Calendar

import scala.collection.mutable.ArrayBuffer


object Main {
  
  def main(args: Array[String]): Unit = {
    
    println(calculateNumber(new ComplexNumber(4,4)))
    
  }
  
  def currentDate(format: String): String = {
    
    val array: Array[Char] = format.toCharArray()
    val array_buffer_1: ArrayBuffer[String] = ArrayBuffer[String]()
    val array_buffer_2: ArrayBuffer[String] = ArrayBuffer[String]()
    
    for (i <- 0 to array.length - 1) {
      
      array(i) match {
        
        case 'Y' => array_buffer_1 += Calendar.getInstance.get(Calendar.YEAR).toString()
        case 'M' => array_buffer_1 += Calendar.getInstance.get(Calendar.MONTH).toString()
        case 'D' => array_buffer_1 += Calendar.getInstance.get(Calendar.DAY_OF_MONTH).toString()
        case 'h' => array_buffer_1 += Calendar.getInstance.get(Calendar.HOUR).toString()
        case 'm' => array_buffer_1 += Calendar.getInstance.get(Calendar.MINUTE).toString()
        case 's' => array_buffer_1 += Calendar.getInstance.get(Calendar.SECOND).toString()
        case _ => array_buffer_1 += array(i).toString()
        
      }
      
    }  
    
    for (i <- 0 to array_buffer_1.size - 1) {
      
      if (i == 0) array_buffer_2 += ""
      
      array_buffer_2(0) = array_buffer_2(0) + array_buffer_1(i)
      
    }  
    
    array_buffer_2(0)
    
  }
  
  def calculateNumber(number: Number): Double = {
    
    val array_buffer: ArrayBuffer[Double] = ArrayBuffer[Double]()
    
    number match {
      
      case _: ComplexNumber => array_buffer += number.module
      case _: ScalarNumber => array_buffer += number.module
      
    }
    
    array_buffer(0)
    
  }
  
}