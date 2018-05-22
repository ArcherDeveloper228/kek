package main.scala

import scala.collection.mutable.ArrayBuffer

object Main {
  
  def changeList(list: List[Int], number: Int, position: Int): List[Int] = {
   
    val array: ArrayBuffer[Int] = ArrayBuffer[Int]()
    val array_buffer_1: ArrayBuffer[Int] = ArrayBuffer[Int]()
    val array_buffer_2: ArrayBuffer[Int] = ArrayBuffer[Int]()
    
    array_buffer_1 += 0
    array_buffer_2 += 0
    
    while (array_buffer_1(0) < list.length) {
      
      if ((array_buffer_2(0) + 1) % position == 0) {
        
        array += number
        array += list(array_buffer_1(0))
        array_buffer_2(0) = array_buffer_2(0) + 2
        array_buffer_1(0) = array_buffer_1(0) + 1
        
      } else {
        
        array += list(array_buffer_1(0))
        array_buffer_1(0) = array_buffer_1(0) + 1
        array_buffer_2(0) = array_buffer_2(0) + 1
        
      }
      
    }
    
    array.toList
    
  }
  
  def reverseRight[Int](xs:List[Int]) = (xs :\ List[Int]()) {
     (y,ys) => ys ::: List(y)
  }
  
 
  
  def deleteSameKey(map : Map[Int,Int]) : Map[Int,Int] = 
    map.foldRight(Map[Int,Int]())((x, acc) => acc+((x._2,x._1))).foldLeft(Map[Int,Int]())((acc, x) => acc+((x._2,x._1)))
}

