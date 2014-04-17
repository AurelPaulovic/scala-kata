package com.aurelpaulovic.scala_kata.s_99

/*
 * (*) Find the last element of a list
 * 
 * scala> last(List(1, 1, 2, 3, 5, 8))
 * Int = 8
 * 
 */

import scala.annotation.tailrec
import scala.util.control.TailCalls._

package object p01 {
	/**
	 * Returns the last element of a list using built-in
	 * 
	 * @param ls the list
	 */
	def last01[A](ls: List[A]): A = ls.last
	
	
	/**
	 * Returns the last element of a list using tail-recursive inner function
	 * 
	 * @param ls the list
	 */
	def last02[A](ls: List[A]): A = {
	  @tailrec
	  def last02Recursive[A](ls: List[A]): A = {
	    ls match {
	      case Nil => throw new NoSuchElementException
	      case ele :: Nil => ele
	      case _ :: tail => last02Recursive(tail)
	    }
	  }
	  
	  last02Recursive(ls)
	}
	
	/**
	 * Returns the last element of a list reversing the list first and then returning the head of the reversed list
	 * 
	 * @param ls the list
	 */
	def last03[A](ls: List[A]) = ls.reverse.head
	
	/**
	 * Returns the last element of a list by "directly" accessing the last element
	 * 
	 * @param ls the list
	 */
	def last04[A](ls: List[A]) = {
	  ls.length match {
	    case 0 => throw new NoSuchElementException
	    case idx => ls(idx - 1)
	  }
	}
	
	/**
	 * Returns the last element of a list using foldLeft
	 * 
	 * @param ls the list
	 */
	def last05[A](ls: List[A]) = {
	  ls.foldLeft(None: Option[A]) { (_, b) => 
	    Some(b)
	  } match {
	    case None => throw new NoSuchElementException
	    case Some(x) => x
	  }
	}
	
	/**
	 * Returns the last element of a list using foldRight
	 */
	def last06[A](ls: List[A]) = {
	  ls.foldRight(None: Option[A]) { (a, b) => b match {
	    case None => Some(a)
	    case _ => b
	  }} match {
	    case None => throw new NoSuchElementException
	    case Some(x) => x
	  }
	}
	
	/**
	 * Returns the last element of a list using a for loop with options
	 * 
	 * @param ls the list
	 */
	def last07[A](ls: List[A]) = {
	  var ret: Option[A] = None //we use option, so we can differentiate between no value (if the list was empty) and a value from list
	  for(x <- ls) ret = Some(x)
	  
	  ret match {
	    case None => throw new NoSuchElementException
	    case Some(x) => x
	  }
	}
	
	/**
	 * Returns the last element of a list using a for loop with flag
	 * 
	 * @param ls the list
	 */
	def last08[A](ls: List[A]) = {
	  var ret: A = null.asInstanceOf[A]
	  var found = false 
	  for(x <- ls) { //same way as last07 but instead of options (and having to instantiate an option with each iteration, we have a flag
	    found = true
	    ret = x
	  }
	  
	  if(!found) throw new NoSuchElementException
	  ret
	}
	
	/**
	 * Returns the last element of a list using an iterator
	 * 
	 * @param ls the list
	 */
	def last09[A](ls: List[A]) = {
	  /* let us do quick test first so that we do not have to use options or flags
	   * !! length might be O(n) ... depends on the implementation -> we better just test if there is at least one element
	   */
	  ls.head // will throw NoSucheElementException for us if the list is empty
	  
	  val iter = ls.iterator
	  var ret: A = null.asInstanceOf[A]
	  while(iter.hasNext) ret = iter.next
	  
	  ret
	}
	
	/**
	 * Returns the last element of a list using trampoline
	 * 
	 * @param ls the list
	 */
	def last10[A](ls: List[A]) = {
	  def last10Inner[A](ls: List[A]): TailRec[A] = {
	    ls match {
	      case Nil => throw new NoSuchElementException
	      case x :: Nil => done(x)
	      case _ :: tail => tailcall(last10Inner(tail))
	    }
	  }
	  
	  last10Inner(ls).result
	}
	
	/**
	 * Returns the last element of a list using do-while loop without having to specify a local variable holding the return with a default value  
	 * 
	 * @param ls the list
	 */
	def last11[A](ls: List[A]) = {
	  var curls = ls
	  
	  do {
		  curls = curls match {
		    case Nil => throw new NoSuchElementException
		    case ele :: Nil => List(ele)
		    case _ :: tail => tail
		  }
	  } while(curls match {
	    			case List(_) => false
	    			case _ => true
  				})
	  
	  curls.head
	}
}
