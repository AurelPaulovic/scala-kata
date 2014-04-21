package com.aurelpaulovic.scala_kata.s_99.p06

import com.aurelpaulovic.scala_kata.s_99.UnitSpec
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P06 extends UnitSpec {
	val funcs: List[(String, List[Any] => Boolean)] = List( // we could use type Any, but than we would have to assert using == ... I think there is no way to specify it better :(
			("palindrome01", palindrome01(_))
		)
		
	for((k, f) <- funcs) {
	  k should "return true, if the list is a palindrome and has odd number of elements" in {
	    val list = List(1, 4, 7, 4, 1)
	    
	    assert(f(list) === true)
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return true, if the list is a palindrome and has even number of elements" in {
	    val list = List(1, 4, 7, 7, 4, 1)
	    
	    assert(f(list) === true)
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return true on an empty list" in {
	    val list = List()
	    
	    assert(f(list) === true)
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return true for a list with one element" in {
	    val list = List(1)
	    
	    assert(f(list) === true)
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return false for a list that is not a palindrome and has even number of elements" in {
	    val list = List(1,2,3,4,4,3,3,1)
	    
	    assert(f(list) === false)
	  }
	}
	
		for((k, f) <- funcs) {
	  k should "return false for a list that is not a palindrome and has odd number of elements" in {
	    val list = List(1,2,3,4,5,4,3,3,1)
	    
	    assert(f(list) === false)
	  }
	}
}