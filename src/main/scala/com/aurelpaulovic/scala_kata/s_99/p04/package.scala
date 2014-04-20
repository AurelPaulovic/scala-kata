package com.aurelpaulovic.scala_kata.s_99

/*
 * (*) Find the number of elements of a list.
 * Example:
 * scala> length(List(1, 1, 2, 3, 5, 8))
 * res0: Int = 6
 */

import scala.annotation.tailrec

package object p04 {
	/**
	 * Returns the length of a list using built-in
	 * 
	 * @param ls the list
	 */
	def length01[A](ls: List[A]) = ls.length
	
	/**
	 * Returns the length of a list using for loop
	 * 
	 * @param ls the list
	 */
	def length02[A](ls: List[A]) = {
	  var i = 0
	  for(e <- ls) i+=1
	  i
	}
	
	/**
	 * Returns the length of a list using an inner tail-recursive function
	 * 
	 * @param ls the list
	 */
	def length03[A](ls: List[A]) = {
	  @tailrec
	  def lengthInner[A](ls: List[A], len: Int): Int = {
	    if (ls.isEmpty) len
	    else lengthInner(ls.tail, len + 1)
	  }
	  
	  lengthInner(ls, 0)
	}
	
	/**
	 * Returns the length of a list using foldLeft
	 * 
	 * @param ls the list
	 */
	def length04[A](ls: List[A]) = (0 /: ls)((i, _) => i + 1)
	
	/**
	 * Returns the length of a list using reduceLeft
	 * 
	 * @param ls the list
	 */
	def length05[A](ls: List[A]) = {
	  (0 :: ls).reduceLeft((i, _) => i match {
		  case x: Int => x + 1
		}).asInstanceOf[Int] //reduceLeft returns supertype >: A so we need to cast it even though we know it will be Int
	}
}