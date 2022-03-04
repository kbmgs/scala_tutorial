package chapter04

/**
 * 闭包
 */

object Test09_ClosureAndCurrying {
  def main(args: Array[String]): Unit = {
    def add(a: Int, b: Int): Int = {
      a + b
    }

    // 1.考虑固定一个加数的场景
    def addByFour(b: Int): Int = {
      4 + b
    }

    // 2.扩展固定加数改变的情况
    def addByFive(b: Int): Int = {
      5 + b
    }

    // 3.将固定加数作为另一个参数传入，但是是作为“第一层参数”传入，分层传入
    def addByFour1(): Int => Int = {
      // 内部定义局部变量，传入内部的函数中
      val a = 4
      def addB(b: Int): Int = {
        a + b
      }

      addB
    }

    // 进一步：将定义局部变量变成外层函数的参数传入，此时有外层+内层函数
    // 以内层函数作为返回值，定义外层函数
    def addByFour2(a: Int): Int => Int = {
      def addB(b: Int): Int = {
        a + b
      }
      addB
    }


  }
}
