package com.aurelpaulovic.scala_kata.s_99.p01

import com.aurelpaulovic.scala_kata.s_99.UnitSpec
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class P01 extends UnitSpec {
	"A last01" should "return the last element of a list" in {
	  val list = List(1,2,3,4,5,5,6)
	  assert(last01(list) === 6)
	}
	
	"A last02" should "return the last element of a list" in {
	  val list = List(1,2,3,4,5,5,6)
	  assert(last02(list) === 6)
	}
}