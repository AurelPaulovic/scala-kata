package com.aurelpaulovic.scala_kata.s_99

/*
 * P08 (**) Eliminate consecutive duplicates of list elements.
 * If a list contains repeated elements they should be replaced with a
 * single copy of the element.  The order of the elements should not be
 * changed.
 *
 * Example:
 * scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
 *     
 * (from: http://aperiodic.net/phil/scala/s-99/)
 */

import scala.annotation.tailrec

package object p08 {
	/**
	 * Eliminate consecutive duplicates using fold
	 * 
	 * @param ls the list
	 */
	def compress01[A](ls: List[A]) =
		if (ls.isEmpty) ls
		else (List(ls.head) /: ls.tail) { (acc, ele) =>
				if (acc.head != ele) ele :: acc
				else acc
			 }.reverse
	
	/**
	 * Eliminate consecutive duplicates using tail-recursion	
	 * 
	 * @param ls the list
	 */
	def compress02[A](ls: List[A]) = {
		@tailrec
		def inner[A](ls: List[A], acc: List[A]): List[A] = (ls, acc) match {
			case (Nil, _) => acc
			case (h :: tail, ah :: _) if h == ah => inner(tail, acc)
			case (h :: tail, _) => inner(tail, h :: acc)
		}
		
		inner(ls, List()).reverse
	}	
		
	/**
	 * Eliminate consecutive duplicates using body-recursion
	 * 
	 * @param ls the list
	 */
	def compress03[A](ls: List[A]): List[A] = ls match {
	  case Nil => Nil
	  case h :: tail => h :: compress03(tail.dropWhile(_ == h))
	}
}