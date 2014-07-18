package com.aurelpaulovic.scala_kata.s_99.p14

import com.aurelpaulovic.scala_kata.s_99.UnitSpec
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P14 extends UnitSpec {
	val funcs: List[(String, List[Any] => List[Any])] = List(
			("duplicate", duplicate(_))
		)
		
	for((k, f) <- funcs) {
	  k should "return a list with elements duplicated" in {
	    val list = List('a, 'b, 'c, 'a, 'b, 'b)
	    
	    assert(f(list) === List('a, 'a, 'b, 'b, 'c, 'c, 'a, 'a, 'b, 'b, 'b, 'b))
	  }
	}
		
	for((k, f) <- funcs) {
	  k should "should return an empty list for an empty list" in {
	    val list = List()
	    
	    assert(f(list) === List())
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return a list with an repeated element for a list with a single element" in {
	    val list = List('a)
	    
	    assert(f(list) === List('a, 'a))
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return a list with 4 identical elements for a list with 2 identical elements" in {
	    val list = List('a, 'a)
	    
	    assert(f(list) === List('a, 'a, 'a, 'a))
	  }
	}
}