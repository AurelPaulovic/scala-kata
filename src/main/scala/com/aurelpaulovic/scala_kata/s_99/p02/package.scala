package com.aurelpaulovic.scala_kata.s_99

/*
 * (*) Find the last but one element of a list
 * 
 * scala> last(List(1, 1, 2, 3, 5, 8))
 * Int = 5
 * 
 * (from: http://aperiodic.net/phil/scala/s-99/)
 */

import scala.annotation.tailrec

package object p02 {
	/**
	 * Returns the last but one element of a list using inner tail-recursive function
	 * 
	 * @param ls the list
	 */
	def lastButOne01[A](ls: List[A]) = {
	  @tailrec
	  def lastButOneInner[A](ls: List[A]): A = ls match {
	  	case ele :: _ :: Nil => ele
	  	case _ :: tail => lastButOneInner(tail)
	  	case _ => throw new NoSuchElementException
	  }
	  
	  lastButOneInner(ls) 
	}
	
	/**
	 * Returns the last but one element of a list by reversing the list first, dropping the first element and then returning the head of the resulting list
	 * 
	 * @param ls the list
	 */
	def lastButOne02[A](ls: List[A]) = ls.reverse.drop(1).head

	/**
	 * Returns the last but one element of a list by taking the last two elements of the list and returning the first of them
	 * 
	 * @param ls the list
	 */
	def lastButOne03[A](ls: List[A]) = {
	  val lastTwo = ls.takeRight(2)
	  if(lastTwo.size != 2) throw new NoSuchElementException
	  lastTwo.head
	}

	/**
	 * Returns the last but one element of a list by dropping the last element of the list first and then returning the last element of the resulting list
	 * 
	 * @param ls the list
	 */
	def lastButOne04[A](ls: List[A]) = ls.dropRight(1).last
	
	/**
	 * Returns the last but one element of a list by returning the last element of a init on a list
	 * 
	 * @param ls the list
	 */
	def lastButOne05[A](ls: List[A]) = {
	  if(ls.isEmpty) throw new NoSuchElementException
	  ls.init.last
	}
	
	/**
	 * Returns the last but one element of a list using a sliding iterator
	 * 
	 * @param ls the list
	 */
	def lastButOne06[A](ls: List[A]) = {
	  val iter = ls.sliding(2)
	  var window: List[A] = null
	  while(iter.hasNext) window = iter.next
	  
	  if(window != null && window.size == 2) window.head
	  else throw new NoSuchElementException
	}
	
	/**
	 * Returns the last but one element of a list using a foldLeft and a queue
	 * 
	 * @param ls the list
	 */
	def lastButOne07[A](ls: List[A]) = {
	  val q = new scala.collection.mutable.Queue[A]()
	  q += ls.head
	  q += ls.tail.head
	  
	  (q /: (ls drop 2))((a, b) => {
	    a += b
	    a.dequeue
	    a
	  }).dequeue
	}
}