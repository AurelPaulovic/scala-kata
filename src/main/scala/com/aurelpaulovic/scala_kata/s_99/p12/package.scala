package com.aurelpaulovic.scala_kata.s_99

/*
 * P12 (**) Decode a run-length encoded list.
 * Given a run-length code list generated as specified in problem P10,
 * construct its uncompressed version.
 *     
 * Example:
 * scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
 * res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
 * 
 */

package object p12 {
	/**
	 * Decode a run-legth encoded list
	 * 
	 * @param ls the list
	 */
	def decode[A](ls: List[(Int, A)]): List[A] = {
	  ls flatMap { case (num, c) => List.fill(num)(c) }
	}
}