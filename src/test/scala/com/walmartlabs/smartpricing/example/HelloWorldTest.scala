package com.walmartlabs.smartpricing.example

import org.scalatest.FunSuite

class HelloWorldTest extends FunSuite{

  test("Basic Hello World test") {
    assertResult(HelloWorld.HELLO_WORLD)(HelloWorld.hello())
  }

}
