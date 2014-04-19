package com.aurelpaulovic.scala_kata.s_99.p02

import com.aurelpaulovic.scala_kata.s_99.UnitSpec
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P02 extends UnitSpec {
	val funcs: List[(String, List[Int] => Int)] = List( // we could use type Any, but than we would have to assert using == ... I think there is no way to specify it better :(
			("lastButOne01", lastButOne01(_)),
			("lastButOne02", lastButOne02(_)),
			("lastButOne03", lastButOne03(_)),
			("lastButOne04", lastButOne04(_))
		)
		
	for((k, f) <- funcs) {
	  "A " + k should "return the the last but on element of a list" in {
	    val list = List(1,2,3,4,4,5,6)
	    
	    assert(f(list) === 5)
	  }
	}
	
	for((k, f) <- funcs) {
	  "A " + k should "should throw a NoSuchElementException on an empty-list" in {
	    val list = List()
	    
	    intercept[NoSuchElementException] {
	      f(list)
	    }
	  }
	}
	
	for((k, f) <- funcs) {
	  "A " + k should "should throw a NoSuchElementException on a list with single element" in {
	    val list = List(2)
	    
	    intercept[NoSuchElementException] {
	      f(list)
	    }
	  }
	}
}