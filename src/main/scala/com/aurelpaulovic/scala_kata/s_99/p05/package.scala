package com.aurelpaulovic.scala_kata.s_99
/*
 * (*) Reverse a list.
 * Example:
 * scala> reverse(List(1, 1, 2, 3, 5, 8))
 * res0: List[Int] = List(8, 5, 3, 2, 1, 1)
 */

import scala.annotation.tailrec

package object p05 {
  /**
   * Returns a list that has all the elements of the list {@see ls} in reverse order using built-in
   * 
   * @param ls the list
   */
  def reverse01[A](ls: List[A]) = ls.reverse
  
		  
  /**
   * Returns a list that has all the elements of the list {@see ls} in reverse order using inner tail-recursive func with accumlator
   * 
   * @param ls the list
   */
  def reverse02[A](ls: List[A]) = {
    @tailrec
    def reverseInner[A](ls: List[A], acc: List[A]): List[A] = ls match {
      case Nil => acc
      case ele :: tail => reverseInner(tail, ele :: acc)
    }
    
    reverseInner(ls, List())
  }
  
  /**
   * Returns a list that has all the elements of the list {@see ls} in reverse order using foldLeft
   * 
   * @param ls the list
   */
  def reverse03[A](ls: List[A]) = (List[A]() /: ls)((acc, ele) => ele :: acc)
  
  /**
   * Returns a list that has all the elements of the list {@see ls} in reverse order using for loop and a ListBuffer
   * 
   * @param ls the list
   */
  def reverse04[A](ls: List[A]) = {
    var rls: scala.collection.mutable.ListBuffer[A] = new scala.collection.mutable.ListBuffer()
    for(ele <- ls) rls.+=:(ele)
    rls.toList
  }
}