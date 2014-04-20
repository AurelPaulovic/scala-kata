package com.aurelpaulovic.scala_kata.s_99.p03

import com.aurelpaulovic.scala_kata.s_99.UnitSpec
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P03 extends UnitSpec {
	val funcs: List[(String, (Int, List[Int]) => Int)] = List( // we could use type Any, but than we would have to assert using == ... I think there is no way to specify it better :(
			("nth01", nth01(_,_)),
			("nth02", nth02(_,_)),
			("nth03", nth03(_,_))
		)
		
	for((k, f) <- funcs) {
	  "A " + k should "return the nth element of a list" in {
	    val list = List(1,2,3,4,5,6)
	    
	    for(i <- 0 to 5) {
	      assert(f(i, list) === i+1, k)
	    }
	  }
	}
	
	for((k, f) <- funcs) {
	  "A " + k should "throw a IndexOutOfBoundsException on an empty-list" in {
	    val list = List()
	    
	    intercept[IndexOutOfBoundsException] {
	      f(0, list)
	    }
	  }
	}
	
	for((k, f) <- funcs) {
	  "A " + k should "throw a IndexOutOfBoundsException on an index smaller than zero" in {
	    val list = List(1,2,3)
	    
	    intercept[IndexOutOfBoundsException] {
	      f(-1, list)
	    }
	  }
	}
	
	for((k, f) <- funcs) {
	  "A " + k should "throw a IndexOutOfBoundsException on an index greater than the number of elements in the list minus 1 " in {
	    val list = List(1,2,3)
	    
	    intercept[IndexOutOfBoundsException] {
	      f(3, list)
	    }
	    
	    intercept[IndexOutOfBoundsException] {
	      f(4, list)
	    }
	  }
	}
}