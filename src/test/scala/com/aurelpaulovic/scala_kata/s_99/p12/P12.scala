package com.aurelpaulovic.scala_kata.s_99.p12

import com.aurelpaulovic.scala_kata.s_99.UnitSpec
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P12 extends UnitSpec {
	val funcs: List[(String, List[(Int, Any)] => List[Any])] = List( 
			("decode", decode(_))
		)
		
	for((k, f) <- funcs) {
	  k should "return a list with duplicate elements for a run-length encoded list" in {
	    val list: List[(Int, Any)] = List((2, 'a'), (3, 'b'), (1, 'c'), (1, 'd'), (2, 'e'), (1, 'b'), (1, 'd'))
	    
	    assert(f(list) === List('a', 'a', 'b', 'b', 'b', 'c', 'd', 'e', 'e', 'b', 'd'))
	  }
	}
		
	for((k, f) <- funcs) {
	  k should "should return an empty list for an empty list" in {
	    val list = List()
	    
	    assert(f(list) === List())
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return a list with a single repeated element fot a run-length encoded list with a single tuple" in {
	    val list = List((6, 'a'))
	    
	    assert(f(list) === List('a', 'a', 'a', 'a', 'a', 'a'))
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return a list with a single element for a run-length encoded list with a single tuple of (1, _)" in {
	    val list = List((1, 'a'))
	    
	    assert(f(list) === List('a'))
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return a without any consecutive duplicate elements for a run-length encoded list with all tuples of the form (1, _)" in {
	    val list = List((1, 'a'), (1, 'b'), (1, 'c'), (1, 'b'), (1, 'a'), (1, 'c'))
	    
	    assert(f(list) === List('a', 'b', 'c', 'b', 'a' , 'c'))
	  }
	}
}