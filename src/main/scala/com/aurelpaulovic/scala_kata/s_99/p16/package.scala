package com.aurelpaulovic.scala_kata.s_99

/*
 * P16 (**) Drop every Nth element from a list.
 * 
 * Example:
 * scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 * res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
 */

package object p16 {
  def drop[A](n: Int, ls: List[A]): List[A] = n match {
    case 0 => ls
    case n if n > 0 => 
      for {
	      (e, idx) <- ls.zipWithIndex
	      if ((idx + 1) % n) != 0
      } yield e
    case n => 
      val len = ls.length
      val aN = n.abs
      for {
	      (e, idx) <- ls.zipWithIndex
	      if ((len - idx) % n) != 0
      } yield e
  } 
}