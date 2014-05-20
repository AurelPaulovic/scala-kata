package com.aurelpaulovic.scala_kata.s_99.p09

import com.aurelpaulovic.scala_kata.s_99.UnitSpec
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P09 extends UnitSpec {
	val funcs: List[(String, List[Any] => List[List[Any]])] = List( // we could use type Any, but than we would have to assert using == ... I think there is no way to specify it better :(
			("pack01", pack01(_)),
			("pack02", pack02(_)),
			("pack03", pack03(_))
		)
		
	for((k, f) <- funcs) {
	  k should "return a list with all elements packed into lists where consecutive duplicates should be in the same list" in {
	    val list = List(1, 1, 2, 2, 2, 3, 5, 1, 1, 2, 4)
	    
	    assert(f(list) === List(List(1, 1), List(2, 2, 2), List(3), List(5), List(1, 1), List(2), List(4)))
	  }
	}
		
	for((k, f) <- funcs) {
	  k should "should return an empty list for an empty list" in {
	    val list = List()
	    
	    assert(f(list) === List())
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return a list with a single list with all the elements for a list of the same elements" in {
	    val list = List('a', 'a', 'a', 'a', 'a', 'a')
	    
	    assert(f(list) === List(List('a', 'a', 'a', 'a', 'a', 'a')))
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return the a list with a single list with a single element for a list with a single element" in {
	    val list = List('a')
	    
	    assert(f(list) === List(List('a')))
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return a list of single elements packed in lists a list with no consecutive duplicate elements" in {
	    val list = List(1, 4, 7, 8, 4, 1)
	    
	    assert(f(list) === List(List(1), List(4), List(7), List(8), List(4), List(1)))
	  }
	}
}