package com.aurelpaulovic.scala_kata.s_99.p05

import com.aurelpaulovic.scala_kata.s_99.UnitSpec
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P05 extends UnitSpec {
	val funcs: List[(String, List[Any] => List[Any])] = List( // we could use type Any, but than we would have to assert using == ... I think there is no way to specify it better :(
			("reverse01", reverse01(_)),
			("reverse02", reverse02(_)),
			("reverse03", reverse03(_)),
			("reverse04", reverse04(_))
		)
		
	for((k, f) <- funcs) {
	  k should "return the the reverse of a list" in {
	    val list = List("a", 2, null)
	    
	    assert(f(list) === List(null, 2, "a"))
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return an empty list for an empty list" in {
	    val list = List()
	    
	    assert(f(list) === List())
	  }
	}
	
	for((k, f) <- funcs) {
	  k should "return a copy of a list for a lsit with single element" in {
	    val list = List(1)
	    
	    assert(f(list) === List(1))
	  }
	}
}