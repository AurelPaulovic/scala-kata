package com.aurelpaulovic.scala_kata.s_99

/*
 * (*) Find the last element of a list
 * 
 * scala> last(List(1, 1, 2, 3, 5, 8))
 * Int = 8
 * 
 */

import scala.annotation.tailrec


package object p01 {
	/**
	 * Gets the last element of the list using built-in
	 * 
	 * @param ls the list
	 */
	def last01[A](ls: List[A]): A = ls.last
	
	
	/**
	 * Gets the last element of the list using tail-recursive inner function
	 * 
	 * @param ls the list
	 */
	def last02[A](ls: List[A]): A = {
	  @tailrec
	  def last02Recursive[A](ls: List[A]): A = {
	    ls match {
	      case Nil => throw new NoSuchElementException
	      case ele :: Nil => ele
	      case _ :: tail => last02Recursive(tail)
	    }
	  }
	  
	  last02Recursive(ls)
	}
	
	
}