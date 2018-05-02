package com.walmartlabs.smartpricing.example

object HelloWorld extends App{

  final val HELLO_WORLD = "Hello, world"

  def hello(): String = {
    var result = HELLO_WORLD
    // more logic that mutates the result
    result
  }
}
