package com.aurelpaulovic.scala_kata.s_99

/*
 * (*) Find the k-th element of a list
 * 
 * scala> nth(2, List(0, 1, 4, 10, 5, 8))
 * Int = 4
 * 
 */

import scala.annotation.tailrec

package object p03 {
    /**
     * Returns the nth element of a list using built-in
     * 
     * @param n the index of the element (starting from 0)
	 * @param ls the list
     */
	def nth01[A](n: Int, ls: List[A]) = ls(n)
	
	/**
	 * Returns the nth element of a list using tail recursion
	 * 
	 * @param n the index of the element (starting from 0)
	 * @param ls the list
	 */
	@tailrec
	def nth02[A](n: Int, ls: List[A]): A = {
	  if(ls.isEmpty || n < 0) throw new IndexOutOfBoundsException
	  else {
	    if(n == 0) ls(0)
	    else nth02(n-1, ls.tail)
	  }
	}
	
	/**
	 * Returns the nth element of a list using tail recursion and pattern matching
	 * 
	 * @param n the index of the element (starting from 0)
	 * @param ls the list
	 */
	@tailrec
	def nth03[A](n: Int, ls: List[A]): A = (n, ls) match {
	  case (0, ele :: _) => ele
	  case (n, _ :: tail) if n > 0 => nth03(n - 1, tail)
	  case _ => throw new IndexOutOfBoundsException
	}
	
	/**
	 * Returns the nth element of a list using an iterator
	 * 
	 * @param n the index of the element (starting from 0)
	 * @param ls the list
	 */
	def nth04[A](n: Int, ls: List[A]) = {
	  if(n < 0) throw new IndexOutOfBoundsException
	  
	  val iter = ls.iterator
	  var i = n
	  while(i > 0 && iter.hasNext) { 
	    iter.next
	    i-=1
	  }
	  
	  if(iter.hasNext) iter.next
	  else throw new IndexOutOfBoundsException
	}
}