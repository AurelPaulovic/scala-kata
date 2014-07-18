package com.aurelpaulovic.scala_kata.s_99

/* 
 * P11 (*) Modified run-length encoding.
 * Modify the result of problem P10 in such a way that if an element has no
 * duplicates it is simply copied into the result list.  Only elements with
 * duplicates are transferred as (N, E) terms.

 * Example:
 * scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
 */

package object p11 {
	import p10.encode
	
	def encodeModified[A](ls: List[A]): List[Any] = {
	  encode(ls) map { 
	    case (e, 1) => e
	    case t@(e, x) => t
	  }
	}
}