package com.aurelpaulovic.scala_kata.s_99

/*
 * (*) Check if a list is a palindrome
 * Example:
 * scala> palindrome(List(1, 4, 3, 4, 1))
 * res0: Boolean = true
 */

package object p06 {
	/**
	 * Checks if the list is a palindrome using built-in
	 * 
	 * @param ls the list
	 */
	def palindrome01[A](xs: List[A]) = xs == xs.reverse
}