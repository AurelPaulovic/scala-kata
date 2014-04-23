package com.aurelpaulovic.scala_kata.s_99

/*
 * P07 (**) Flatten a nested list structure.
 * Example:
 * scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
 * res0: List[Any] = List(1, 1, 2, 3, 5, 8)
 */

package object p07 {
	/**
	 * Flatten list using recursion and flatMap
	 * 
	 * @param xs the list
	 */
	def flatten01[A](xs: List[Any]): List[Any] = xs flatMap {
	  case ls: List[_] => flatten01(ls)
	  case e => List(e)
	}
	
	/**
	 * Flatten list using stack, iterators and while loop
	 * 
	 * @param xs the list
	 */
	def flatten02[A](xs: List[Any]): List[Any] = {
	  val buf = new scala.collection.mutable.ListBuffer[Any]
	  val stack = new scala.collection.mutable.ArrayStack[Iterator[Any]]
	  var iter: scala.collection.Iterator[Any] = null
	  stack push xs.iterator
	  
	  while(! stack.isEmpty) {
	    iter = stack.pop
	    
	    while(iter.hasNext) {
	      iter.next match {
	        case ls: List[Any] => 
	          stack.push(iter)
	          iter = ls.iterator
	        case ele => buf += ele
	      }
	    }
	  }
	  
	  buf.toList
	}
}