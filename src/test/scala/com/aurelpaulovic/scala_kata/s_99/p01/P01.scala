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
	  assert(last03(list) === 6)
	  assert(last04(list) === 6)
	  assert(last05(list) === 6, "last05")
	  assert(last06(list) === 6, "last06")
	  assert(last07(list) === 6, "last07")
	  assert(last08(list) === 6, "last08")
	  assert(last09(list) === 6, "last09")
	  assert(last10(list) === 6, "last10")
	}
	
	"A last" should "should throw a NoSuchElementException of an empty-list" in {
	  val list = List()
	  
	  intercept[NoSuchElementException] {
	    last01(list)
	  }
	  intercept[NoSuchElementException] {
	    last02(list)
	  }
	  
	  intercept[NoSuchElementException] {
	    last03(list)
	  }
	  
	  intercept[NoSuchElementException] {
	    last04(list)
	  }
	  
	  intercept[NoSuchElementException] {
	    last05(list)
	  }
	  
	  intercept[NoSuchElementException] {
	    last06(list)
	  }
	  
	  intercept[NoSuchElementException] {
	    last07(list)
	  }
	  
	  intercept[NoSuchElementException] {
	    last08(list)
	  }
	  
	  intercept[NoSuchElementException] {
	    last09(list)
	  }
	  
	  intercept[NoSuchElementException] {
	    last10(list)
	  }
	}
	
	"A last" should "should return the only element of a list with a single element" in {
	  val list = List(2)
	  
	  assert(last01(list) === 2)
	  assert(last02(list) === 2)
	  assert(last03(list) === 2)
	  assert(last04(list) === 2)
	  assert(last05(list) === 2)
	  assert(last06(list) === 2)
	  assert(last07(list) === 2)
	  assert(last08(list) === 2)
	  assert(last09(list) === 2)
	  assert(last10(list) === 2)
	}
}