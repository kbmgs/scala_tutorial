package chapter05

/**
 * @title: Test12_MyWhile
 * @projectName scala_tutorial
 * @description: TODO
 * @author kbmgs
 * @date 2022/3/3 13:57
 */
object Test12_MyWhile {
  // 实现一个自定义的while循环
  def main(args: Array[String]): Unit = {
    var n = 10 // 变量n

    // 1.常规的while循环
    while (n >= 1) {
      println(n)
      n -= 1
    }

    println("=========================")

    // 2.用闭包实现一个函数，将代码块作为参数传入，递归调用
    def myWhile(condition: => Boolean): (=> Unit) => Unit = {
      // 内层函数需要递归调用，参数是循环体
      def doLoop(op: => Unit): Unit = {
        if (condition) {
          op
          myWhile(condition)(op)
        }
      }
      doLoop _ //doLoop的函数体作为myWhile的返回
    }

    n = 10
    // n>=1作为 =>Boolean 的代码块，传入condition
    // 第二个括号里作为闭包的第二组参数，将函数体作为 =>Unit的代码块 传入op
    myWhile(n >= 1)({
      //op
      println(n)
      n -= 1
    })

    println("=========================")

    // 3.用匿名函数实现
    def myWhile2(condition: => Boolean): (=> Unit) => Unit = {
      op => {
        if (condition) {
          op
          myWhile2(condition)(op)
        }
      }
    }

    n = 10
    myWhile2(n >= 1)({
      println(n)
      n -= 1
    })

    println("=========================")

    // 3.柯里化实现
    // 第一个括号为返回Boolean类型的传名参数，第二个为返回Unit类型的传名参数
    def myWhile3(condition: => Boolean)(op: => Unit): Unit = {
      if (condition) {
        op
        myWhile3(condition)(op)
      }
    }

    n = 10
    myWhile3(n >= 1)({
      println(n)
      n -= 1
    })
  }

}
