package com.aurelpaulovic.scala_kata.s_99

/*
 * (*) Find the k-th element of a list
 * 
 * scala> nth(2, List(0, 1, 4, 10, 5, 8))
 * Int = 4
 * 
 */

package object p03 {
	def nth01[A](n: Int, ls: List[A]) = ls(n)
}