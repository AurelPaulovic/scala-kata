package com.aurelpaulovic.scala_kata.s_99

/*
 * P13 (**) Run-length encoding of a list (direct solution).
 * Implement the so-called run-length encoding data compression method
 * directly.  I.e. don't use other methods you've written (like P09's
 * pack); do all the work directly.
 * 
 * Example:
 * scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
 */

import scala.annotation.tailrec
package object p13 {
	def encodeDirect[A](ls: List[A]): List[(Int, A)] = {
	  @tailrec
	  def inner[A](ls: List[A], acc: List[(Int, A)]): List[(Int, A)] = ls span (_ == ls.head) match {
	    case (List(), List()) => acc.reverse
	    case (condup, rest) => inner(rest, (condup.length, condup.head) :: acc)
	  }
	  
	  inner(ls, List())
	}
}