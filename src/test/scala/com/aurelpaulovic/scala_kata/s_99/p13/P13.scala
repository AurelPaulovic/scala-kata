package com.aurelpaulovic.scala_kata.s_99.p13

import com.aurelpaulovic.scala_kata.s_99.UnitSpec
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P13 extends UnitSpec {
	val funcs: List[(String, List[Any] => List[(Int, Any)])] = List(
			("encodeDirect", encodeDirect(_))
		)
		
	for((k, f) <- funcs) {
	  k should "return a run-length encoding of a list with consecutive duplicate elements" in {
	    val list = List(1, 1, 2, 2, 2, 3, 5, 1, 1, 2, 4)
	    
	    assert(f(list) === List((2, 1), (3, 2), (1, 3), (1, 5), (2, 1), (1, 2), (1, 4)))
	  }
	}
		
	for((k, f) <- funcs) {
	  k should "should return an empty list for an empty list" in {
	    val list = List()
	    
	    assert(f(list) === List())
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return a list with a single tuple consisting of the element and the lenght of the list for a list with a single repeated element" in {
	    val list = List('a', 'a', 'a', 'a', 'a', 'a')
	    
	    assert(f(list) === List((6, 'a')))
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return the a list with a single tuple with a single element and number 1 as run-length for a list with a single element" in {
	    val list = List('a')
	    
	    assert(f(list) === List((1, 'a')))
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return a list of single elements packed in run-length tuples of length 1 for a list with no consecutive duplicate elements" in {
	    val list = List(1, 4, 7, 8, 4, 1)
	    
	    assert(f(list) === List((1, 1), (1, 4), (1, 7), (1, 8), (1, 4), (1, 1)))
	  }
	}
}