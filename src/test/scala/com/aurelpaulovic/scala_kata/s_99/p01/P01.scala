package com.aurelpaulovic.scala_kata.s_99.p01

import com.aurelpaulovic.scala_kata.s_99.UnitSpec
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P01 extends UnitSpec {
	"A last" should "return the last element of a non-empty list" in {
	  val list = List(1,2,3,4,5,5,6)
	  
	  assert(last01(list) === 6)
	  assert(last02(list) === 6)
	}
	
	"A last" should "should throw a NoSuchElementException of an empty-list" in {
	  val list = List()
	  
	  intercept[NoSuchElementException] {
	    last01(list)
	  }
	  intercept[NoSuchElementException] {
	    last02(list)
	  }
	}
	
	"A last" should "should return the only element of a list with a single element" in {
	  val list = List(2)
	  
	  assert(last01(list) === 2)
	  assert(last02(list) === 2)
	}
}