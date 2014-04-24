package com.aurelpaulovic.scala_kata.s_99

/*
 * (*) Check if a list is a palindrome
 * Example:
 * scala> palindrome(List(1, 4, 3, 4, 1))
 * res0: Boolean = true
 * 
 * (from: http://aperiodic.net/phil/scala/s-99/)
 */

package object p06 {
	/**
	 * Checks if the list is a palindrome using built-in
	 * 
	 * @param ls the list
	 */
	def palindrome01[A](xs: List[A]) = xs == xs.reverse
	
	/**
	 * Check if the list is a palindrome slicing the list in halfs and compare
	 * 
	 * @param ls the list
	 */
	def palindrome02[A](xs: List[A]) = {
	  val len = xs.length
	  
	  xs.take((len / 2) + (len % 2)) == xs.drop(len / 2).reverse
	}
}