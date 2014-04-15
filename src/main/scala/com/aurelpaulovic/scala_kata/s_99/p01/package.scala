package com.aurelpaulovic.scala_kata.s_99

/*
 * (*) Find the last element of a list
 * 
 * scala> last(List(1, 1, 2, 3, 5, 8))
 * Int = 8
 * 
 */

import scala.annotation.tailrec


package object p01 {
	/**
	 * Gets the last element of the list using built-in
	 * 
	 * @param ls the list
	 */
	def last01[A](ls: List[A]): A = ls.last
	
	
	/**
	 * Gets the last element of the list using tail-recursive inner function
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
	 * Gets the last element of the list reversing the list first and then returning the head of the reversed list
	 * 
	 * @param ls the list
	 */
	def last03[A](ls: List[A]) = ls.reverse.head
	
	/**
	 * Gets the last element of the list by "directly" accessing the last element
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
	 * Gets the last element of the list using foldLeft
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
	 * Gets the last element of the list using foldRight
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
	
// TODO:
// last using loop with iterator
// recursion using trampoline
}
