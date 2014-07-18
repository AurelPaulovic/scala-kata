package com.aurelpaulovic.scala_kata.s_99

/*
 * P14 (*) Duplicate the elements of a list.
 * Example:
 * scala> duplicate(List('a, 'b, 'c, 'c, 'd))
 * res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
 *   
 */

package object p14 {
  def duplicate[A](ls: List[A]): List[A] = ls.map((e) => Seq(e, e)).flatten
  
  def duplicate02[A](ls: List[A]): List[A] = ls flatMap { e => Seq(e, e) }
}