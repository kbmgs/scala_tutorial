package chapter05

import scala.annotation.tailrec

/**
 * @title: Test10_Recursion
 * @projectName scala_tutorial
 * @description: TODO
 * @author kbmgs
 * @date 2022/3/2 21:32
 */
object Test10_Recursion {
  def main(args: Array[String]): Unit = {
    println(fact(5))
  }

  // 递归实现阶乘
  // 普通递归有可能出现栈空间溢出
  def fact(n: Int): Int = {
    if (n == 0) return 1 //此处return要保留
    fact(n - 1) * n //最后一行可省略return
  }

  // 尾递归调用
  // 尾递归节省栈空间
  def tailFact(n: Int): Int = {
    @tailrec //注解，确保写出的是尾递归函数，否则报错
    def loop(n: Int, currRes: Int): Int = {
      if (n == 0) return currRes // currRes:保存当前计算的结果
      loop(n - 1, currRes * n)
    }
    loop(n, 1)
  }


}
