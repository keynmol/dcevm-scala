package bla

import scala.util._

object Main extends App {
    val javaInst = new JavaClass()
    val scalaInst = ScalaClass

    while(true){
        val number = Random.nextInt % 20
        println(s"Java can do ${javaInst.magicMath(number)}. Scala can do ${scalaInst.magicMath(number)}")
        Thread.sleep(1000)
    }
}
