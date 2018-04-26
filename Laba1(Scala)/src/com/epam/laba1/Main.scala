package com.epam.laba1

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

object Main {
  def main(args: Array[String]): Unit = {
    
    val list: List[Int] = List(5,2,7,4,12,87,23)
    val array: Array[Int] = Array(9,2,2,2,4,3,3,6,6)
    
    println("Min value from list: " + getMinFromList(list))
    println("Min value from list(recursive): " + getMinFromListRecursive(list)) 
    println("Max length: " + getMaxLength(array))
    println("Max length(recursive): " + getMaxLengthRecursive(array))
    
  }
  
  def getMinFromList(list: List[Int]): Int = {
    
    val array: Array[Int] = list.toArray
    Sorting.stableSort(array)
    array(0)
    
  }
  
  def getMinFromListRecursive(list: List[Int]): Int = {
    
    @tailrec
    def rec(number: Int, index: Int): Int = {
      
      if (list.length <= index) number
      
      else if (list(index) < number) rec(list(index), index + 1)
      
      else rec(number, index + 1) 
      
    }
    rec(list(0), 1)
    
  }
  
  def getMaxLength(array: Array[Int]): Int = {
    
    val new_array: Array[Int] = array.clone()
    val array_buffer_1 = ArrayBuffer[Int]()
    val array_buffer_2 = ArrayBuffer[Int]() 
    
    for (i <- 0.to(new_array.length - 1)) {
      
      if (i == 0) array_buffer_1 += i
      
      if (i != 0 && new_array(i) != new_array(i - 1)) {
        
        array_buffer_2 += (i  - array_buffer_1(0))
        if (array_buffer_1.length != 0) array_buffer_1 -= array_buffer_1(0)
        array_buffer_1 += i 
        
      }
      
      if (i + 1 == new_array.length && new_array(i - 1) == new_array(i)) array_buffer_2 += (i + 1 - array_buffer_1(0))
      
    } 
    
    val sort_array = array_buffer_2.toArray
    Sorting.stableSort(sort_array)
    sort_array(sort_array.length - 1)
    
  }
  
  def getMaxLengthRecursive(array: Array[Int]): Int = {
    
    val array_buffer_1 = ArrayBuffer[Int]()
    val array_buffer_2 = ArrayBuffer[Int]()
    
    @tailrec
    def rec(number: Int, index: Int): Int = {
      
      if (index >= array.length) number
      
      else if (index + 1 == array.length && array(index - 1) == array(index)) {
        
        array_buffer_2 += (index + 1 - array_buffer_1(0))
        val new_array  = array_buffer_2.toArray
        Sorting.stableSort(new_array)
        rec(new_array(new_array.length - 1), index + 1)
        
      }
      
      else if (index - 1 != 0 && array(index) != array(index - 1)) {
        
        array_buffer_2 += (index  - array_buffer_1(0))
        if (array_buffer_1.length != 0) array_buffer_1 -= array_buffer_1(0)
        array_buffer_1 += index
        rec(array(index), index + 1)
        
      }
      
      else if (index - 1 == 0 && array(index) != array(index - 1)) {
        
        array_buffer_1 += index
        array_buffer_2 += 1
        rec(array(index), index + 1)
        
      }
      
      else if (index - 1 == 0) {
        
        array_buffer_1 += index - 1
        rec(array(index), index + 1)
        
      }
      
      else rec(array(index), index + 1)
      
    }
    rec(array(0), 1)
    
  }
  
}