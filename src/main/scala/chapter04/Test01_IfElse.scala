package chapter04

import scala.io.StdIn

object Test01_IfElse {
  def main(args: Array[String]): Unit = {
    println("年龄:")
    val age: Int = StdIn.readInt()

    // 1.单分支
    if (age > 18) {
      println("成年")
    }

    println("====================================")

    // 2.双分支
    if (age > 18) {
      println("成年")
    } else {
      println("未成年")
    }

    println("====================================")

    // 3.多分支
    // 分支语句的返回值
    val result: String = if (age <= 6) {
      "童年"
    } else if (age > 18) {
      "成年"
    } else {
      "未成年"
    }

    println("result:" + result)
  }
}
