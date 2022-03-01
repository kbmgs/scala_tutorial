package chapter04

/**
 * @title: Test05_WhileLoop
 * @projectName scala_tutorial
 * @description: TODO
 * @author kbmgs
 * @date 2022/3/1 22:06
 */
object Test05_WhileLoop {
  def main(args: Array[String]): Unit = {
    //while
    var a: Int = 10
    while (a >= 1) {
      println("this is a while loop: " + a)
      a -= 1
    }

    //do-while
    var b: Int = 0
    do {
      println("this is a do-while loop: " + b)
      b -= 1
    } while (b > 0)

  }

}
