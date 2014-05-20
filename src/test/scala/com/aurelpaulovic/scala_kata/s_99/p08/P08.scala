package com.aurelpaulovic.scala_kata.s_99.p08

import com.aurelpaulovic.scala_kata.s_99.UnitSpec
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P08 extends UnitSpec {
	val funcs: List[(String, List[Any] => List[Any])] = List( // we could use type Any, but than we would have to assert using == ... I think there is no way to specify it better :(
			("compress01", compress01(_)),
			("compress02", compress02(_)),
			("compress03", compress03(_))
		)
		
	for((k, f) <- funcs) {
	  k should "return a list with consecutive duplicate elements removed" in {
	    val list = List(1, 1, 2, 2, 2, 3, 5, 1, 1, 2, 4)
	    
	    assert(f(list) === List(1, 2, 3, 5, 1, 2, 4))
	  }
	}
		
	for((k, f) <- funcs) {
	  k should "should return an empty list for an empty list" in {
	    val list = List()
	    
	    assert(f(list) === List())
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return a list with a single element for a list of the same elements" in {
	    val list = List('a', 'a', 'a', 'a', 'a', 'a')
	    
	    assert(f(list) === List('a'))
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return the same list for a list with single element" in {
	    val list = List('a')
	    
	    assert(f(list) === list)
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return the same list for a list with no consecutive duplicate elements" in {
	    val list = List(1, 4, 7, 8, 4, 1)
	    
	    assert(f(list) === list)
	  }
	}
}