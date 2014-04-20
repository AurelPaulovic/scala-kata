package com.aurelpaulovic.scala_kata.s_99.p04

import com.aurelpaulovic.scala_kata.s_99.UnitSpec
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P0$ extends UnitSpec {
	val funcs: List[(String, List[Any] => Int)] = List( // we could use type Any, but than we would have to assert using == ... I think there is no way to specify it better :(
			("length01", length01(_)),
			("length02", length02(_)),
			("length03", length03(_)),
			("length04", length04(_)),
			("length05", length05(_))
		)
		
	for((k, f) <- funcs) {
	  k should "return the number of elements in a list" in {
	    val list = List("a", 2, null)
	    
	    assert(f(list) === 3)
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return 0 for an empty list" in {
	    val list = List()
	    
	    assert(f(list) === 0)
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return 1 for a list with one element" in {
	    val list = List(null)
	    
	    assert(f(list) === 1)
	  }
	}
}