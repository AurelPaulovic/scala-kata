package com.aurelpaulovic.scala_kata.s_99

/*
 * P07 (**) Flatten a nested list structure.
 * Example:
 * scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
 * res0: List[Any] = List(1, 1, 2, 3, 5, 8)
 */

import scala.annotation.tailrec
import scala.collection.mutable.ArrayStack

package object p07 {
	/**
	 * Flatten list using recursion and flatMap
	 * 
	 * @param xs the list
	 */
	def flatten01(xs: List[Any]): List[Any] = xs flatMap {
	  case ls: List[_] => flatten01(ls)
	  case e => List(e)
	}
	
	/**
	 * Flatten list using stack, iterators and while loop
	 * 
	 * @param xs the list
	 */
	def flatten02(xs: List[Any]): List[Any] = {
	  val buf = new scala.collection.mutable.ListBuffer[Any]
	  val stack = new ArrayStack[Iterator[Any]]
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
	
	/**
	 * Flatten list using tail-recursive function and pattern matching
	 * 
	 * @param xs the list
	 */
	def flatten03(xs: List[Any]): List[Any] = {
	  @tailrec
	  def flattenInner(xs: List[Any], acc: List[Any]): List[Any] = xs match {
	      case (sub: List[_]) :: tail  => flattenInner(sub ++ tail, acc)
	      case ele :: tail => flattenInner(tail, ele :: acc)
	      case Nil => acc
	  }
	  
	  flattenInner(xs, List()).reverse
	}
	
	/**
	 * Flatten list using tail-recursive function and pattern matching with stack instead of list concat
	 * 
	 * @param xs the list
	 */
	def flatten04(xs: List[Any]): List[Any] = {
	  @tailrec
	  def flattenInner(xs: List[Any], stack: ArrayStack[List[Any]], acc: List[Any]): List[Any] = xs match {
	    case Nil => 
	      if (stack.isEmpty) acc
	      else flattenInner(stack.pop(), stack, acc)
	    case (sub: List[_]) :: tail => flattenInner(sub, stack += tail, acc)
	    case ele :: tail => flattenInner(tail, stack, ele :: acc)

	  }
	  
	  flattenInner(xs,new ArrayStack, List()).reverse
	}
}