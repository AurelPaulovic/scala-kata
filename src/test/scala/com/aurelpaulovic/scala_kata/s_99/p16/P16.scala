package com.aurelpaulovic.scala_kata.s_99.p16

import com.aurelpaulovic.scala_kata.s_99.UnitSpec
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P16 extends UnitSpec {
	val funcs: List[(String, (Int, List[Any]) => List[Any])] = List(
			("drop", drop(_, _))
		)
		
	for((k, f) <- funcs) {
	  k should "return a list with every Nth element removed (indexed from 1)" in {
	    val list = List('a, 'b, 'c, 'a, 'b, 'd)
	    
	    assert(f(3, list) === List('a, 'b, 'a, 'b))
	  }
	}
		
	for((k, f) <- funcs) {
	  k should "should return an empty list for an empty list" in {
	    val list = List()
	    
	    assert(f(2, list) === List())
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return the same list if there are less than N elements" in {
	    val list = List('a, 'a)
	    
	    assert(f(3, list) === List('a, 'a))
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return the same list if N equals to 0" in {
	    val list = List('a, 'a)
	    
	    assert(f(0, list) === List('a, 'a))
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return a list with the last element removed, if the number of elements in the list is equal to N" in {
	    val list = List('a, 'b, 'c)
	    
	    assert(f(3, list) === List('a, 'b))
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return an empty list, if N equals to 1" in {
	    val list = List('a, 'b, 'c)
	    
	    assert(f(1, list) === List())
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return a list with every Nth element removed counted from the last element if the N is negative" in {
	    val list = List('a, 'b, 'c, 'e, 'f, 'g, 'h, 'i)
	    
	    assert(f(-2, list) === List('b, 'e, 'g, 'i))
	  }
	}
}