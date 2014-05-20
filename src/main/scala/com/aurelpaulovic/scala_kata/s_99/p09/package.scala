package com.aurelpaulovic.scala_kata.s_99

/*
 * P09 (**) Pack consecutive duplicates of list elements into sublists.
 * If a list contains repeated elements they should be placed in separate
 * sublists.
 * 
 * Example:
 * scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
 * 
 * (from: http://aperiodic.net/phil/scala/s-99/) 
 */

import scala.annotation.tailrec

package object p09 {
	/**
	 * Pack consecutive duplicates into sublists using body-recursion, takeWhile and dropWhile
	 * 
	 * @param ls the list
	 */
	def pack01[A](ls: List[A]): List[List[A]] = ls match {
	  case Nil => List()
	  case h :: tail => ls.takeWhile(_ == h) :: pack01(tail.dropWhile(_ == h))
	} 
	
	/**
	 * Pack consecutive duplicates into sublists using fold and pattern matching
	 * 
	 * @param ls the list
	 */
	def pack02[A](ls: List[A]) = 
		(List[List[A]]() /: ls) { (acc: List[List[A]], ele) => acc match {
		  		case (h @ List(x, _*)) :: tail if x == ele => (ele :: h) :: tail
		  		case _ => List(ele) :: acc
			}
		}.reverse
		
	/**
	 * Pack consecutive duplicates into sublists using tail-recursion, takeWhile and dropWhile
	 * 
	 * @param ls the list
	 */
	def pack03[A](ls: List[A]) = {
		@tailrec
		def inner(ls: List[A], acc: List[List[A]]): List[List[A]] = ls match {
		  case Nil => acc.reverse
		  case h :: tail => inner(tail.dropWhile(_ == h), ls.takeWhile(_ == h) :: acc)
		}
		
		inner(ls, List())
	}
}