package com.apischan.stanfytest

object abstractTypes {

  def main(args: Array[String]): Unit = {
    implicit val str = "abcd"

    val s = implicitly[String]

    println(s)
  }

}
