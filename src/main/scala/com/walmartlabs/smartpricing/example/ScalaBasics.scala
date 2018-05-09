package com.walmartlabs.smartpricing.example

import scala.concurrent.{Await, ExecutionContext, Future}

class DefaultScala extends AnyRef with ScalaBasics with ScalaAdvanced {

  @Override
  override protected var myCollection = scala.collection.mutable.Seq[String]()

  @Override
  override protected val myVariable: String = "MyString"
}

object ScalaBasics {

  def create: ScalaBasics = {
    (new DefaultScala()).~~("something")
  }

  def stringify[E](input: => E)(format: String = "")(implicit p: ExecutionContext): String = {
    import scala.concurrent.duration._
    Await.result(Future{s"Format[$format]:${input.toString}"}, 10.seconds)
  }

}




trait ScalaBasics {

  protected val myVariable: String
  protected var myCollection: scala.collection.mutable.Seq[String]

  def hasHello(): Boolean  = {
    !myCollection.filter(x => x == "Hello").isEmpty
  }


  def run(input: (String) => Unit): Unit ={
    input.apply(myVariable)
  }

  def ~~(input: String): ScalaBasics = {
    myCollection = myCollection :+ input
    this
  }


}

trait ScalaAdvanced {

  def nextSessionName() = "ScalaAdvanced"
}

trait CurriedLogger {

  def log(input: (String) => String, arg: String) = {
    println(input(arg))
  }

  private def  wrapLogs(logLevel: String)(argument:String): String = {
    s"Logging at $logLevel and showing the content of the argument $argument"
  }

  def logWrapped(arg: String): Unit = {
    log(wrapLogs("INFO"), arg)
  }
}