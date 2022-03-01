package chapter04

import scala.util.control.Breaks
import scala.util.control.Breaks.{break, breakable}

/**
 * @title: Test06_Break
 * @projectName scala_tutorial
 * @description: TODO
 * @author kbmgs
 * @date 2022/3/1 22:18
 */
object Test06_Break {
  def main(args: Array[String]): Unit = {
    // 1.采用抛出异常的方式，退出循环
    try {
      for (i <- 0 until 5) {
        if (i == 3)
          throw new RuntimeException
        println(i)
      }
    } catch {
      case e: Exception => // 什么都不做，只是推出循环
    }
    println("这是循环体外")

    // 2.使用scala中的Breaks类的break方法，实现异常的抛出和捕获
    breakable(
      for (i <- 0 until 5) {
        if (i == 3)
          break()
        println(i)
      }
    )
  }
}


