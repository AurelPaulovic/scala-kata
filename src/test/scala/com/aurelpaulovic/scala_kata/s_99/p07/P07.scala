package com.aurelpaulovic.scala_kata.s_99.p07

import com.aurelpaulovic.scala_kata.s_99.UnitSpec
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P07 extends UnitSpec {
	val funcs: List[(String, List[Any] => List[Any])] = List( // we could use type Any, but than we would have to assert using == ... I think there is no way to specify it better :(
			("flatten01", flatten01(_)),
			("flatten02", flatten02(_)),
			("flatten03", flatten03(_))
		)
		
	for((k, f) <- funcs) {
	  k should "should return a flat list for a nested list" in {
	    val list = List(1, List(), List(2, 3, List(4, 5), List(6)), List(), 7, 8, List(List()), List(9, 10))
	    
	    assert(f(list) === List(1,2,3,4,5,6,7,8,9,10))
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return an empty list for an empty list" in {
	    val list = List[Any]()
	    
	    assert(f(list) === List())
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return an empty list for an empty list of nested empty lists" in {
	    val list = List(List(), List(), List(List()), List(List(List(), List(), List(), List())), List())
	    
	    assert(f(list) === List())
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return the same list for a flat list" in {
	    val list = List(1, 4, 7, 8, 4, 1)
	    
	    assert(f(list) === list)
	  }
	}
}