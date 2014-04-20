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
	def nth01[A](n: Int, ls: List[A]) = ls(n)
	
	@tailrec
	def nth02[A](n: Int, ls: List[A]): A = {
	  if(ls.isEmpty || n < 0) throw new IndexOutOfBoundsException
	  else {
	    if(n == 0) ls(0)
	    else nth02(n-1, ls.tail)
	  }
	}
	
	@tailrec
	def nth03[A](n: Int, ls: List[A]): A = (n, ls) match {
	  case (0, ele :: _) => ele
	  case (n, _ :: tail) if n > 0 => nth03(n - 1, tail)
	  case _ => throw new IndexOutOfBoundsException
	}
}