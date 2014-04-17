package com.aurelpaulovic.scala_kata.s_99.p01

import com.aurelpaulovic.scala_kata.s_99.UnitSpec
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P01 extends UnitSpec {
	val funcs: List[(String, List[Int] => Int)] = List( // we could use type Any, but than we would have to assert using == ... I think there is no way to specify it better :(
			("last01", last01(_)), 
			("last02", last02(_)), 
			("last03", last03(_)), 
			("last04", last04(_)), 
			("last05", last05(_)),
			("last06", last06(_)),
			("last07", last07(_)),
			("last08", last08(_)),
			("last09", last09(_)),
			("last10", last10(_))
		)
		
	for((k, f) <- funcs) {
	  "A " + k should "return the the last element of a list" in {
	    val list = List(1,2,3,4,5,5,6)
	    
	    assert(f(list) === 6)
	  }
	}
	
	for((k, f) <- funcs) {
	  "A " + k should "should throw a NoSuchElementException of an empty-list" in {
	    val list = List()
	    
	    intercept[NoSuchElementException] {
	      f(list)
	    }
	  }
	}
	
	for((k, f) <- funcs) {
	  "A " + k should "return the only element of a list with a single element" in {
	    val list = List(2)
	    
	    assert(f(list) === 2)
	  }
	}
}