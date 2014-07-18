package com.aurelpaulovic.scala_kata.s_99.p15

import com.aurelpaulovic.scala_kata.s_99.UnitSpec
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P15 extends UnitSpec {
	val funcs: List[(String, (Int, List[Any]) => List[Any])] = List(
			("duplicateN", duplicateN(_, _))
		)
		
	for((k, f) <- funcs) {
	  k should "return a list with elements duplicated N times" in {
	    val list = List('a, 'b, 'c, 'a, 'b, 'b)
	    
	    assert(f(3, list) === List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'a, 'a, 'a, 'b, 'b, 'b, 'b, 'b, 'b))
	  }
	}
		
	for((k, f) <- funcs) {
	  k should "should return an empty list for an empty list" in {
	    val list = List()
	    
	    assert(f(2, list) === List())
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return a list with an repeated element for a list with a single element" in {
	    val list = List('a)
	    
	    assert(f(3, list) === List('a, 'a, 'a))
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return an empty list if the times to repeat the element is set to zero" in {
	    val list = List('a, 'b, 'c)
	    
	    assert(f(0, list) === List())
	  }
	}
}